package com.crio.quiz.service;

import java.util.List;

import com.crio.quiz.dto.Questions;
import com.crio.quiz.exchange.GetQuestRequest;
import com.crio.quiz.exchange.GetQuestResponse;

public interface QuestionService {
    public GetQuestResponse validate(GetQuestRequest userResponses);
    public List<Questions> getmaskdata();
    public List<Questions> getdata();
}