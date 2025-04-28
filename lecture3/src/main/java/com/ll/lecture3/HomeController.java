package com.ll.lecture3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("c") // 액션 메서드 -> 요청(편지(글))에 의해서 실행
    @ResponseBody
//  - XML과 JSON
//      - String으로 객체를 표현하는 방법에 대한 표준이 보통 XML과 JSON이 있는데 JSON을 많이 사용
//      - XML보단 JSON이 간단함.
//
//  - 스프링부트
//      - String => 자바객체
//          - 글 => 생각
//      - 자바객체 => String
//          - 생각 => 글
//
//  - Jackson
//      - Jackson은 액션 메서드가 String 이외의 형태의 데이터를 리턴하면,
//      - String 형태(그 중에서 JSON 방식)로 변경
    public String plus(
            @RequestParam("a") int num1,
            @RequestParam("b") int num2,
            @RequestParam(name = "c", defaultValue = "0") int num3
            // c라는 파라미터는 만약 값이 넘어오지 않는다면 값은 0으로
    ) {
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);

        return "a + b + c = %d".formatted(num1 + num2 + num3);
    }

    @GetMapping("d")
    @ResponseBody
    public String d(
            boolean married
            // Jackson이 알아서 String을 자바 자료구조로 바꿔줌
            // boolean일 때 값이 없으면 기본값은 fasle
    ) {
        return married ? "결혼" : "미혼";
    }

    @GetMapping("e")
    @ResponseBody
    public String e(
            // 만약 married에 값이 들어왔는지 안들어왔는지, true, false 인지 3가지로 구분하고 싶다.
            Boolean married // boolean -> Boolean

    ) {
        if (married == null) return "정보를 입력해주세요.";
        return married ? "결혼" : "미혼";
    }


    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @GetMapping("person1")
    @ResponseBody
    public String person1(
            String name,
            int age
    ) {
        Person person = new Person(name, age);

        return person.toString();
    }

    @GetMapping("person2")
    @ResponseBody
    public String person2(
            Person person
            // 스프링부트가 Jackson을 이용해서 "알아서"
            // 정보들을 모아가지고, 객체로 만들어줌.
    ) {
        return person.toString();
    }

    @GetMapping("f")
    @ResponseBody
    public int f(
    ) {
        return 10;
    }

    @GetMapping("g")
    @ResponseBody
    public boolean g(
    ) {
        return true;
    }

    @GetMapping("h")
    @ResponseBody
    public int h() {
        int age = 10;
        return age; // Jackson이 알아서 문장화함.
    }

    @GetMapping("i")
    @ResponseBody
    public boolean i() {
        boolean married = true;

        return married;
    }

    @GetMapping("j") // 객체 반환
    @ResponseBody
    public Person j() {
        Person person = new Person("Paul", 25);

        return person; // json
    }

    @GetMapping("k") // 배열 반환
    @ResponseBody
    public int[] k() {
        int[] arr = new int[] {10, 20, 30};

        return arr; // json
    }

    @GetMapping("l")
    @ResponseBody
    public List<Integer> l() {
        List<Integer> arr = List.of(40, 50, 60);

        return arr; // json
    }

    @GetMapping("m")
    @ResponseBody
    public Map<String, Object> m() {
        Map<String, Object> person = new HashMap<>();
        person.put("age", 23);
        person.put("name", "Paul");

        return person; // json
    }
}
