package com.example.testsiat.test.ctrl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.testsiat.test.model.dto.TodoRequestDTO;
import com.example.testsiat.test.model.dto.TodoResponseDTO;
import com.example.testsiat.test.service.TestService;


@Controller
@RequestMapping("/todo")
public class TodoCtrl {
    @Autowired // TestService 객체를 자동으로 주입받는다.
    private TestService service; // TestService 객체를 주입받는다.

    // public TestCtrl() {
    //     System.out.println("TestCtrl 생성자 호출");
    // }

    // @RequestMapping("/insert" ) // URL 경로를 지정하는 annotation
    // public String insert() {
    //     return "test/insert"; // test/insert.jsp 파일을 반환한다.
    // }

    // PathVariable을 사용하여 URL 경로에서 파라미터를 받을 수 있다.
    // @RequestMapping("/insert/{param}") // URL 경로를 지정하는 annotation
    // public String insert(@PathVariable("param") String param)
    // RequestParam을 사용하여 파라미터를 받을 수 있다. 
    // @RequestParam("param") String param
    // @RequestParam(value="param", required=false) String param
    // @RequestParam(value="param", defaultValue="default") String param
    // @RequestParam(value="param", defaultValue="default", required=false) String param

    // endpoint : http//ip:port/todo/registerForm

    @GetMapping("/registerForm") // URL 경로를 지정하는 annotation
    public String form() {
        System.out.println("debug >>>>> registerForm test");
        return "register"; // test/regiser.jsp 파일을 반환한다.
    }

    // @PostMapping("/insert") // URL 경로를 지정하는 annotation
    // public String insert(
    //         @RequestParam String title, // @RequestParam("param") String param
    //         @RequestParam String content, // @RequestParam(value="param", required=false) String param
    //         @RequestParam int priority // @RequestParam(value="param", defaultValue="default") String param
    //         ) { // @RequestParam (value="param", defaultValue="default") String param
    //     return "test/insert"; // test/insert.jsp 파일을 반환한다.
    // } 

    // http://localhost:8080/test/insert
    // http://ip:port
    // 변수명이 동일해야 자동으로 매핑된다.
    @PostMapping("/insert") // URL 경로를 지정하는 annotation
    public String insert(TodoRequestDTO params) { // @RequestParam (value="param", defaultValue="default") String param
        System.out.println("debug >>>>> insert test params: " + params);

        int flag = service.insertService(params);
        System.out.println("debug >>>>> insert test flag: " + flag);
        if (flag != 0) {
            System.out.println("debug >>>>> insert test success: " + flag);
            return "redirect:/"; // test/select.jsp 파일을 반환한다.
            //return "landing"; // test/select.jsp 파일을 반환한다.
        } else {
            System.out.println("debug >>>>> insert test fail: " + flag);
            return "zzzz"; // test/insert.jsp 파일을 반환한다.
            
        }
        // return "test/insert"; // test/insert.jsp 파일을 반환한다.
    } 

    // http://localhost:8080/test/view/1
    // 변수명이 동일해야 자동으로 매핑된다.
    @GetMapping("/read") // URL 경로를 지정하는 annotation
    public String read(@RequestParam("seq") int seq, Model model) { // public String read( int seq)
        System.out.println("debug >>>>> read test seq: " + seq);
        TodoResponseDTO response = service.readService(seq); // TestService의 readService() 메서드를 호출한다.
        System.out.println("debug >>>>> read test response: " + response);

        model.addAttribute("read", response); // model에 response를 추가한다.
        
        // model.addAttribute("seq", seq); // model에 seq를 추가한다.
        // model.addAttribute("title", title); // model에 title을 추가한다.
        // model.addAttribute("content", content); // model에 content를 추가한다.
        // model.addAttribute("priority", priority); // model에 priority를 추가한다.



        // 기본화면 분기: forward
        return "read"; // test/read.jsp 파일을 반환한다.
    } 

    // http://localhost:8080/test/view/1
    // 변수명이 동일해야 자동으로 매핑된다.
    @GetMapping("/view/{seq}") // URL 경로를 지정하는 annotation
    public String view(@PathVariable("seq") int seq, Model model) { // public String read( int seq)
        System.out.println("debug >>>>> view test seq: " + seq);
        TodoResponseDTO response = service.readService(seq); // TestService의 readService() 메서드를 호출한다.
        System.out.println("debug >>>>> view test response: " + response);

        model.addAttribute("read", response); // model에 response를 추가한다.
        
        // model.addAttribute("seq", seq); // model에 seq를 추가한다.
        // model.addAttribute("title", title); // model에 title을 추가한다.
        // model.addAttribute("content", content); // model에 content를 추가한다.
        // model.addAttribute("priority", priority); // model에 priority를 추가한다.



        // 기본화면 분기: forward
        return "read"; // test/view.jsp 파일을 반환한다.
    } 


    // http://localhost:8080/test/update/1
    // 변수명이 동일해야 자동으로 매핑된다.

    // dto로 
    @PostMapping("/update") // URL 경로를 지정하는 annotation
    public String update(
                    @RequestParam("content") String content,
                    @RequestParam("status") String status,
                    @RequestParam("seq") int seq
                        ) { // dto와 같이 받는데.. 일단 RequestParam으로 받는다.
        System.out.println("debug >>>>> update test : " + content + ", " + status);
        // 여기서 map으로 받아서 service.updateService(map)으로 넘겨준다.
        Map<String, Object> map = new HashMap<>();
        map.put("content", content); // model에 title을 추가한다.
        map.put("status", status); // model에 status 추가한다.
        map.put("seq", seq);
        int flag = service.updateService(map); // TestService의 updateService() 메서드를 호출한다.
        System.out.println("debug >>>>> update test flag: " + flag);
        if (flag != 0) {
            System.out.println("debug >>>>> update test success: " + flag);
            return "redirect:/todo/select"; // test/select.jsp 파일을 반환한다.
        } else {
            System.out.println("debug >>>>> update test fail: " + flag);
            return "redirect:/todo/select"; // test/update.jsp 파일을 반환한다.
            
        }
        // return "test/update"; // test/update.jsp 파일을 반환한다.
    }

    // @PostMapping("/update") // URL 경로를 지정하는 annotation
    // public String update(TodoRequestDTO requestDTO) { // dto와 같이 받는데.. 일단 RequestParam으로 받는다.
    //     System.out.println("debug >>>>> update test requestDTO: " + requestDTO);
    //     // 여기서 map으로 받아서 service.updateService(map)으로 넘겨준다.
    //     return "test/update"; // test/update.jsp 파일을 반환한다.
    // }

    // http://localhost:8080/test/select
    // 변수명이 동일해야 자동으로 매핑된다.
    @GetMapping("/select") // URL 경로를 지정하는 annotation
    public String select(Model model) { // public String read( int seq)
        System.out.println("debug >>>>> select test model: " + model);
        List<TodoResponseDTO> list = service.selectService(); // TestService의 selectService() 메서드를 호출한다.
        model.addAttribute("list", list); // model에 list를 추가한다.

        return "list"; // test/select.jsp 파일을 반환한다.
    }
    
    // @GetMapping("/select") // URL 경로를 지정하는 annotation
    // public String select(@RequestParam int seq) { // public String read( int seq)
    //     System.out.println("debug >>>>> select test seq: " + seq);
    //     return "test/select"; // test/update.jsp 파일을 반환한다.
    // }
    // @GetMapping("/select") // URL 경로를 지정하는 annotation
    // public String select(TodoRequestDTO requestDTO) { // public String read( int seq)
    //     System.out.println("debug >>>>> select test request dto: " + requestDTO);
    //     return "test/select"; // test/update.jsp 파일을 반환한다.
    // }





    // // http://localhost:8080/test/delete/1
    // // 변수명이 동일해야 자동으로 매핑된다.
    // @DeleteMapping("/delete/{seq}") // URL 경로를 지정하는 annotation
    // public String delete(@PathVariable int seq) { // public String read( int seq)
    //     System.out.println("debug >>>>> delete test seq: " + seq);
    //     return "test/delete"; // test/delete.jsp 파일을 반환한다.
    // }
    // http://localhost:8080/test/delete/1
    // 변수명이 동일해야 자동으로 매핑된다.
    @GetMapping("/delete") // URL 경로를 지정하는 annotation
    public String delete(@RequestParam("seq")  int seq) { // public String read( int seq)
        System.out.println("debug >>>>> delete test seq: " + seq);

        int flag = service.deleteService(seq); // TestService의 deleteService() 메서드를 호출한다.
        System.out.println("debug >>>>> delete test flag: " + flag);
        if (flag != 0) {
            System.out.println("debug >>>>> delete test success: " + flag);
            return "redirect:/todo/select"; // test/select.jsp 파일을 반환한다.
        } else {
            System.out.println("debug >>>>> delete test fail: " + flag);
            return "redirect:/todo/select"; // test/delete.jsp 파일을 반환한다.
            
        }
        // return "test/delete"; // test/delete.jsp 파일을 반환한다.
    }
    
}
