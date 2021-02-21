package com.crio.quiz.repositoryServices;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;

import com.crio.quiz.dto.Questions;
import com.crio.quiz.models.QuestionEntity;
import com.crio.quiz.repository.QuestionRepository;
import com.crio.quiz.models.MaskQuestionEntity;

import com.crio.quiz.repository.MaskedRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class QRepoServiceImpl  {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    private MaskedRepository maskedRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    List<Questions> questions = new ArrayList<>();
    
    public List<Questions> getQuestions() {
        ModelMapper mapper = modelMapperProvider.get();
        List<QuestionEntity> results = questionRepository.findAll();

        for (QuestionEntity q: results) {
            questions.add(mapper.map(q,Questions.class));
        }
 
        return questions;
 
     }

     public List<Questions> getmaskeQuestions() {
        List<MaskQuestionEntity> results = maskedRepository.findAll();
  
        ModelMapper mapper = modelMapperProvider.get();
        List<Questions> questions = new ArrayList<>();
    
        for (QuestionEntity q : results.get(0).getQuestions()) {
            questions.add(mapper.map(q, Questions.class));
        }

        return questions;
        
    }
    
}