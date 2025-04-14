package com.siat.siat.test.dao;
import org.springframework.stereotype.Repository;

@Repository // @Repository는 데이터베이스와의 상호작용을 처리하는 클래스에 붙이는 annotation이다.
public class TestDao {
    
    public void insertRow() {
        System.out.println("insertRow() 호출");
    }

}
