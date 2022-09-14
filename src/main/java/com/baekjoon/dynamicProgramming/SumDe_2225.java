package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumDe_2225 {
    // 0 ~ n 까지의 정수 k개의 합이 n이 되는 경우의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //0~n까지의 정수
        int k = Integer.parseInt(st.nextToken()); // k 개

        int dp[] = new int [n + 1];
        dp[0] = 1;
        for (int num = 1; num <= k ; num++) {
            for (int j = 1; j <= n; j++) {
                dp[j] += dp[j - 1];
                System.out.println("dp["+j+"] :" + dp[j]);
            }

        }

        System.out.println(dp[n] % 1000000000);
    }
}
