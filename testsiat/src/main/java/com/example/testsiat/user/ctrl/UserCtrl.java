package com.example.testsiat.user.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.testsiat.user.model.domain.UserRequestDTO;
import com.example.testsiat.user.model.domain.UserResponseDTO;
import com.example.testsiat.user.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j  // Lombok의 @Slf4j 어노테이션을 사용하여 로그를 남길 수 있는 Logger 객체를 생성한다. 
        // slf4j는 Simple Logging Facade for Java의 약자로, 다양한 로깅 프레임워크에 대한 추상화된 인터페이스를 제공한다.
/*
 *  trace:  추적레벨
 *  debug: 디버그레벨(디버깅 정보성 메세지를 출력할 때)
 *  info: 상태변경이나 정보성 메세지를 출력할 때
 *  warn: 에러의 원인이 될 수 있는 경고성 메세지를 출력할 때
 *  error: 요청 처리에 문제발생시
 */

@Controller
@RequestMapping("/user") // http://ip:port/user
public class UserCtrl {

    @Autowired 
    private HttpSession session; // HttpSession 객체를 주입받는다.

    @Autowired 
    private UserService service; // TestService 객체를 주입받는다.
    
    @PostMapping("/login") // http://ip:port/user/login
    public String login(UserRequestDTO params) {
        System.out.println("debug >>>>> login ctrl");
        log.info("debug >>>>> login ctrl, params: " + params); // info 레벨로 로그를 남긴다.

        UserResponseDTO response = service.loginService(params); // UserService의 loginService() 메서드를 호출한다.

        session.setAttribute("UserSession", response);
        return "redirect:/"; // 로그인 성공 시 redirect:/로 이동한다.
    }
    
}
