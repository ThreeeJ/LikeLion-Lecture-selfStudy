package com.ll.lecture3;

import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @GetMapping("b")
    public void hello2() {
        System.out.println("Hello2!");
    }

    @GetMapping("c")
    @ResponseBody
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
    public String d(boolean married) {
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

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor // lombok : 소스코드를 줄여줌
    public static class Person {

        private String name;
        private int age;
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
    public String person2(Person person) {
        return person.toString();
    }

    @GetMapping("f")
    @ResponseBody
    public int f() {
        return 10;
    }

    @GetMapping("g")
    @ResponseBody
    public boolean g() {
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

    @GetMapping("l") // list 반환
    @ResponseBody
    public List<Integer> l() {
        List<Integer> arr = List.of(40, 50, 60);
        return arr; // json
    }

    @GetMapping("m") // Map 반환
    @ResponseBody
    public Map<String, Object> m() {
        Map<String, Object> person = new HashMap<>();
        person.put("age", 23);
        person.put("name", "Paul");
        return person; // json
    }

    @AllArgsConstructor
    @Getter
    @Builder
    @ToString
    //@EqualsAndHashCode(onlyExplicitlyIncluded = true) : Post라는 객체 비교할 때 Include 들어간 애들만 확인
    public static class Post {
        //@ToString.Exclude : 출력할 때 id는 제외
        //@JsonIgnore : json 형식으로 반환할 때 id는 제외
        //@EqualsAndHashCode.Include : id만 비교해서 같으면 같은 객체
        private Long id;
        private LocalDateTime createDate;
        private LocalDateTime modifyDate;
        @Builder.Default
        private String subject = "제목 입니다.";
        private String body;
    }

    @GetMapping("/posts1")
    @ResponseBody
    public List<Post> getPosts1() {
        List<Post> posts = new ArrayList<>() {{
            add(new Post(1L, LocalDateTime.now(), LocalDateTime.now(), "제목 1", "내용 1"));
            add(new Post(2L, LocalDateTime.now(), LocalDateTime.now(), "제목 2", "내용 2"));
            add(new Post(3L, LocalDateTime.now(), LocalDateTime.now(), "제목 3", "내용 3"));
            add(new Post(4L, LocalDateTime.now(), LocalDateTime.now(), "제목 4", "내용 4"));
            add(new Post(5L, LocalDateTime.now(), LocalDateTime.now(), "제목 5", "내용 5"));
        }};

        return posts;
    }

    @GetMapping("/posts2")
    @ResponseBody
    public List<Post> getPosts2() {
        List<Post> posts = new ArrayList<>() {{
            add(
                    Post // 순서를 바꿔도 되는 장점이 있음. 조금 더 유연한 표현
                            .builder()
                            .id(1L)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .subject("제목 1")
                            .body("내용 1")
                            .build()
            );
            add(
                    Post // 순서를 바꿔도 되는 장점이 있음. 조금 더 유연한 표현
                            .builder()
                            .id(2L)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())
                            .subject("제목 2")
                            .body("내용 2")
                            .build()
            );
            add(
                    Post // 순서를 바꿔도 되는 장점이 있음. 조금 더 유연한 표현
                            .builder()
                            .id(3L)
                            .createDate(LocalDateTime.now())
                            .modifyDate(LocalDateTime.now())

                            .body("내용 3")
                            .build()
            );
        }};

        return posts;
    }

    @GetMapping("/posts/1")
    @ResponseBody
    public Post getPosts_1() {
        Post post = Post // 순서를 바꿔도 되는 장점이 있음. 조금 더 유연한 표현
                .builder()
                .id(1L)
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .subject("제목 1")
                .body("내용 1")
                .build();

        System.out.println(post);

        return post;
    }

    @SneakyThrows
    @GetMapping("/posts/2")
    @ResponseBody
    public Post getPosts_2() {
        Post post = Post // 순서를 바꿔도 되는 장점이 있음. 조금 더 유연한 표현
                .builder()
                .id(2L)
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .subject("제목 2")
                .body("내용 2")
                .build();

        Thread.sleep(5000);

        System.out.println(post);

        return post;
    }
}
