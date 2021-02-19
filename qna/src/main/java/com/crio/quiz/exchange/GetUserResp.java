package com.crio.quiz.exchange;

import com.crio.quiz.dto.UserResponse;

import java.util.*;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Setter
// @Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResp {

    // private String questionId;
    // private List<String> userResponse; 
    // @NotNull
    List<UserResponse> responses;
    
}