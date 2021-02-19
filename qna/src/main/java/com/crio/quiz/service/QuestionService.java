package com.crio.quiz.service;

import java.util.List;

import com.crio.quiz.dto.Questions;
import com.crio.quiz.exchange.GetUserResp;
import com.crio.quiz.exchange.GetQuestResponse;

public interface QuestionService {
    public GetQuestResponse validate(GetUserResp userResponses);
    public List<Questions> getmaskdata();
    public List<Questions> getdata();
}