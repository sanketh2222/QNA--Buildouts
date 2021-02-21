package com.crio.quiz.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// import java.util.stream.Collector;
import java.util.stream.Collectors;

// import javax.inject.Provider;

// import com.crio.quiz.dto.MaskQuestion;
import com.crio.quiz.dto.Questions;
import com.crio.quiz.dto.Summary;
import com.crio.quiz.dto.UserResponse;
import com.crio.quiz.exchange.GetUserResp;
import com.crio.quiz.exchange.GetQuestResponse;
// import com.crio.quiz.models.MaskQuestionEntity;
// import com.crio.quiz.models.QuestionEntity;
// import com.crio.quiz.repository.MaskedRepository;
// import com.crio.quiz.repository.QuestionRepository;
import com.crio.quiz.repositoryServices.QRepoServiceImpl;

// import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService  {



    @Autowired
    private QRepoServiceImpl qRepoServiceImpl;


   

    
    public List<Questions> getdata() {

       return qRepoServiceImpl.getQuestions();

    }

    public List<Questions> getmaskdata() {

        return qRepoServiceImpl.getmaskeQuestions();
        
    }

    public GetQuestResponse validate(GetUserResp userResponses) {

       List<Questions> questions = new ArrayList<>();
       questions= qRepoServiceImpl.getQuestions();
       //Need to write a better function for answer validation
       List<Questions> ques = questions.stream().sorted(Comparator.comparing(Questions::getQuestionId))
            .collect(Collectors.toList());
       int score=0;
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
            if (ques.get(i).getType().equals("subjective"))  {
                // System.out.println("question id having null option is "+ ques.get(i).getQuestionId());
                // System.out.println("option is "+ques.get(i).getOptions());
                ques.get(i).setOptions(null);
            } 
       }

        Summary summary = new Summary(score,total);
        GetQuestResponse resp = new GetQuestResponse(ques,summary);

        return resp;
    }
    
}