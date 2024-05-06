package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Coin_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = func.apply(st.nextToken());

        for (int t = 0; t < T; t++) {

            // 코인 종류 배열에 담기
            st = new StringTokenizer(br.readLine());
            int coin_len = func.apply(st.nextToken());
            int coin[] = new int[coin_len];
            st = new StringTokenizer(br.readLine());

            for (int cl = 0; cl < coin_len; cl++) {
                coin[cl] = func.apply(st.nextToken());
            }

            int goal_amt = func.apply(br.readLine());
            int dp[] = new int[goal_amt + 1];
            dp[0] = 1;

            for (int i = 0; i < coin_len; i++) {
                for (int j = coin[i]; j <= goal_amt ; j++) {
                    dp[j] += dp[j - coin[i]];
                }
            }

            System.out.println(dp[goal_amt]);
        }
    }
}
