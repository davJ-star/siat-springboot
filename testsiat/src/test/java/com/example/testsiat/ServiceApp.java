package com.example.testsiat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testsiat.test.dao.TestMapper;
import com.example.testsiat.test.model.dto.TodoResponseDTO;

@SpringBootTest
public class ServiceApp {
    // @Autowired // TestDao 객체를 자동으로 주입받는다.
    // private TestDao dao; // TestDao 객체를 주입받는다.

    @Autowired // TestMapper 객체를 자동으로 주입받는다.
    private TestMapper testMapper; // TestMapper 객체를 주입받는다.

    @Test
    public void read(){
        System.out.println("debug >>>>> read  test");
        //given -> when -> then

        // given : 테스트에 필요한 데이터 준비
        int seq = 21; // 조회할 seq 값

        // null인지 아닌지 체크한다.
        // when : 테스트할 메서드 호출
        TodoResponseDTO response = testMapper.readRow(seq); // TestMapper의 readRow() 메서드를 호출한다.

        
        // then : 테스트 결과 확인
        // assertNotNull(response); // response가 null이 아닌지 확인한다.
        // assertEquals(seq, response.getSeq()); // seq 값이 일치하는지 확인한다.
        // Assertions.assertThat(response).isNotNull(); // response가 null이 아닌지 확인한다.
        // Assertions.assertThat(response.getSeq()).isEqualTo(seq); // seq 값이 일치하는지 확인한다.

        Assertions.assertNotNull(response, "정상적으로 데이터를 읽지 못함."); // response가 null이 아닌지 확인한다.
        


        // TestMapper의 readRow() 메서드를 호출하여 seq로 조회한다.
        // TodoResponseDTO todoResponseDTO = testMapper.readRow(seq); // TestMapper의 readRow() 메서드를 호출한다.
        // System.out.println("debug >>>>> test todoResponseDTO value: " + todoResponseDTO.toString());
        // System.out.println("debug >>>>> test ,list" + list.toString());
        // Assertions.assertThat(todoResponseDTO.getSeq()).isEqualTo(seq); // seq 값이 일치하는지 확인한다.
    }
    
}
