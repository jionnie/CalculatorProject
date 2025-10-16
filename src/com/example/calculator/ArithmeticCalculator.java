package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {

    // 연산 결과를 저장하는 컬렉션 타입 필드
    private List<Integer> results = new ArrayList<Integer>();

    // getter
    // 그냥 return results; 하면 외부에서 접근 가능(private 접근 제한이 무의미) -> 원본의 복사본을 반환
    public List<Integer> getResults() {
        return new ArrayList<>(results);
    }

    // setter
    public void setResults(List<Integer> newResults) {
        this.results = newResults;
    }

    // 사칙연산을 수행하는 메소드
    public int calculate(int x, int y, OperatorType operator) {

        // 사칙연산 기호에 맞는 연산 수행
        switch (operator) {
            case PLUS:
                results.add(x + y);
                break;
            case MINUS:
                results.add(x - y);
                break;
            case MULTIPLY:
                results.add(x * y);
                break;
            case DIVIDE:
                if (y == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                results.add(x / y);
                break;
        }

        // 가장 마지막에 추가된 요소 반환
        // ArrayList(result)의 size가 0이 아닐 때만 result.size() - 1
        if (results.isEmpty()) {
            return 0;
        } else {
            return results.get(results.size() - 1);
        }
    }

    // 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메소드
    public void removeResult() {
        results.remove(0);
    }
}
