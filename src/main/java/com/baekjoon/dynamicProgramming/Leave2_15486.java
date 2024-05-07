package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Leave2_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = func.apply(st.nextToken());
        int day[] = new int[N + 2];
        int pay[] = new int[N + 2];
        int dp[] = new int[N + 2];

        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            day[n] = func.apply(st.nextToken());
            pay[n] = func.apply(st.nextToken());
        }

        dp[0] = 0;
        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            int d = i + day[i];

            max = Math.max(max, dp[i]);
            if(d <= N + 1) dp[d] = Math.max(dp[d], max + pay[i]);
        }

        System.out.println(max);

    }
}
