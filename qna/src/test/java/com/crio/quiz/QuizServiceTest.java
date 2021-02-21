package com.crio.quiz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.crio.quiz.dto.Questions;
import com.crio.quiz.exchange.GetQuestResponse;
import com.crio.quiz.exchange.GetUserResp;
import com.crio.quiz.repositoryServices.QRepoServiceImpl;
import com.crio.quiz.service.QuestionServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
// import org.springframework.test.context.ActiveProfiles;
// import javax.inject.Provider;

@SpringBootTest(classes = { App.class })
// @MockitoSettings(strictness = Strictness.STRICT_STUBS)
@DirtiesContext
// @ActiveProfiles("test")
public class QuizServiceTest {

    private static final String FIXTURES = "fixtures/exchanges/";
    public static final String BASE_URL = "http://localhost:8081";

    @InjectMocks
    QuestionServiceImpl questionService;

    @Mock
    QRepoServiceImpl questionRepositoryMock;


    private String resolveFileAsString(String input) throws URISyntaxException, IOException {
        File inputFile = new File(Thread.currentThread().getContextClassLoader().getResource(input).toURI());
        return new String(Files.readAllBytes(inputFile.toPath()), "utf-8");
    }

    public List<Questions> loadData(String filename)
            throws JsonParseException, JsonMappingException, 
            IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();
        List<Questions> questionsResponse = new ArrayList<>();
        Questions[] questions = mapper
            .readValue(resolveFileAsString(FIXTURES + filename), Questions[].class);

        System.out.println("checking");
        for (Questions question : questions) {
            questionsResponse.add(question);
        }

        return questionsResponse;
        
    }

    public GetUserResp userResponses(String filename)
            throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
        
        ObjectMapper mapper = new ObjectMapper();
        GetUserResp userResponses = mapper
            .readValue(resolveFileAsString(FIXTURES + filename), GetUserResp.class);
     
        
        return userResponses;
    }

    @Test
    public void getRequestTest() throws JsonParseException, JsonMappingException, 
            IOException, URISyntaxException {
        
        String filename = "initial_data_load.json";
        when(questionRepositoryMock.getQuestions()).thenReturn(loadData(filename));
        List<Questions> q = questionService.getdata();
        System.out.println("success");
        assertEquals(12, q.size());
    }

    @Test
    public void postRequestTest() throws JsonParseException, JsonMappingException, 
            IOException, URISyntaxException {
        
        GetUserResp req = userResponses("sample_user_submission_request.json");
        String filename = "initial_data_load.json";
        when(questionRepositoryMock.getQuestions()).thenReturn(loadData(filename));
        // ModelMapper modelMapper = modelMapperProvider.get();
        GetQuestResponse response = questionService.validate(req);
        System.out.println("success");
        // assertEquals(12, q.size());
        assertEquals(6,(int) response.getSummary().getScore());
        assertEquals(12, (int) response.getSummary().getTotal());
        assertEquals(12, response.getQuestions().size());
    }
}