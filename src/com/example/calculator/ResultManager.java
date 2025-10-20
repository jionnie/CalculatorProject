package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultManager {
    // 연산 결과를 저장하는 컬렉션 타입 필드
    private List<Double> results = new ArrayList<>();

    // 리스트에 값을 추가하는 메소드
    public void add(double result) {
        results.add(result);
    }

    // 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능을 가진 메소드
    public void removeFirst() {
        if (!results.isEmpty()) {
            results.remove(0);
        }
    }

    // getter
    // 그냥 return results; 하면 외부에서 접근 가능(private 접근 제한이 무의미) -> 원본의 복사본을 반환
    public List<Double> getResults() {
        return new ArrayList<>(results);
    }

    // setter
    public void setResults(List<Double> newResults) {
        this.results = newResults;
    }

    // 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값들을 출력하는 메소드
    public List<Double> getGreaterThan(double threshold) {
        return results.stream()
                .filter(num -> num > threshold)
                .collect(Collectors.toList());
    }
}
