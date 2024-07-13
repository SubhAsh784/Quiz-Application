package com.quiz.codequiz.controller;

import com.quiz.codequiz.model.Question;
import com.quiz.codequiz.model.QuestionWrapper;
import com.quiz.codequiz.model.Response;
import com.quiz.codequiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int num, @RequestParam String Title) {
        return quizService.createQuiz(category, num, Title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return  quizService.calculateResult(id,responses);
    }


}