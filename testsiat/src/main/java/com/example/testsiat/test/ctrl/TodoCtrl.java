package com.example.testsiat.test.ctrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.testsiat.test.model.dto.TodoRequestDTO;
import com.example.testsiat.test.service.TestService;


@Controller
@RequestMapping("/test")
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
            return "redirect:/test/select"; // test/select.jsp 파일을 반환한다.
        } else {
            System.out.println("debug >>>>> insert test fail: " + flag);
            return "redirect:/test/insert"; // test/insert.jsp 파일을 반환한다.
            
        }
        // return "test/insert"; // test/insert.jsp 파일을 반환한다.
    } 

    // http://localhost:8080/test/view/1
    // 변수명이 동일해야 자동으로 매핑된다.
    @GetMapping("/view/{seq}") // URL 경로를 지정하는 annotation
    public String read(@PathVariable int seq) { // public String read( int seq)
        System.out.println("debug >>>>> read test seq: " + seq);
        return "test/insert"; // test/insert.jsp 파일을 반환한다.
    } 

    // http://localhost:8080/test/update/1
    // 변수명이 동일해야 자동으로 매핑된다.

    // dto로 
    @PostMapping("/update") // URL 경로를 지정하는 annotation
    public String update(
                            @RequestParam String title, // @RequestParam("param") String param
                            @RequestParam String content, // @RequestParam(value="param", required=false) String param
                            @RequestParam int priority // @RequestParam(value="param", defaultValue="default") String param
                        ) { // dto와 같이 받는데.. 일단 RequestParam으로 받는다.
        System.out.println("debug >>>>> update test : " + title + ", " + content + ", " + priority);
        // 여기서 map으로 받아서 service.updateService(map)으로 넘겨준다.
        return "test/update"; // test/update.jsp 파일을 반환한다.
    }

    // @PostMapping("/update") // URL 경로를 지정하는 annotation
    // public String update(TodoRequestDTO requestDTO) { // dto와 같이 받는데.. 일단 RequestParam으로 받는다.
    //     System.out.println("debug >>>>> update test requestDTO: " + requestDTO);
    //     // 여기서 map으로 받아서 service.updateService(map)으로 넘겨준다.
    //     return "test/update"; // test/update.jsp 파일을 반환한다.
    // }

    // http://localhost:8080/test/update/1
    // 변수명이 동일해야 자동으로 매핑된다.
    @GetMapping("/select") // URL 경로를 지정하는 annotation
    public String select(@RequestParam int seq) { // public String read( int seq)
        System.out.println("debug >>>>> select test seq: " + seq);
        return "test/select"; // test/update.jsp 파일을 반환한다.
    }
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
    @DeleteMapping("/delete") // URL 경로를 지정하는 annotation
    public String delete(@RequestParam int seq) { // public String read( int seq)
        System.out.println("debug >>>>> delete test seq: " + seq);
        return "test/delete"; // test/delete.jsp 파일을 반환한다.
    }
    
}
