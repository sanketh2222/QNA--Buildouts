package com.crio.quiz.dto;

import lombok.Data;

import java.util.List;


@Data
public class UserResponse {

    
    private String questionId;
    private List<String> userResponse; 
    
}