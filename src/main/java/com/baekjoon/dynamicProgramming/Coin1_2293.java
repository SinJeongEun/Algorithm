package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Coin1_2293 {
    static int n;
    static int k;
    static int[] nums;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = func.apply(st.nextToken());
        k = func.apply(st.nextToken());
        nums = new int[n];
        dp = new int[k+1];
        for (int i = 0; i < n; i++) {
            nums[i] = func.apply(br.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = nums[i]; j < k+1; j++) {
                dp[j] += dp[j - nums[i]];
            }
        }
        System.out.println(dp[k]);

    }
}
