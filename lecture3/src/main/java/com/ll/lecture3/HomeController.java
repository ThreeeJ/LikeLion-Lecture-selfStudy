package com.ll.lecture3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// 해당 클래스의 객체를
// 스프링부트가 생성하고(1개만)
// HTTP 요청을 처리할 때마다 사용하도록
@Controller
public class HomeController {

    @GetMapping("a")
    @ResponseBody
    public String hello(
            String age,
            String id
    ) {
        return "%s번 사람의 나이는 %s살 입니다.".formatted(age, id);
    }

    // 해당 메서드는 브라우저를 통해 호출 가능해집니다.
    // -> 이런 것을 "액션 메서드" 라고 부른다.
    @GetMapping("b")
    public void hello2() {
        System.out.println("Hello2!");
    }

    @GetMapping("c")
    @ResponseBody // 함수의 리턴값이 브라우저에 보여진다.
    // http://localhost:8090/c?a=10&b=20
    // a의 값(10)이 num1Str에 매핑되고, b의 값(20)이 num2Str에 매핑된다.
    public String plus(
            @RequestParam("a") String num1Str,
            @RequestParam("b") String num2Str
    ) {
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        return "a + b = %d".formatted(num1 + num2);
    }
}
