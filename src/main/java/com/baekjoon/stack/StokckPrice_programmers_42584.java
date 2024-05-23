package com.example.baekjoon.baekjoon.stack;

import java.util.ArrayList;
import java.util.List;

public class StokckPrice_programmers_42584 {
    public static void main(String[] args) {
        int prices[] = {1,2,3,2,3};

        System.out.println(solution(prices));
    }

    public static List<Integer> solution(int[] prices) {
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
