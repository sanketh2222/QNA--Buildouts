package com.crio.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
// import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
// @Setter
// @AllArgsConstructor
// @Builder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Questions {
    private String questionId;
    private String title;
    private String description;
    private String type;
    private Map<String,String> options;
    private List<String> userAnswer;
   
    private List<String> correct;
    private String explanation;

     // @Builder.Default
     private boolean answerCorrect = false;// throws error for model mapping with questuon entity
}