package com.siat.siat.test.service;
import com.siat.siat.test.dao.TestDao; // TestDao 클래스를 import한다.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired // TestDao 객체를 자동으로 주입받s는다.
    private TestDao dao; // TestDao 객체를 주입받는다.

    // TestDao 객체를 주입받는 생성자

    public void insertRow() {
        System.out.println("insertRow() 호출");
        System.out.println("debug >> dao : " + dao);
        dao.insertRow(); // TestDao의 insertRow() 메서드를 호출한다.
    
    } 
}