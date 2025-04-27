package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("할일 관리 앱, 시작");

        try (Scanner sc = new Scanner(System.in)) {
            List<Todo> todos = new ArrayList<>();
            long todosLastId = 0;

            while (true) {
                System.out.print("명령) ");
                String cmd = sc.nextLine().trim();

                if (cmd.equals("exit")) break;
                else if (cmd.equals("add")) {
                    long id = todosLastId + 1;
                    System.out.print("할일 : ");
                    String content = sc.nextLine().trim();

                    Todo todo = new Todo(id, content);
                    todos.add(todo);
                    todosLastId++;

                    System.out.printf("%d번 할일이 생성되었습니다.\n", id);
                }
                else if (cmd.equals("list")) {
                    System.out.println("번호 / 내용");

                    for (Todo todo : todos) {
                        System.out.printf("%d / %s\n", todo.getId(), todo.getContent());
                    }
                    // todos.forEach(todo -> System.out.printf("%d / %s\n", todo.getId(), todo.getContent()));
                }
                else if (cmd.equals("del")) {
                    System.out.print("삭제할 할일의 번호 : ");
                    long id = Long.parseLong(sc.nextLine().trim());

                    boolean isRemoved = todos.removeIf(todo -> todo.getId() == id);

                    if (!isRemoved) {
                        System.out.printf("%d번 할일은 존재하지 않습니다.\n", id);
                        continue;
                    }

                    System.out.printf("%d번 할일이 삭제되었습니다.\n", id);
                }
            }
        }

        System.out.println("할일 관리 앱, 끝");
    }
}
