package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class CombineFiles_11066 {
    //파일 합치기
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        N = func.apply(br.readLine()); // 테스트케이스 수

        for (int i = 0; i < N; i++) {
            int n = func.apply(br.readLine());
            int dp[][] = new int[n][n];
            int values[] = new int[n];
            int sum[] = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int a = 0; a < n; a++) {
                values[a] = func.apply(st.nextToken());
            }

            sum[0] = values[0];
            for (int b = 1; b < n; b++) {
                sum[b] = sum[b-1] + values[b];
            }

            for(int j=0;j<n-1;j++) {
                dp[j][j+1]=values[j]+values[j+1];
                // dp[i][j]는 i번째부터 j번째 인덱스까지의 최소 합을 의미
            }

            for(int gap=2;gap<n;gap++) {
                for(int c=0;c+gap<n;c++) {
                    int d = c + gap;
                    dp[c][d]=Integer.MAX_VALUE;

                    for(int k=c;k<d;k++) {
                        dp[c][d] = Math.min(dp[c][k] + dp[k+1][d] + sumAtoB(sum, c, d), dp[c][d]);
                    }
                }
            }

            System.out.println(dp[0][n-1]);

        }




    }

    public static int sumAtoB(int[] a, int s, int e){
        if(s == 0)    return a[e];
        else          return a[e] - a[s-1];
    }
}
