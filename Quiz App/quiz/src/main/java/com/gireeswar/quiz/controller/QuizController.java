package com.gireeswar.quiz.controller;

import com.gireeswar.quiz.model.QuestionWrapper;
import com.gireeswar.quiz.model.Response;
import com.gireeswar.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")

public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz (@RequestParam String category, @RequestParam int numQ, @RequestParam String quizTitle)
    {
        return quizService.createQuiz(category, numQ, quizTitle);
    }

    @GetMapping("/getQuiz/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz (@PathVariable Integer quizId)
    {
        return quizService.getQuiz(quizId);
    }

    @PostMapping("/submitQuiz/{id}")
    public ResponseEntity<Integer> submitQuiz (@PathVariable Integer id, @RequestBody List<Response> responses)
    {
        return quizService.submitQuiz(id, responses);
    }

}
