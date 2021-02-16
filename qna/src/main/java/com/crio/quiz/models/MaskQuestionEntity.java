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

@Data
@Document(collection = "myData")
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaskQuestionEntity {

    @Id
    private String id;

    @NotNull
    List<QuestionEntity> questions;
    
}