package com.crio.quiz.exchange;
import com.crio.quiz.dto.*;

import lombok.Data;

import java.util.*;

@Data
public class GetQuestResponse {
    List<Questions> questions;  
    // private boolean answerCorrect;  
    private Summary summary;
    // private Map<String,String> summary;
}