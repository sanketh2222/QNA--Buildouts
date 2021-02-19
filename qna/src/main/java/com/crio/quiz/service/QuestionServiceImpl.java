package com.crio.quiz.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.inject.Provider;

import com.crio.quiz.dto.MaskQuestion;
import com.crio.quiz.dto.Questions;
import com.crio.quiz.dto.Summary;
import com.crio.quiz.dto.UserResponse;
import com.crio.quiz.exchange.GetQuestRequest;
import com.crio.quiz.exchange.GetQuestResponse;
import com.crio.quiz.models.MaskQuestionEntity;
import com.crio.quiz.models.QuestionEntity;
import com.crio.quiz.repository.MaskedRepository;
import com.crio.quiz.repository.QuestionRepository;
import com.crio.quiz.repositoryServices.QRepoImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService  {


    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Autowired
    private QuestionRepository qRepository;

    @Autowired
    private QRepoImpl qRepoImpl;

    @Autowired
    private MaskedRepository maskedRepository;

    List<Questions> questions = new ArrayList<>();

    

    public List<Questions> getdata() {
    //    ModelMapper mapper = modelMapperProvider.get();
    //    List<QuestionEntity> results = qRepository.findAll();
    // //    List<Questions> questions = new ArrayList<>();
    //    for (QuestionEntity q: results) {
    //        questions.add(mapper.map(q,Questions.class));
    //    }

       return qRepoImpl.getQuestions();

    }

    public List<Questions> getmaskdata() {
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
        return qRepoImpl.getmaskeQuestions();
        
    }

    public GetQuestResponse validate(GetQuestRequest userResponses) {
    //    List<QuestionEntity> results = qRepository.findAll();
       questions.clear();
       int score=0;
       
    //    ModelMapper mapper = modelMapperProvider.get();
    //    for (QuestionEntity q: results) {
    //        questions.add(mapper.map(q,Questions.class));
    //    }
       questions= qRepoImpl.getQuestions();
       //Need to write a better function for answer validation
       List<Questions> ques = questions.stream().sorted(Comparator.comparing(Questions::getQuestionId))
            .collect(Collectors.toList());
       int total=ques.size();
       userResponses.getResponses().stream().sorted(
           Comparator.comparing(UserResponse::getQuestionId)
       ).collect(Collectors.toList());
       for (int i=0; i<userResponses.getResponses().size(); i++) {
           ques.get(i).setUserAnswer(userResponses.getResponses().get(i).getUserResponse());
           if (ques.get(i).getCorrect().equals(userResponses
                .getResponses().get(i).getUserResponse())) {
                    ques.get(i).setAnswerCorrect(true);
                    score++;
            }
            if (ques.get(i).getOptions().size() == 0)  {
                System.out.println("question id having null option is "+ ques.get(i).getQuestionId());
                System.out.println("option is "+ques.get(i).getOptions());
                ques.get(i).setOptions(null);
            } 
       }
    //    System.out.println(ques);
        Summary summary = new Summary(score,total);
        // s.setScore(score);
        // s.setTotal(total);
        GetQuestResponse resp = new GetQuestResponse(ques,summary);

        return resp;
    }
    
}