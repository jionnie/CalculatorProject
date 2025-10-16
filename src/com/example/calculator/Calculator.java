package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
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

    // 양의 정수 2개와 연산 기호를 매개변수로 받아 사칙연산을 수행하는 메소드
    public int calculate(int x, int y, char op) {

        // 사칙연산 기호에 맞는 연산 수행
        switch (op) {
            case '+':
                results.add(x + y);
                break;
            case '-':
                results.add(x - y);
                break;
            case '*':
                results.add(x * y);
                break;
            case '/':
                if (y == 0) {
                    System.out.println("나눗셈 연산에서 분모가 0이 될 수 없습니다.");
                    break;
                }
                results.add(x / y);
                break;
            default:
                System.out.println("잘못된 입력입니다! (+, -, *, /) 중 하나를 입력하세요.");
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