package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Seats_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        Queue<Integer> vips = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            vips.offer(Integer.parseInt(br.readLine()));
        }
        vips.offer(N+1);

        int start = 0;
        int answer = 1;
        int[]dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        while (!vips.isEmpty()){
            int end = vips.poll();
            System.out.println("start , end : " + start + " " + end + " " + (end-start));
            for (int i = 2; i < end-start; i++) {
                dp[i] = dp[i-1] + dp[i-2];
                System.out.println(dp[i]);
            }
            System.out.println(dp[end-start-1]);
            answer *= dp[end-start-1];
            start = end;

        }
        System.out.println("~~" + answer);


    }
}
