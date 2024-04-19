package com.gireeswar.quiz.service;

import com.gireeswar.quiz.dao.QuestionDao;
import com.gireeswar.quiz.dao.QuizDao;
import com.gireeswar.quiz.model.Question;
import com.gireeswar.quiz.model.QuestionWrapper;
import com.gireeswar.quiz.model.Quiz;
import com.gireeswar.quiz.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz (String category, int numQ, String quizTitle)
    {
        try {
            List<Question> questionList = questionDao.findRandomQuestionByCategory(category, numQ);

            Quiz quiz = new Quiz();
            quiz.setTitle(quizTitle);
            quiz.setQuestions(questionList);
            quizDao.save(quiz);

            return new ResponseEntity<>("Successfully Created!", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ResponseEntity<>("Not Created!", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz (Integer quizId)
    {
        try
        {
            Optional<Quiz> quiz = quizDao.findById(quizId);
            List<Question> questionList = quiz.get().getQuestions();
            List<QuestionWrapper> questionForUsers = new ArrayList<>();

            for (Question question : questionList)
            {
                QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestionTitle(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
                questionForUsers.add(questionWrapper);
            }
            return new ResponseEntity<>(questionForUsers, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> submitQuiz (Integer id, List<Response> responses)
    {
        try
        {
            Optional<Quiz> quiz = quizDao.findById(id);
            List<Question> questionList = quiz.get().getQuestions();
            int marks = 0;
            int i = 0;

            for (Response response : responses)
            {
                if (response.getResponse().equals(questionList.get(i).getRightAnswer()))
                {
                    marks++;
                }
                i++;
            }
            return new ResponseEntity<>(marks, HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ResponseEntity<>(0, HttpStatus.BAD_REQUEST);
    }
}
