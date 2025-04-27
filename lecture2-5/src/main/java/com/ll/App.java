package com.ll;

import java.util.Scanner;

public class App {
    public void run() {
        System.out.println("할일 관리 앱, 시작");

        //Scanner sc = new Scanner(System.in);
        // sc.close(); -> 이것을 안쓰고 싶으면 try로 감싸기

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim(); // trim() : 좌우 공백 제거

            System.out.printf("입력한 명령: %s\n", cmd);
        }

        System.out.println("할일 관리 앱, 끝");
    }
}
