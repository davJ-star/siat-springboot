package com.example.testsiat.test.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsiat.test.model.dto.TodoRequestDTO;
import com.example.testsiat.test.model.dto.TodoResponseDTO;
import com.example.testsiat.test.service.TestService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/react")
@CrossOrigin(origins = "http://localhost:3000")
public class ReactCtrl {
    @Autowired
    private TestService service;

    @GetMapping("/select")
    public ResponseEntity<List<TodoResponseDTO>> select(@RequestBody TodoRequestDTO params) { // public String read( int seq)
        // System.out.println("debug >>>>> select test model: " + model);

        System.out.println("debug >>> params: " + params);

        List<TodoResponseDTO> list = service.selectService(); // TestService의 selectService() 메서드를 호출한다.
        
        return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK); // test/select.jsp 파일을 반환한다.
    }
    
    
}
