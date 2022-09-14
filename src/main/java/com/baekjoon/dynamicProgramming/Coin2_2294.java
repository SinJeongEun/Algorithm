package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Coin2_2294 {
//    이전의 Coin1번 문제와는 다르다. Coin1 문제는 k원ㅇ르 만들 수 있는 모든 경우의 수 !
//    최소한의 동전을 사용해서 만들 때 사용한 '동전의 개수'를 구하는 문제이다.
//    (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 이므로 마지막에 조건을 주어 출력해야된다. <- 이부분 처리를 안해서 실패됐었음
//    dp[0] = 0 인 이유 : 1원의 동전으로 1원을 만들 수 있는 경우의 수는 (0원 만드는 경우의 수)+1 이기 때문이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = func.apply(st.nextToken()); // 동전의 종류
        int t = func.apply(st.nextToken()); // 목표 값
        int coin[] = new int[n];
        int dp[] = new int[t + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = func.apply(br.readLine());
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= t; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        System.out.println(dp[t] == 10001 ? -1 : dp[t]);

    }
}
