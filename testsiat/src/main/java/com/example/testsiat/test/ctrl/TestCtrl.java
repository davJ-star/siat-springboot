package com.example.testsiat.test.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.testsiat.test.service.TestService;

/*
 * IOC(Inversion of Control) : 제어의 역전. 객체의 생성과 생명주기를 Spring이 관리하는 것. -> Spring Container에서 관리
 * - DI(Dependency Injection) : 의존성 주입. 객체 간의 의존성을 Spring이 관리하는 것.
 * - DL(Dependency Lookup) : 의존성 조회. 객체 간의 의존성을 Spring이 관리하지 않는 것.
 */

/*
 * 사용자 요청과 관련된 Annotation
 *   * @RequestMapping : HTTP 요청을 처리하는 메서드에 붙이는 annotation
 * 
 */

 /*
  * 의존성 관리를 위한 annotation
    *  * @Autowired : Spring에서 관리하는 객체를 주입받는 annotation
    *  * @Injection : Spring에서 관리하는 객체를 주입받는 annotation
    *  * @Resource : Spring에서 관리하는 객체를 주입받을 때, 어떤 객체를 주입받을지 지정하는 annotation
    *  * @Qualifier : Spring에서 관리하는 객체를 주입받을 때, 어떤 객체를 주입받을지 지정하는 annotation
  */


/*
 객체 생성과 관련된 annotation
    * @Component : Spring에서 관리하는 일반적인 컴포넌트에 붙이는 annotation
    * @Controller : Spring MVC에서 Controller 역할을 하는 클래스에 붙이는 annotation
    * @Service : 비즈니스 로직을 처리하는 클래스에 붙이는 annotation
    * @Repository : 데이터베이스와의 상호작용을 처리하는 클래스에 붙이는 annotation
 */

 // class에 매핑할 수도 있고, 메서드에 매핑할 수도 있다.
    // class에 매핑할 경우, 메서드에 매핑된 URL 경로는 class에 매핑된 URL 경로를 기준으로 한다.
    // 예를 들어, class에 "/test"가 매핑되어 있고, 메서드에 "/test2"가 매핑되어 있다면, 실제 URL 경로는 "/test/test2"가 된다.
    
    
// @Controller는 Spring MVC에서 Controller 역할을 하는 클래스에 붙이는 annotation이다.
@Controller

// user라면 @RequestMapping("/user")를 붙여야 한다.
@RequestMapping("/test") // URL 경로를 지정하는 annotation
public class TestCtrl {

    @Autowired // TestService 객체를 자동으로 주입받는다.
    private TestService service; // TestService 객체를 주입받는다.
    
    // public TestCtrl() {
    //     System.out.println("TestCtrl 생성자 호출");
    // }
    
    @RequestMapping("/insert") // URL 경로를 지정하는 annotation
    //@RequestMapping("path", method=RequestMethod.GET)
    public String insert() {
        System.out.println("insert() 호출");
        // service
        service.insertRow();
        return "insert"; // insert.jsp 파일을 반환
    }

    @RequestMapping("/update") // URL 경로를 지정하는 annotation
    public String update() {
        System.out.println("update() 호출");
        return "update"; // update.jsp 파일을 반환
    }

    @RequestMapping("/delete") // URL 경로를 지정하는 annotation
    public String delete() {
        System.out.println("delete() 호출");
        return "delete"; // delete.jsp 파일을 반환
    }
    @RequestMapping("/select") // URL 경로를 지정하는 annotation
    public String select() {
        System.out.println("select() 호출");
        return "select"; // select.jsp 파일을 반환
    }

    // @RequestMapping("/test") // URL 경로를 지정하는 annotation
    // public String test() {
    //     return "test"; // test.jsp 파일을 반환
    // }

    // @RequestMapping("/test2") // URL 경로를 지정하는 annotation
    // public String test2() {
    //     return "test2"; // test2.jsp 파일을 반환
    // }
    
}




/*
 객체 생성과 관련된 annotation
    * @Controller : Spring MVC에서 Controller 역할을 하는 클래스에 붙이는 annotation
    * @RestController : @Controller + @ResponseBody. JSON/XML 형태로 응답을 보내는 Controller에 붙이는 annotation
    * @Service : 비즈니스 로직을 처리하는 클래스에 붙이는 annotation
    * @Repository : 데이터베이스와의 상호작용을 처리하는 클래스에 붙이는 annotation
    * @Component : Spring에서 관리하는 일반적인 컴포넌트에 붙이는 annotation
    * @Configuration : Spring의 설정 정보를 담고 있는 클래스에 붙이는 annotation
    * @Bean : Spring에서 관리하는 객체를 생성하는 메서드에 붙이는 annotation
    * @Autowired : Spring에서 관리하는 객체를 주입받는 annotation
    * @Value : Spring에서 관리하는 프로퍼티 값을 주입받는 annotation
    * @Qualifier : Spring에서 관리하는 객체를 주입받을 때, 어떤 객체를 주입받을지 지정하는 annotation
    * @Primary : Spring에서 관리하는 객체를 주입받을 때, 기본적으로 주입받을 객체를 지정하는 annotation
    * @Scope : Spring에서 관리하는 객체의 범위를 지정하는 annotation
 */

