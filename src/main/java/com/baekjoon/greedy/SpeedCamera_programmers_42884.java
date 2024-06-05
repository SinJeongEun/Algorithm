package com.example.baekjoon.baekjoon.greedy;

import java.util.Arrays;

public class SpeedCamera_programmers_42884 {
    public static void main(String[] args) {
        int routes[][] = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        solution(routes);
    }

    public static int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (a,b) -> a[1] - b[1]);

        int max = routes[0][1];

        for(int r[] : routes) {
            if(r[0] <= max && r[1] >= max)  continue;
            else {
                answer++;
                max = r[1];
            }
        }
        return answer;
    }
}
