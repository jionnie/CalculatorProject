package com.example.calculator;

public enum OperatorType {
    // 각 열거 상수가 추상 메소드를 익명 내부 클래스 형식으로 재정의
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        }
    };

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    // 추상 메소드 선언
    public abstract double apply(double a, double b);

    public static OperatorType fromSymbol(char symbol) {
        return switch (symbol) {
            case '+' -> PLUS;
            case '-' -> MINUS;
            case '*' -> MULTIPLY;
            case '/' -> DIVIDE;
            default -> throw new IllegalArgumentException("올바른 연산자를 입력하세요.");
        };
    }
}