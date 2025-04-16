package com.example.testsiat.test.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "type")
// @JsonSubTypes({
//     @JsonSubTypes.Type(value = TodoRequestDTO.class, name = "TodoRequestDTO")
// })
// @JsonTypeName("TodoRequestDTO")
// @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
// @JsonSubTypes({
public class TodoRequestDTO{
    private String  title;
    private String  content;
    private String  startDate; // 원래는 삭제
    private String  endDate; // 원래는 삭제
    private String status;
    private int     priority;
    // private int     sequence;
}