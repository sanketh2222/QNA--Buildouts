package com.crio.quiz.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Java class that maps to Mongo collection.
@Data
@Document(collection = "questions")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionEntity {

    @Id
    private String id;

    @NotNull
    private String questionId;

    @NotNull
    private String title;

    @NotNull
    private String type;

    @NotNull
    private String description;

    private boolean answerCorrect;

    @NotNull
    private Map<String,String> options = new HashMap<>();

    @NotNull
    private List<String> correctAnswer = new ArrayList<>();

    // @NotNull
    // private List<String> correct = new ArrayList<>();
    
}