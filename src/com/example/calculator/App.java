package com.example.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calc = new ArithmeticCalculator();

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

                // 입력값을 매개값으로 넘기며 연산 수행
                double result = switch (op) {
                    case '+' -> calc.calculate(x, y, OperatorType.PLUS);
                    case '-' -> calc.calculate(x, y, OperatorType.MINUS);
                    case '*' -> calc.calculate(x, y, OperatorType.MULTIPLY);
                    case '/' -> calc.calculate(x, y, OperatorType.DIVIDE);
                    default -> throw new IllegalArgumentException("잘못된 연산자 입력입니다.");
                };

                // 결과값 출력
                System.out.println("연산 결과: " + result);

                // 결과 기록 출력
                System.out.println("연산 기록: " + calc.getResults());

                // exit 입력 시 반복문 종료, del 입력 시 처음 기록 삭제
                System.out.print("[exit] 종료, [del] 처음 기록 삭제, [gt] 입력값 보다 큰 값들 출력하기, [그 외 아무 키] 계산 계속하기: ");
                String exit = sc.nextLine();
                if (exit.equals("exit")) {
                    break;
                } else if (exit.equals("del")) {
                    if (!calc.getResults().isEmpty()) {
                        calc.removeResult();
                        System.out.println("삭제 되었습니다.");
                        System.out.println("연산 기록: " + calc.getResults());
                    }
                } else if (exit.equals("gt")) {
                    System.out.print("비교 기준값을 입력하세요: ");
                    String input_ = sc.nextLine();
                    Double input = Double.parseDouble(input_);
                    calc.printResultGreaterThanInput(input);
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