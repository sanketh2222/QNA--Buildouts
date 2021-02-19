package com.crio.quiz.exchange;
import com.crio.quiz.dto.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetQuestResponse {
 
    List<Questions> questions;  
    // private boolean answerCorrect;  
    private Summary summary;
    // private Map<String,String> summary;
}