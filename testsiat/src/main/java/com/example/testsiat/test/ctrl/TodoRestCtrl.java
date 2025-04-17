package com.example.testsiat.test.ctrl;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsiat.test.model.dto.TodoRequestDTO;
import com.example.testsiat.test.model.dto.TodoResponseDTO;
import com.example.testsiat.test.service.TestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


/*
 * ResponseEntity : body, header, status를 포함하는 응답 객체
 * header : 응답 헤더
 *  header는 왜 필요한가?
 *  - 클라이언트와 서버 간의 통신에서 메타데이터를 전달하는 데 사용된다. (클라이언트와 서버 간의 통신에서 필요한 추가 정보를 전달하는 데 사용된다.)
 *  - 클라이언트가 요청한 데이터의 형식이나 인코딩 방식, 캐시 정책 등을 지정할 수 있다.
 *  - 서버가 응답하는 데이터의 형식이나 인코딩 방식, 캐시 정책 등을 지정할 수 있다.
 * body : 응답 본문
 * status : 응답 상태 코드
 */

@RestController
@RequestMapping("/rest/todo") // http://ip:port/todo

// api 엔드포인트가 어떤 그룹에 속하는지를 알려주는 그룹핑 어노테이션
@Tag(name = "Todo api", description = "할일 관리 API") // Swagger에서 사용할 태그를 지정한다.
public class TodoRestCtrl {
    @Autowired // TestService 객체를 자동으로 주입받는다.
    private TestService service; // TestService 객체를 주입받는다.

    

    @GetMapping("/registerForm") // URL 경로를 지정하는 annotation
    public String form() {
        System.out.println("debug >>>>> registerForm test");
        return "register"; // test/regiser.jsp 파일을 반환한다.
    }

    // http://localhost:8080/test/insert
    // http://ip:port
    // 변수명이 동일해야 자동으로 매핑된다.
    @PostMapping("/insert") // URL 경로를 지정하는 annotation
    @Operation(summary = "할일 등록(입력)", description = "할일을 등록한다.(파라미터로 받은 정보를 저장)") // Swagger에서 사용할 메서드 설명을 지정한다.
    @Parameter(name = "title", description = "제목입력", required = true) // Swagger에서 사용할 파라미터 설명을 지정한다.
    @Parameter(name = "content", description = "내용입력", required = true) // Swagger에서 사용할 파라미터 설명을 지정한다.
    @Parameter(name = "priority", description = "우선순위입력", required = true) // Swagger에서 사용할 파라미터 설명을 지정한다.
    // @ApiResponses(value = { // Swagger에서 사용할 응답 설명을 지정한다.
    //     @ApiResponse(responseCode = "200", description = "정상처리"), // 200 OK 응답 설명
    //     @ApiResponse(responseCode = "400", description = "비정상처리") // 400 Bad Request 응답 설명
    // })

    @ApiResponse(responseCode = "200", description = "정상처리") // 200 OK 응답 설명
    @ApiResponse(responseCode = "400", description = "비정상처리", 
                    content = @Content(schema = @Schema(implementation = TodoRequestDTO.class))) // 400 Bad Request 응답 설명
    public ResponseEntity<String> insert(TodoRequestDTO params) { // @RequestParam (value="param", defaultValue="default") String param
        System.out.println("debug >>>>> insert test params: " + params);

        int flag = service.insertService(params);
        System.out.println("debug >>>>> insert test flag: " + flag);
        if (flag != 0) {
            System.out.println("debug >>>>> insert test success: " + flag);
            //return "redirect:/"; // test/select.jsp 파일을 반환한다.
            return new ResponseEntity<>("정상처리", HttpStatus.OK); // 
            //return "landing"; // test/select.jsp 파일을 반환한다.
        }
        // } else {
        //     System.out.println("debug >>>>> insert test fail: " + flag)
        //     return "zzzz"; // test/insert.jsp 파일을 반환한다.
            
        // }
        // return "test/insert"; // test/insert.jsp 파일을 반환한다.
        return new ResponseEntity<>("비정상처리", HttpStatus.BAD_REQUEST); //
    } 

    // http://localhost:8080/test/view/1
    // 변수명이 동일해야 자동으로 매핑된다.
    @GetMapping("/read") // URL 경로를 지정하는 annotation
    public ResponseEntity<TodoResponseDTO> read(@RequestParam("seq") int seq, Model model) { // public String read( int seq)
        System.out.println("debug >>>>> read test seq: " + seq);
        TodoResponseDTO response = service.readService(seq); // TestService의 readService() 메서드를 호출한다.
        System.out.println("debug >>>>> read test response: " + response);

        //model.addAttribute("read", response); // model에 response를 추가한다.
        
        // model.addAttribute("seq", seq); // model에 seq를 추가한다.
        // model.addAttribute("title", title); // model에 title을 추가한다.
        // model.addAttribute("content", content); // model에 content를 추가한다.
        // model.addAttribute("priority", priority); // model에 priority를 추가한다.



        // 기본화면 분기: forward
        return new ResponseEntity<TodoResponseDTO>(response, HttpStatus.OK); // test/read.jsp 파일을 반환한다.
    } 

    // http://localhost:8080/test/view/1
    // 변수명이 동일해야 자동으로 매핑된다.
    @GetMapping("/view/{seq}") // URL 경로를 지정하는 annotation
    public ResponseEntity<TodoResponseDTO> view(@PathVariable("seq") int seq, Model model) { // public String read( int seq)
        System.out.println("debug >>>>> view test seq: " + seq);
        TodoResponseDTO response = service.readService(seq); // TestService의 readService() 메서드를 호출한다.
        System.out.println("debug >>>>> view test response: " + response);

        //model.addAttribute("read", response); // model에 response를 추가한다.
        
    

        // 기본화면 분기: forward
        return new ResponseEntity<>(response, HttpStatus.OK); 
    } 


    // http://localhost:8080/test/update/1
    // 변수명이 동일해야 자동으로 매핑된다.

    // dto로 
    @PostMapping("/update") // URL 경로를 지정하는 annotation
    public ResponseEntity<String> update(
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
            return new ResponseEntity<String>("업데이트 성공", HttpStatus.OK); // test/select.jsp 파일을 반환한다.
        } else {
            System.out.println("debug >>>>> update test fail: " + flag);
            return new ResponseEntity<String>("업데이트 실패", HttpStatus.NO_CONTENT); // test/update.jsp 파일을 반환한다.
            
        }
        // return "test/update"; // test/update.jsp 파일을 반환한다.
    }


    // http://localhost:8080/test/select
    // 변수명이 동일해야 자동으로 매핑된다.
    @GetMapping("/select") // URL 경로를 지정하는 annotation
    public ResponseEntity<List<TodoResponseDTO>> select(Model model) { // public String read( int seq)
        System.out.println("debug >>>>> select test model: " + model);
        List<TodoResponseDTO> list = service.selectService(); // TestService의 selectService() 메서드를 호출한다.
        
        return new ResponseEntity<List<TodoResponseDTO>>(list, HttpStatus.OK); // test/select.jsp 파일을 반환한다.
    }
    
 




    // http://localhost:8080/test/delete/1
    // 변수명이 동일해야 자동으로 매핑된다.

    // transaction을 걸어야 한다.
    @GetMapping("/delete") // URL 경로를 지정하는 annotation
    public ResponseEntity<Void> delete(@RequestParam("seq")  int seq) { // public String read( int seq)
        System.out.println("debug >>>>> delete test seq: " + seq);

        int flag = service.deleteService(seq); // TestService의 deleteService() 메서드를 호출한다.
        System.out.println("debug >>>>> delete test flag: " + flag);
        if (flag != 0) {
            System.out.println("debug >>>>> delete test success: " + flag);
            return new ResponseEntity<>(HttpStatus.OK); // test/select.jsp 파일을 반환한다.
        } else {
            System.out.println("debug >>>>> delete test fail: " + flag);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // test/delete.jsp 파일을 반환한다.
            
        }
        // return "test/delete"; // test/delete.jsp 파일을 반환한다.
    }
    
}
