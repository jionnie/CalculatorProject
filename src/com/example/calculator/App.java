package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 양의 정수 2개 입력 받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int x = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int y = sc.nextInt();

            // 사칙연산 기호 입력 받기
            System.out.print("어떤 연산을 하시겠습니까? (+, -, *, /): ");
            char op = sc.next().charAt(0);

            int result = 0;
            // 사칙연산 기호에 맞는 연산 수행
            switch (op) {
                case '+':
                    result = x + y;
                    break;
                case '-':
                    result = x - y;
                    break;
                case '*':
                    result =  x * y;
                    break;
                case '/':
                    if (y == 0) {
                        System.out.println("나눗셈 연산에서 분모가 0이 될 수 없습니다.");
                        continue;
                    }
                    result = x / y;
                    break;
                default:
                    System.out.println("잘못된 입력입니다! (+, -, *, /) 중 하나를 입력하세요.");
                    continue;
            }

            // 연산 결과 출력
            System.out.println("연산 결과: " + result);

            // exit 입력 시 반복문 종료
            System.out.print("계산을 계속 하시겠습니까? (exit 입력 시 종료): ");
            String exit = sc.next();
            if (exit.equals("exit")) {
                break;
            }
        }
    }
}