package com.gireeswar.quiz.controller;

import com.gireeswar.quiz.model.Question;
import com.gireeswar.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionsController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions ()
    {
        return questionService.getAllQuestions();
    }

    @GetMapping("/getQuestionByCategory/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory (@PathVariable("category") String category)
    {
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion (@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }

    @PutMapping("/updateQuestion")
    public ResponseEntity<String> updateQuestion (@RequestBody Question question)
    {
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("/deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion (@PathVariable("id") int id)
    {
        return questionService.deleteQuestion(id);
    }
}
