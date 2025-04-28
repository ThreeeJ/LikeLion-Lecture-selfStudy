package com.ll.lecture3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// 해당 클래스의 객체를
// 스프링부트가 생성하고(1개만)
// HTTP 요청을 처리할 때마다 사용하도록
@Controller
public class HomeController {

    @GetMapping("a")
    @ResponseBody
    public String hello() {
        return "Hello";
    }

    // 해당 메서드는 브라우저를 통해 호출 가능해집니다.
    // -> 이런 것을 "액션 메서드" 라고 부른다.
    @GetMapping("b")
    public void hello2() {
        System.out.println("Hello2!");
    }

    @GetMapping("c")
    @ResponseBody // 함수의 리턴값이 브라우저에 보여진다.
    public String hello3() {
        return "안녕하세요.";
    }
}
