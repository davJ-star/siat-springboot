package com.example.testsiat.test.dao;

import org.springframework.stereotype.Repository;

@Mapper // @Repository는 데이터베이스와의 상호작용을 처리하는 클래스에 붙이는 annotation이다.
public interface TestMapper {
    public int insertRow(TodoRequestDTO params);
    public List<TodoResponseDTO> selectRow();
    public int updateRow(Map<String, Object> map);
    public int deleteRow(int seq);

}
