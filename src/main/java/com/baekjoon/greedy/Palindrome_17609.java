package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

        for (int c = 0; c < cases; c++) {
            String str = br.readLine();
            //비교하기
            System.out.println(solve(0, str.length()-1, str, 0));
        }
    }

    public static int solve(int start1, int start2, String str, int cnt){
        if(cnt > 1) return 2;

        int result = cnt;
        while (start1 < start2){
            if(str.charAt(start1) != str.charAt(start2)) {
                result = Math.min(solve(start1, start2 - 1, str, cnt + 1), solve(start1 + 1, start2, str, cnt + 1));
                break;
            }
            start1++;
            start2--;
        }
//        System.out.println(result);
        return result;
    }
}
