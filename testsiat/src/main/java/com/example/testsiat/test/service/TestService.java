package com.example.testsiat.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsiat.test.dao.TestDao;
import com.example.testsiat.test.dao.TestMapper;
import com.example.testsiat.test.model.dto.TodoRequestDTO;
import com.example.testsiat.test.model.dto.TodoResponseDTO;

@Service
public class TestService {
    // @Autowired // TestDao 객체를 자동으로 주입받s는다.
    // private TestDao dao; // TestDao 객체를 주입받는다.

    @Autowired // TestMapper 객체를 자동으로 주입받는다.
    private TestMapper testMapper; // TestMapper 객체를 주입받는다.

    public int insertService(TodoRequestDTO params){
        System.out.println("debug >> insertService() 호출");
        
        int flag = testMapper.insertRow(params); // TestMapper의 insertRow() 메서드를 호출한다.
        System.out.println("debug >> flag : " + flag);
        return flag; // TestMapper의 insertRow() 메서드의 반환값을 반환한다.
    }
    public List<TodoResponseDTO> selectService(){
        System.out.println("debug >> selectService() 호출");
        return testMapper.selectRow(); // TestDao의 selectRow() 메서드를 호출한다.
    }
    public int updateService(Map<String, Object> map){
        System.out.println("updateService() 호출");
        return testMapper.updateRow(map); // TestDao의 updateRow() 메서드를 호출한다.
    }
    public int deleteService(int seq){
        System.out.println("deleteService() 호출");
        return testMapper.deleteRow(seq); // TestDao의 deleteRow() 메서드를 호출한다.
    }

    public TodoResponseDTO readService(int seq){
        System.out.println("readService() 호출");
        return testMapper.readRow(seq); // TestDao의 readRow() 메서드를 호출한다.
    } // seq로 조회하는 메소드 추가




    // // 

    // public void insertRow() {
    //     System.out.println("insertRow() 호출");
    //     System.out.println("debug >> dao : " + dao);
    //     dao.insertRow(); // TestDao의 insertRow() 메서드를 호출한다.
    
    // } 
}