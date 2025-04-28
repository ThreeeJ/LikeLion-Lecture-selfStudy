package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoController {
    // 이제 각 컨트롤러가 자신의 전문 분야와 관련된 요청을 처리하고,
    // App은 고객의 요청이 적절한 컨트롤러에게 연결되도록 하는 작업만 수행합니다.

    private Scanner sc;
    private List<Todo> todos;
    private long todosLastId;

    public TodoController() {
        sc = new Scanner(System.in);
        todos = new ArrayList<>();
        todosLastId = 0;
    }

    public void add() {
        long id = todosLastId + 1;
        System.out.print("할일 : ");
        String content = sc.nextLine().trim();

        Todo todo = new Todo(id, content);
        todos.add(todo);
        todosLastId++;

        System.out.printf("%d번 할일이 생성되었습니다.\n", id);
    }

    public void list() {
        System.out.println("번호 / 내용");

        for (Todo todo : todos) {
            System.out.printf("%d / %s\n", todo.getId(), todo.getContent());
        }
    }

    public void del() {
        System.out.print("삭제할 할일의 번호 : ");
        long id = Long.parseLong(sc.nextLine().trim());

        boolean isRemoved = todos.removeIf(todo -> todo.getId() == id);

        if (!isRemoved) {
            System.out.printf("%d번 할일은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("%d번 할일이 삭제되었습니다.\n", id);
    }

    public void modify() {
        System.out.print("수정할 할일의 번호 : ");
        long id = Long.parseLong(sc.nextLine().trim());

        Todo foundTodo = todos.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
        // 해당 리스트에서 조건식의 결과가 참인 요소를 하나만 반환하고,
        // 없다면 null을 반환

        if (foundTodo == null) {
            System.out.printf("%d번 할일은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("기존 할일 : %s\n", foundTodo.getContent());
        System.out.print("새 할일 : ");
        foundTodo.setContent(sc.nextLine().trim());

        System.out.printf("%d번 할일이 수정되었습니다.\n", id);
    }
}
