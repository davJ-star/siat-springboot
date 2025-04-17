package com.example.testsiat.user.model.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Schema(description = "Todo 요청 DTO")
// @Schema(name = "UserRequestDTO", description = "UserRequestDTO")
public class UserRequestDTO {
    @Schema(description = "아이디", example = "test")
    private String id;
    @Schema(description = "비밀번호", example = "1234")
    private String pwd;
    @Schema(description = "이름", example = "홍길동")
    private String name;
}
