package com.crio.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.crio.quiz.dto.Questions;
import com.crio.quiz.exchange.GetQuestResponse;
import com.crio.quiz.exchange.GetQuestRequest;
import com.crio.quiz.service.QuestionService;
// import com.crio.quiz.service.QuestionServiceImpl;

// import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
// @Log4j2
// @RequestMapping(QController.QUIZ_API_ENDPOINT)
public class QController {
    public static final String QUIZ_API_ENDPOINT = "quiz/{moduleid}";

    @Autowired
    private QuestionService questionService;

    // private



    @GetMapping(QUIZ_API_ENDPOINT)
    public ResponseEntity<GetQuestResponse> getQuestions(@PathVariable String moduleid) {
        // Questions q = new Questions();
        
        // // q.setQuestionid("001");
        // q.setTitle("What is the default IP address of localhost?");
        // System.out.println("called with module id as " + moduleid);
        // log.info("returning a response with module id as " + moduleid);
        
        GetQuestResponse resp = new GetQuestResponse();
        // resp.setQuestions(qRepoImpl.getdata());
        System.out.println(resp);
        resp.setQuestions(questionService.getmaskdata());
        return ResponseEntity.ok().body(resp);
    }

    @PostMapping(path = QUIZ_API_ENDPOINT, consumes = "application/json", produces = "application/json")
    public ResponseEntity<GetQuestResponse> addMember(@RequestBody GetQuestRequest userResponse) {
        List<Questions> answer =  new ArrayList<>();
        // log.info("question id is "+ " "+ userResponse.getQuestionId());
        log.info("user response is "+ " "+userResponse.getResponses());
        GetQuestResponse response = questionService.validate(userResponse);
        log.info("result is "+ answer);
        // GetQuestResponse response = new GetQuestResponse();
        // response.setQuestions(answer);
        return ResponseEntity.ok().body(response);
        // return null;
    }
}