package com.quiz.codequiz.controller;

import com.quiz.codequiz.model.Question;
import com.quiz.codequiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping (value = "/allQuestion")
    public ResponseEntity< List<Question>> getAllQuestion(){

        return questionService.getAllQuestion();
    }
    @GetMapping(value="category/{category}")
    public ResponseEntity<List<Question>>getQuestionByCategory(@PathVariable String category){
        return  questionService.getQuestionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity <String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<String> deleteQuestion(Question question){
        return questionService.deleteQuestion(question);
    }

    @PutMapping(value="/update/{id}")
     public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
     }
}
