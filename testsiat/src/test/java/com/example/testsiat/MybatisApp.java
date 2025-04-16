package com.example.testsiat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testsiat.test.dao.TestMapper;
import com.example.testsiat.test.model.dto.TodoRequestDTO;
import com.example.testsiat.test.model.dto.TodoResponseDTO;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@SpringBootTest
public class MybatisApp {

    // @Autowired
    // private TestDao testDao;
    @Autowired
    private TestMapper testMapper;
    
    @Test
    public void insertTest(){
        System.out.println("debug >>>>> test");
        // given -> when -> then

        // given : 테스트에 필요한 데이터 준비
        TodoRequestDTO todoRequestDTO = TodoRequestDTO.builder()
                .title("test")
                .content("test")
                .priority(10)
                .build();
        System.out.println("debug >>>>> test2" + todoRequestDTO.toString());
        int flag = testMapper.insertRow(todoRequestDTO);
        System.out.println("debug >>>>> test3" + flag);
    }
    @Test
    public void selectTest(){
        System.out.println("debug >>>>> select  test");
        
        List<TodoResponseDTO> list = testMapper.selectRow();
        for (TodoResponseDTO todoResponseDTO : list) {
            System.out.println("debug >>>>> test todoResponseDTO value: " + todoResponseDTO.toString());
        }
        System.out.println("debug >>>>> test ,list" + list.toString());
    
    }
    @Test
    public void updateTest(){
        System.out.println("debug >>>>> update  test");
        Map<String, Object> map = new HashMap<>();
        map.put("seq", 21);
        map.put("content", "수정");
        map.put("status", "Y");

        int flag = testMapper.updateRow(map);
        System.out.println("debug >>>>> flag" + flag);
    }
    @Test
    public void deleteTest(){
        System.out.println("debug >>>>> delete  test");
        
        int flag = testMapper.deleteRow(3);
        System.out.println("debug >>>>> flag" + flag);
    
    }
    @Test
    public void readTest(){
        System.out.println("debug >>>>> read  test");
        
        TodoResponseDTO dto = testMapper.readRow(2);
        System.out.println("debug >>>>> dto" + dto);

        //given
        Integer seq = 2;

        // when
        TodoResponseDTO todoResponseDTO = testMapper.readRow(seq);

        // then
        //Assertions.assertNotNull(todoResponseDTO); // dto가 null이 아닌지 확인
        System.out.println(todoResponseDTO);

    
    }
}
// 


// then 처리
// assertions는 JUnit5에서 제공하는 단위 테스트를 위한 assertion 라이브러리이다.
// assertEquals, assertTrue, assertFalse, assertNotNull, assertNull 등 다양한 assertion 메소드를 제공한다. 
