package com.crio.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Summary {

    @NotNull
    private Integer score;

    @NotNull
    private Integer total;
    
}