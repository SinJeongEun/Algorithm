package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretCode_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int nums[] = new int[n.length() + 1];
        int dp[] = new int[n.length() + 1];
        for (int i = 1; i <= n.length(); i++) {
            nums[i] = Integer.parseInt(String.valueOf(n.charAt(i-1)));
        }

        if(nums[1] == 0 ) {
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            int pre =nums[i-1];
            //한 글자
            if(nums[i] > 0 && nums[i] < 27){
                dp[i] += dp[i-1];
            }

            //두 글자
            if(!(pre == 0 || pre > 2 || (pre ==2 && nums[i] > 6))) {
                dp[i] += dp[i-2];
            }
            dp[i] %= 1000000;

        }
        for (int i = 0; i <= n.length(); i++) {
            System.out.println(dp[i] + " ");
        }
        System.out.println(dp[n.length()]);
    }
}
