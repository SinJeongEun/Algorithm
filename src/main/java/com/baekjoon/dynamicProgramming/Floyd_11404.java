package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Floyd_11404 { // Floyd Warshall 알고리즘
    static int lnf = 100000 * 100 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st;

        int N = func.apply(br.readLine());
        int M = func.apply(br.readLine());
        int dp[][] = new int[N][N];

        //초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) dp[i][j] = 0;
                else dp[i][j] = lnf;
            }
        }

        // 값 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = func.apply(st.nextToken()); // 시작 노드
            int e = func.apply(st.nextToken()); // 도착 노드
            int v = func.apply(st.nextToken()); // 값
            dp[s-1][e-1] = Math.min(dp[s-1][e-1], v);
        }

        //각 정점 에서 정점의 최소 비용 구하기 : 플로이드 와샬 알고리즘
        for (int m = 0; m < N; m++) { // 중간에 거쳐가는 지점
            for (int s = 0; s < N; s++) { // 출발 지점
                for (int e = 0; e < N; e++) { // 도착 지점
                    dp[s][e] = Math.min(dp[s][m] + dp[m][e], dp[s][e]);
                }
            }
        }

        for(int[]arr : dp) {
            for(int v : arr) {
                if( v >= lnf) v = 0;
                System.out.print(v + " ");
            }
            System.out.println();
        }

    }
}
