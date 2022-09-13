package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Jump_1890 {
    static int tests;
    static int[][] board;
    static long[][] dp;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st;

        tests = func.apply(br.readLine());
        board = new int[tests][tests];
        dp = new long[tests][tests];
        visited = new boolean[tests][tests];
        for (int i = 0; i < tests; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < tests; j++) {
                board[i][j] = func.apply(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for(int i = 0; i < tests; i++) {
            for(int j = 0; j < tests; j++) {
                if(board[i][j] == 0)
                    break;
                if(i+board[i][j] < tests)
                    dp[i+board[i][j]][j] += dp[i][j];
                if(j+board[i][j] < tests)
                    dp[i][j+board[i][j]] += dp[i][j];
            }
        }
//        for (int i = 0; i < tests; i++) {
//            System.out.println();
//            for (int j = 0; j < tests; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//        }
//        System.out.println();
        System.out.println(dp[tests-1][tests-1]);
    }
}
