package com.example.testsiat.valid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsiat.test.model.dto.TodoRequestDTO;
import com.example.testsiat.valid.dao.ValiDao;
import com.example.testsiat.valid.domain.entity.TodoEntity;

@Service
public class ValidService {
    @Autowired
    private ValiDao dao; // ValidDao 객체를 주입받는다.

    // 읽기 전용으로 사용하자. 
    public int insertService(TodoRequestDTO params) { // @RequestParam (value="param", defaultValue="default") String param
        System.out.println("insertService() 호출");
        dao.findById((int) 1L); // findById() 메소드 호출
        //dao.
        TodoEntity entity = TodoEntity.builder()
                .title(params.getTitle())
                .content(params.getContent())
                .priority(params.getPriority())
                .build(); // TodoEntity 객체 생성
        
        dao.save(entity); // save() 메소드 호출
        return 1;
    } // insertService() 호출
    
}
