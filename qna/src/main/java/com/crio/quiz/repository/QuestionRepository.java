package com.crio.quiz.repository;

import com.crio.quiz.models.QuestionEntity;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface QuestionRepository extends MongoRepository<QuestionEntity,String> {
    
}