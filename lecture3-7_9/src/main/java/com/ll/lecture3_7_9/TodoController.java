package com.ll.lecture3_7_9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // 메서드마다 달던 @ResponseBody 안붙여도 됌.
@RequestMapping("/todos")
public class TodoController {

    private long todosLastId;
    private List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<>();
    }

    @GetMapping("/add")
    public Todo add(
            String body
    ) {
        Todo todo = Todo
                .builder()
                .id(++todosLastId)
                .body(body)
                .build();

        todos.add(todo);

        return todo;
    }
}
