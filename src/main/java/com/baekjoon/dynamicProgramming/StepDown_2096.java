package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class StepDown_2096 {
    // 얻을 수 있는 최대 점수와 최소 점수를 출력한다.
    // 각 dp 줄에 0 1 2 번째 수를 더한 최소/최대 점수를 저장하게 된다.
    // 즉 dp의 마지막 줄에는 각 경우의 최종 점수가 저장된다 -> 마지막 배열 값이 정답이 아니라는 의미이다. !!!
    // 최종적인 최소/최대 점수를 구하기 위해서는 마지막 라인의 결과값들 중에서 최소, 최대 값을 찾아 출력해야 된다. !!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String, Integer> func = Integer::parseInt;
        StringBuilder sb = new StringBuilder();
        int n = func.apply(br.readLine());
        int dp[] = new int[3]; // 최대 점수 계산 배열
        int dp2[] = new int[3]; // 최소 점수 계산 배열

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = func.apply(st.nextToken());
            int num2 = func.apply(st.nextToken());
            int num3 = func.apply(st.nextToken());

            if(i == 0) {
                // 최대 dp
                dp[0] = num1;
                dp[1] = num2;
                dp[2] = num3;

                // 최소 dp
                dp2[0] = num1;
                dp2[1] = num2;
                dp2[2] = num3;
            } else {
                //최대 점수 구하기
                int before_0 = dp[0];
                int before_1 = dp[1];
                dp[0] = Math.max(dp[0], dp[1]) + num1;
                dp[1] = Math.max(before_0, Math.max(before_1, dp[2])) + num2;
                dp[2] = Math.max(before_1, dp[2]) + num3;

                //최소 점수 구하기
                int before2_0 = dp2[0];
                int before2_1 = dp2[1];
                dp2[0] = Math.min(dp2[0], dp2[1]) + num1;
                dp2[1] = Math.min(before2_0, Math.min(before2_1, dp2[2])) + num2;
                dp2[2] = Math.min(before2_1, dp2[2]) + num3;
            }

        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dp[i]);
        }
        sb.append(max);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp2[i]);
        }
        sb.append(" ").append(min);

        System.out.println(sb);
    }
}
