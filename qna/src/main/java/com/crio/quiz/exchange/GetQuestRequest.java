package com.crio.quiz.exchange;

import com.crio.quiz.dto.UserResponse;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetQuestRequest {

    // private String questionId;
    // private List<String> userResponse; 
    List<UserResponse> responses;
    
}