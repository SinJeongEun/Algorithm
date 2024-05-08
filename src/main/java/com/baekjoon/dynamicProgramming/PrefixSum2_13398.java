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
        int prefixSum[] = new int[N];

        // 누적함 계산
        prefixSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // 하나씩 제외하면서 최댓값 구하기
        int dp[] = new int[N];
        dp[0] = prefixSum[0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int max = Math.max(prefixSum[i], prefixSum[i] - arr[j]);
                dp[i] = Math.max(max, dp[i]);
            }
        }

        // 하나씩 제외된 부분 합 중에 특정 연속된 부분합 중 최댓갑
        int result[] = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                result[i] = Math.max(dp[i], dp[i] - dp[j] );
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());;
    }
}
