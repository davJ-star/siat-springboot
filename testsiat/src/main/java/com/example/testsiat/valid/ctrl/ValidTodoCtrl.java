package com.example.testsiat.valid.ctrl;


import java.lang.reflect.Field;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.testsiat.test.model.dto.TodoRequestDTO;

import jakarta.validation.Valid;

// import org.springframework.web.bind.annotation.RestController;

// @RestController

// 우선, todoCtrl을 체크한다.
@Controller
@RequestMapping("/valid") // http://ip:port/
public class ValidTodoCtrl {
    // insert 
    // http://localhost:8080/test/insert
    // http://ip:port
    // 변수명이 동일해야 자동으로 매핑된다.
    @PostMapping("/insert") // URL 경로를 지정하는 annotation
    public String insert(@Valid TodoRequestDTO params, BindingResult bindResult) { // @RequestParam (value="param", defaultValue="default") String param
        System.out.println("debug >>>>> insert test params: " + params);

        List<ObjectError> validationErrors = bindResult.getAllErrors();
        for (int i = 0; i < validationErrors.size(); i++) {
            FieldError fieldError = (FieldError) validationErrors.get(i);
            String fieldName = fieldError.getField(); // 필드명
            String errorMessage = fieldError.getDefaultMessage(); // 에러메시지
            System.out.println("code :" + fieldError.getCode()); // 에러코드
            System.out.println("field :" + fieldError.getField()); // 필드명
            System.out.println("message :" + fieldError.getDefaultMessage()); // 에러메시지
            
            
            System.out.println("debug >>>>> fieldName: " + fieldName + ", errorMessage: " + errorMessage);
            
            // 필드명에 해당하는 필드의 값을 가져온다.

        }

        
        return null; // 
    } 
}
