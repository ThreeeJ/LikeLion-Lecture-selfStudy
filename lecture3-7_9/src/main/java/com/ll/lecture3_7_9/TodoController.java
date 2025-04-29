package com.ll.lecture3_7_9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("") // 조회
    public List<Todo> getTodos() {
        return todos;
    }

    @GetMapping("/detail")
    public Todo getTodo1(
            long id
    ) {
        return todos
                .stream()
                .filter(
                        todo -> todo.getId() == id
                )
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/{id}") // {} 감싸져 있으면 어떤 변수가 올지 모른다.
    // 주소 자체에 숫자를 넣으면 "id=숫자" 로 인식
    public Todo getTodo2(
            @PathVariable long id // 주소에 적은 숫자값이 여기에 들어간다.
            // 그렇게 하기 위해서는, @PathVariable 이거 붙여야 한다.
    ) {
        return todos
                .stream()
                .filter(
                        todo -> todo.getId() == id
                )
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/add") // 추가
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
