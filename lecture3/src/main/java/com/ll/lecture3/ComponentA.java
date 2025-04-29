package com.ll.lecture3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @RequiredArgsConstructor : 얘를 붙이면, final 쓰고, @Autowired 없애도 됌
public class ComponentA {

    @Autowired // 클래스에 @Component가 붙어있거나,
    // 스프링부트 프로젝트 안에서 @Configuration이 붙은 클래스 안에 있거나
    private ComponentB componentB;

    @Autowired
    private ComponentC componentC;
    // private final ComponentC componentC; -> 라고 써도 됌.
    @Autowired
    private ComponentD componentD;
    @Autowired
    private ComponentE componentE;

    public String action() {
        return "ComponentA action / " + componentB.getAction();
    }
}
