package com.example.testsiat.landing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexCtrl {
    @RequestMapping("/")
    public String index() {
        System.out.println("index() 호출");
        return "landing"; // landing.jsp 파일을 반환
    }
    
    // @RequestMapping("/index")
    // public String index(@RequestParam("name") String name) {
    //     System.out.println("name: " + name);
    //     return "index"; // index.jsp 파일을 반환
    // }

    
}
