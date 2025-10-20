package com.example.calculator;

public class ArithmeticCalculator {
    private final ResultManager resultManager;

    public ArithmeticCalculator(ResultManager resultManager) {
        this.resultManager = resultManager;
    }

    // 사칙연산을 수행하는 메소드
    public <T extends Number> double calculate(T x, T y, OperatorType operator) {
        // T -> double 타입 변환
        double a = x.doubleValue();
        double b = y.doubleValue();
        double result = operator.apply(a, b);

        resultManager.add(result);

        return result;
    }
}
