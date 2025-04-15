package com.example.testsiat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testsiat.test.dao.TestMapper;
import com.example.testsiat.test.model.dto.TodoRequestDTO;

@SpringBootTest
public class MybatisApp {

    // @Autowired
    // private TestDao testDao;
    @Autowired
    private TestMapper testMapper;
    
    @Test
    public void insertTest(){
        System.out.println("debug >>>>> test");
        TodoRequestDTO todoRequestDTO = TodoRequestDTO.builder()
                .title("test")
                .content("test")
                .priority(10)
                .build();
        System.out.println("debug >>>>> test2" + todoRequestDTO.toString());
        int flag = testMapper.insertRow(todoRequestDTO);
        System.out.println("debug >>>>> test3" + flag);
    }
}
