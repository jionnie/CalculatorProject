package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            // 양의 정수 2개 입력 받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int x = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int y = sc.nextInt();

            // 사칙연산 기호 입력 받기
            System.out.print("어떤 연산을 하시겠습니까? (+, -, *, /): ");
            char op = sc.next().charAt(0);

            // 입력값을 매개값으로 넘기며 연산 수행
            int result = calc.calculate(x, y, op);

            // 결과값 출력
            System.out.println("연산 결과: " + result);

            // 결과값 삭제 (값이 저장 되자마자 지워져서 초기 상태가 됨)
            if (!calc.getResults().isEmpty()) {
                calc.removeResult();
            }

            // exit 입력 시 반복문 종료
            System.out.print("계산을 계속 하시려면 아무 키나 입력하세요. (exit 입력 시 종료): ");
            String exit = sc.next();
            if (exit.equals("exit")) {
                break;
            }
        }

    }
}