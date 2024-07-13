package com.quiz.codequiz.service;

import com.quiz.codequiz.dao.QuestionDao;
import com.quiz.codequiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class QuestionService {
    @Autowired
    QuestionDao questionDao;



    public ResponseEntity< List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        };
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    public ResponseEntity <String> addQuestion(Question question) {
        try {
            questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }catch(Exception e){
            e.printStackTrace();
        }
   return new ResponseEntity<>("failed",HttpStatus.NOT_ACCEPTABLE);

    }

    public ResponseEntity<String> deleteQuestion(Question question) {
        try {


            questionDao.deleteById(question.getId());
            return new ResponseEntity<>("success", HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed to delete",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        try{

            questionDao.findById(question.getId());
            question.setQuestion(question.getQuestion());
            question.setCategory(question.getCategory());
            question.setId(question.getId());
            questionDao.save(question);

            return new ResponseEntity<String>("updated",HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<String>("not updated",HttpStatus.BAD_REQUEST);
    }
}
