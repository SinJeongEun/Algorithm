package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Zoo_1309 {
    //경우의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n][3];
        Arrays.fill(dp[0],1);

        for (int i = 1; i < n; i++) {
            //dp[][0] 은 아예 동물을 넣지 않는 경우 : 이전칸의 모든 경우를 더하면 된다.
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            //dp[][1] 은 왼쪽에 동물을 넣을 경우 : 이전칸이 빈 경우 + 오른쪽에 넣은 경우
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            //dp[][2] 은 오른쪽에 동물을 넣을 결우 : 이전칸이 빈 경우 + 왼쪽에 넣은 경우
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        int sum = 0;
        for(int i =0; i<3; i++){
            sum+=dp[n-1][i];
        }
        System.out.println(sum%9901);

    }
}
