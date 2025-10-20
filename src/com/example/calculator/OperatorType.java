package com.example.calculator;

public enum OperatorType {
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
            default -> throw new IllegalArgumentException("올바르지 않은 연산자입니다.");
        };
    }
}