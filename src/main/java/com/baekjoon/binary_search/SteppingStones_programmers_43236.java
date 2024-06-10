package com.example.baekjoon.baekjoon.binary_search;

import java.util.Arrays;

public class SteppingStones_programmers_43236 {
    public static void main(String[] args) {
        int rocks[] = {2, 14, 11, 21, 17};
        solution(25, rocks, 2);
    }

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        int left = 0;
        int right = distance;

        int mid;
        int cnt;
        int prev;
        while (left <= right) {
            mid = (left + right) / 2;
            cnt = 0;
            prev = 0;

            for (int i = 0; i < rocks.length; i++) {
                if(rocks[i] - prev < mid) {
                    // 돌간의 최소거리를 mid로 만들기 위해 돌 삭제
                    cnt++;
                }else prev = rocks[i];

                if(cnt > n) break;
            }

            if(distance - prev < mid) cnt++;

            if(cnt <= n) {
                left = mid + 1; // 동일한 cnt 에서 mid가 더 큰 경우가 있을 수도 있으니 확인하기 위함
                answer = mid;
            }
            else right = mid - 1; // 돌을 너무 많이 제거했으므로 right 감소

            answer = mid;
        }
        return answer;
    }
}
