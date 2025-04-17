package com.example.testsiat.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.testsiat.user.dao.UserMapper;
import com.example.testsiat.user.model.domain.UserRequestDTO;
import com.example.testsiat.user.model.domain.UserResponseDTO;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper; // UserMapper 객체를 주입받는다.

    public UserResponseDTO loginService(UserRequestDTO params) {
        System.out.println("debug >>>>> login service");
        // UserResponseDTO userResponseDTO = new UserResponseDTO();
        // userResponseDTO.setId(params.getId());
        // userResponseDTO.setPassword(params.getPassword());

        UserResponseDTO responseDTO = userMapper.loginRow(params); // UserMapper의 loginRow() 메서드를 호출한다.


        return responseDTO; // UserMapper의 loginRow() 메서드의 반환값을 반환한다.
    }
}
