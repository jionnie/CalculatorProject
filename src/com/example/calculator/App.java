package com.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResultManager rm = new ResultManager();
        ArithmeticCalculator calc = new ArithmeticCalculator(rm);

        while (true) {
            try {
                // 피연산자 2개 입력 받기
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String x_ = sc.nextLine();
                Double x = Double.parseDouble(x_);
                System.out.print("두 번째 숫자를 입력하세요: ");
                String y_ = sc.nextLine();
                Double y = Double.parseDouble(y_);

                // 사칙연산 기호 입력 받기
                System.out.print("어떤 연산을 하시겠습니까? (+, -, *, /): ");
                char op = sc.nextLine().charAt(0);
                OperatorType operator = OperatorType.fromSymbol(op);

                // 연산 수행
                double result = calc.calculate(x, y, operator);
                
                // 결과값 출력
                System.out.println("\n연산 결과: " + result);

                // 결과 기록 출력
                System.out.println("연산 기록: " + rm.getResults());
                System.out.println();

                // exit 입력 시 반복문 종료, del 입력 시 처음 기록 삭제
                System.out.println("1. [exit] 계산기 프로그램 종료\n" +
                        "2. [del] 처음 연산 기록 삭제\n" +
                        "3. [gt] 입력값 보다 큰 값들 출력\n" +
                        "4. [그 외 아무 키] 계산 계속하기");
                System.out.print("다음 중 하나를 선택하세요: ");

                String select = sc.nextLine();
                switch (select) {
                    case "exit":
                        break;
                    case "del":
                        if (!rm.getResults().isEmpty()) {
                            rm.removeFirst();
                            System.out.println("삭제 되었습니다.");
                            System.out.println("연산 기록: " + rm.getResults());
                        }
                        break;
                    case "gt":
                        System.out.print("비교 기준값을 입력하세요: ");
                        String input_ = sc.nextLine();
                        double input = Double.parseDouble(input_);
                        System.out.println(rm.getGreaterThan(input));;
                        break;
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("올바른 수를 입력하세요.\n");
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println(e.getMessage() + "\n");
            }
        }

    }
}