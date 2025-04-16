package com.example.testsiat.test.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;


// @Builder
@Getter
@Setter
@ToString
public class TodoResponseDTO {
    private int     seq;
    private String  title;
    private String  content;
    private String  startDate;
    private int     check;
    private String  status;
    private String  endDate;
    private int     priority;

}