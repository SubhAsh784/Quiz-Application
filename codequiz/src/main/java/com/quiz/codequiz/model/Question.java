package com.quiz.codequiz.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="question")
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
private Integer id;
private String question;
private String option1;
private String option2;
private String option3;
private String option4;
private String category;

private String DifficultyLevel;

private String CorrectAns;
}
