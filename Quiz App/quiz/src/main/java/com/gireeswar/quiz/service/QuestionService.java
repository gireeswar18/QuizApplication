package com.gireeswar.quiz.service;

import com.gireeswar.quiz.dao.QuestionDao;
import com.gireeswar.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions ()
    {
        try {
            List<Question> questionList = questionDao.findAll();
            return new ResponseEntity<>(questionList, HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory (String category)
    {
        try {
            return new ResponseEntity<>(questionDao.getQuestionByCategory(category), HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion (Question question)
    {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Successfully Added!", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ResponseEntity<>("Unable to Add!", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateQuestion (Question question)
    {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Updated Successfully!", HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ResponseEntity<>("Unable to Update!", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion (int id)
    {
        try
        {
            questionDao.deleteById(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return new ResponseEntity<>("Unable to Delete!", HttpStatus.BAD_REQUEST);
    }
}
