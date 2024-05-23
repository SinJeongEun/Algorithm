package com.example.baekjoon.baekjoon.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StokckPrice_programmers_42584 {
    public static void main(String[] args) {
//        int prices[] = {1,2,3,2,3};
        int prices[] = {1,2,3,3,2,3};

        System.out.println(solution(prices));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stock = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stock.isEmpty() && prices[stock.peek()] > prices[i]) {
                // 1. 감소된 시점 인덱스에 값을 채운다
                // 2. 감소된 시점(idx) 는 pop()
                // 3. 반복문 종료 후 스택을 돌면서 끝까지 남은(감소되지 않은) 부분은 prices.length 기준으로 계산한다.
                int popIdx = stock.pop();
                answer[popIdx] = i - popIdx;

            }
            stock.push(i);
        }

        while (!stock.isEmpty()) {
            int idx = stock.pop();
            answer[idx] = prices.length - idx - 1;
        }
        return answer;
    }



    // 2중 for
    public static List<Integer> solution_1(int[] prices) {
        List<Integer> answer = new ArrayList<>();

        for(int i=0;i< prices.length;i++){
            int count=0;
            for(int j=i+1;j<prices.length;j++){
                if(prices[i] <= prices[j]) count++;
                else {
                    count++;
                    break;
                }
            }
            answer.add(count);
        }
        return answer;
    }
}
