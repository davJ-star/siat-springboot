package com.example.testsiat.test.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Setter;


// @Builder
@Getter
@Setter
@ToString
@Schema(description = "Todo 응답 DTO")
public class TodoResponseDTO {
    @Schema(description = "할일 번호", example = "1")
    private int     seq;
    @Schema(description = "제목", example = "할일 제목")
    private String  title;
    @Schema(description = "내용", example = "할일 내용")
    private String  content;
    @Schema(description = "시작일", example = "2023-10-01")
    private String  startDate;
    @Schema(description = "체크여부", example = "0")
    private int     check;
    @Schema(description = "상태", example = "진행중")
    private String  status;
    @Schema(description = "종료일", example = "2023-10-31")
    private String  endDate;
    @Schema(description = "우선순위", example = "1")
    private int     priority;

}