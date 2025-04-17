package com.example.testsiat.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.testsiat.user.model.domain.UserRequestDTO;
import com.example.testsiat.user.model.domain.UserResponseDTO;

@Mapper
public interface UserMapper {
    public UserResponseDTO loginRow(UserRequestDTO params);
    
}   

