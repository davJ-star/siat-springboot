package com.example.testsiat.test.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    /*
     * validation할 수 있는 Annotation
     * @Valid : 유효성 검사를 수행하는 어노테이션 // @Validated : 유효성 검사를 수행하는 어노테이션
     * @Size : 문자열의 길이를 검사하는 어노테이션
     * @Min : 최소값을 검사하는 어노테이션
     * @Max : 최대값을 검사하는 어노테이션 
     * @Pattern : 정규표현식으로 문자열을 검사하는 어노테이션
     * @Email : 이메일 형식을 검사하는 어노테이션
     * @NotNull : null이 아닌지 검사하는 어노테이션
     * @NotEmpty : 비어있지 않은지 검사하는 어노테이션
     * @NotBlank : 공백이 아닌지 검사하는 어노테이션
     * @Future : 미래의 날짜인지 검사하는 어노테이션
     * @Past : 과거의 날짜인지 검사하는 어노테이션
     * @FutureOrPresent : 현재 또는 미래의 날짜인지 검사하는 어노테이션
     * @PastOrPresent : 현재 또는 과거의 날짜인지 검사하는 어노테이션
     * 
     */

      /*
     * validation할 수 있는 Annotation
     * 
     * @Size : 문자열의 길이를 검사하는 어노테이션
     * @Min : 최소값을 검사하는 어노테이션
     * @Max : 최대값을 검사하는 어노테이션 
     * @Pattern : 정규표현식으로 문자열을 검사하는 어노테이션
     * 
     * 
     * @Email : 이메일 형식을 검사하는 어노테이션
     * @NotNull : null이 아닌지 검사하는 어노테이션
     * @NotEmpty : 비어있지 않은지 검사하는 어노테이션
     * @NotBlank : 공백이 아닌지 검사하는 어노테이션
     * @Future : 미래의 날짜인지 검사하는 어노테이션
     * @Past : 과거의 날짜인지 검사하는 어노테이션
     * @FutureOrPresent : 현재 또는 미래의 날짜인지 검사하는 어노테이션
     * @PastOrPresent : 현재 또는 과거의 날짜인지 검사하는 어노테이션
     * 
     */

    @Schema(description = "할일 번호", example = "1")
    private int     seq; 
    
    //@Schema(description = "제목", example = "할일 제목")
    @NotBlank(message = "title은 필수입니다.")
    @NotEmpty(message = "title은 필수입니다.")
    private String  title;

    //@Schema(description = "내용", example = "할일 내용")
    @NotBlank(message = "content는 필수입니다.")
    @NotEmpty(message = "content는 필수입니다.")
    private String  content;

    @Pattern(regexp = "^\\d{2,3}-\\d{4}-\\d{4}$", message = "핸드폰 번호형식에 맞게 입력 요청")
    private String phone;
    
    @Schema(description = "시작일", example = "2023-10-01")
    private String  startDate; // 원래는 삭제
    
    @Schema(description = "종료일", example = "2023-10-31")
    private String  endDate; // 원래는 삭제
    
    @Schema(description = "상태", example = "진행중")
    private String status;
   
    //@Schema(description = "우선순위", example = "1")
    // @Size(min=1, max=10, message = "priority는 1~3 사이의 값이어야 합니다.")
    @Min(value = 1, message = "priority는 1~10 사이의 값이어야 합니다.")
    @Max(value = 10, message = "priority는 1~10 사이의 값이어야 합니다.")
    private int     priority;
    // private int     sequence;
}