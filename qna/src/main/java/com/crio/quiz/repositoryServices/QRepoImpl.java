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
public class QRepoImpl  {
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
     //    List<Questions> questions = new ArrayList<>();
        for (QuestionEntity q: results) {
            questions.add(mapper.map(q,Questions.class));
        }
 
        return questions;
 
     }

     public List<Questions> getmaskeQuestions() {
        List<MaskQuestionEntity> results = maskedRepository.findAll();
        // List<MaskQuestion> questions = new ArrayList<>();
        ModelMapper mapper = modelMapperProvider.get();
        List<Questions> questions = new ArrayList<>();
        System.out.println(results.get(0).getQuestions());
        for (QuestionEntity q : results.get(0).getQuestions()) {
            questions.add(mapper.map(q, Questions.class));
        }
        // for (MaskQuestionEntity mask: results.get(0)) {
        //     questions.add(mapper.map(mask, MaskQuestion.class));

        // }
        // System.out.println(qe);
        return questions;
        
    }
    
}