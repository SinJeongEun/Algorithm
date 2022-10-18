package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int result = 0;
            if (N == 1) result = 0;
            else if(start == end) result = 1;
            else if(arr[start] != arr[end]) result = 0;
            else if((start + 1 <= N) && (end - 1 >= 0) && (dp[start+1][end-1] == 1)) {
                if(arr[start] == arr[end]) result = 1;
                else result = 0;
            }
            else if(start + 1 == end || start + 2 == end) {
//                System.out.println("start : " + arr[start] +" end : " + arr[end]);
                if(arr[start] == arr[end]) result = 1;
                else result = 0;
            }
            else {
                result = palindrome(start, end) ? 1 : 0;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);


    }

    private static boolean palindrome(int s, int e) {
        while (s <= e) {
//            if(dp[s][e] == 1) return true;
            if (dp[s][e] == 0) {
                return false;
            }
            else if(dp[s][e] == -1){ // 계산하고 팰린드롬이면 1, 아니면 0
                if(arr[s] == arr[e]){
                    dp[s][e] = 1;
                }
                else {
                    dp[s][e] = 0;
                    return false;
                }
            }
            s++;
            e--;

        }
        return true;
    }

}
