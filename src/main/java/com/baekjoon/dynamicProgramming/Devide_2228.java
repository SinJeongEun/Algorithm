package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Devide_2228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 숫자의 개수
        int M = Integer.parseInt(s[1]); // 그룹의 수
        int num[] = new int[N + 1];
        int sumarr[] = new int[N + 1];
        int dp[][] = new int[N+1][M+1];
        final int MIN = -32768*100;

        //각 인덱스 까지의 합 구하기
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
            sumarr[i] = sumarr[i-1] + num[i];
        }


//        for (int i = 0; i <= N ; i++) {
//            Arrays.fill(dp[i], MIN);
//            Arrays.stream(dp[i]).forEach(a-> System.out.println(a));
//        }
        for (int n = 0; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                dp[n][m] = MIN;
            }
        }

        dp[1][1] = num[1];

        for (int n = 2; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                dp[n][m] =  dp[n-1][m]; // n번째 수가 구간에 포함되지 않는 경우

                int min = 0;
                if(m == 1) min = -1;
                for (int k = n - 2; k >= min; k--) {
                    if(k < 0)  dp[n][m] = Math.max(dp[n][m], sumarr[n]);

                    // n번째를 포함하면서 m-1번째 구간이 n-2를 넘지 않는 경우 중 가장 큰 값을 선택하면 된다.
                    else dp[n][m] = Math.max(dp[n][m], dp[k][m - 1] +  sumarr[n] - sumarr[k + 1]);
                    System.out.println("dp["+n+"]["+m+"] " + dp[n][m] + "   "+k );
                }
            }
        }

        for (int n = 0; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                System.out.print(dp[n][m] + " ");;
            }
            System.out.println();
        }

        System.out.println(dp[N][M]);
    }


}