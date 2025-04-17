package com.example.testsiat.test.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
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

@Schema(description = "Todo 요청 DTO")
public class TodoRequestDTO{
    @Schema(description = "할일 번호", example = "1")
    private int     seq; 
    @Schema(description = "제목", example = "할일 제목")
    private String  title;
    @Schema(description = "내용", example = "할일 내용")
    private String  content;
    @Schema(description = "시작일", example = "2023-10-01")
    private String  startDate; // 원래는 삭제
    @Schema(description = "종료일", example = "2023-10-31")
    private String  endDate; // 원래는 삭제
    @Schema(description = "상태", example = "진행중")
    private String status;
    @Schema(description = "우선순위", example = "1")
    private int     priority;
    // private int     sequence;
}