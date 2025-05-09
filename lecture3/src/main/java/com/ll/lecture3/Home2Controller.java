package com.ll.lecture3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home2")
public class Home2Controller {

    @Autowired
    private ComponentA componentA;

    // http://localhost:8090/home2/action1
    @GetMapping("/action1")
    @ResponseBody
    public String action1() {
        return componentA.action();
    }
}
