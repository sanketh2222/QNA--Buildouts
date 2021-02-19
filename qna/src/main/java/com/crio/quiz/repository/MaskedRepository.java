package com.crio.quiz.repository;

import com.crio.quiz.models.MaskQuestionEntity;

// import java.util.List;
// import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MaskedRepository extends MongoRepository<MaskQuestionEntity,String> {
    
}