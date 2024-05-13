package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrefixSum2_13398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 하나씩 제외하면서 최댓값 구하기
        int dp[][] = new int[N][2];

        int max = arr[0];
        dp[0][0] = arr[0];  // 수 한개 제거
        dp[0][1] = arr[0];  // 제거하지 않음

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);        // arr[i] 제거하지 않을 경우
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);  // arr[i]가 제거된 경우 , arr[i]이전에 제거된 수가 있는 경우
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(max);
    }
}
