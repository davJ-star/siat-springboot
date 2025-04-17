package com.example.testsiat.test.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/bbs") // http://ip:port/bbs
@Tag(name = "Bbs api", description = "Bbs API") // Swagger에서 사용할 태그를 지정한다.
public class BbsCtrl {
     @GetMapping("/registerForm") // URL 경로를 지정하는 annotation
    public String form() {
        System.out.println("debug >>>>> registerForm test");
        return "register"; // test/regiser.jsp 파일을 반환한다.
    }

    
}
