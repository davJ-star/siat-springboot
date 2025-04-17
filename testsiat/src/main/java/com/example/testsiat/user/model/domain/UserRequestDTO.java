package com.example.testsiat.user.model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRequestDTO {
    private String id;
    private String pwd;
    private String name;
}
