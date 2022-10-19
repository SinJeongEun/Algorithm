package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Palindrome_10942 {
    static int[] arr;
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = func.apply(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = func.apply(st.nextToken());
        }
        int M = func.apply(br.readLine());

        // dp 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) dp[i][j] = 1;
                else dp[i][j] = -1;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = func.apply(st.nextToken());
            int end = func.apply(st.nextToken());
            int result;
            if (arr[start] != arr[end]) result = 0;
            else if(start == end) result = 1;
            else if(start + 1 == end || start + 2 == end) {
                if(arr[start] == arr[end]) result = 1;
                else result = 0;
            }
            else {
                result = palindrome(start, end);
            }
            sb.append(result).append("\n");
        }
//        System.out.println(sb);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();


    }

    private static int palindrome(int s, int e) {
        if (s >= e) return 1; // 이 경우까지 내려가면 팰린드롬임
        if (dp[s][e] != -1) {
            return dp[s][e];
        }
        if(arr[s] == arr[e]) return  dp[s][e] = palindrome(s+1, e-1);
       return 0;
    }

}
