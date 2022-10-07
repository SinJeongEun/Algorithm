package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Exercise_1956 { // Floyd Warshall 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = func.apply(st.nextToken());
        int E = func.apply(st.nextToken());
        int[][] dp = new int[V][V];
        int lnf = 10000 * 400 + 1;

        //초기화
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dp[i][j] = lnf;
            }
        }

        // 값 입력 받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = func.apply(st.nextToken()) - 1;
            int b = func.apply(st.nextToken()) - 1;
            int v = func.apply(st.nextToken());
            // a, b 쌍이 같은 도로가 여러분 주어지지 않는다고 명시되어 있으므로 바로 값을 저장한다.
            dp[a][b] = v;
        }

        // 모든 정점을 거치며 최소 비용 구하기
        for (int m = 0; m < V; m++) {
            for (int s = 0; s < V; s++) {
                for (int e = 0; e < V; e++) {
                    dp[s][e] = Math.min(dp[s][m] + dp[m][e], dp[s][e]);
                }
            }
        }

        // 단 출발 지점으로 다시 돌아온 경우들 중에서의 최솟값을 구해야 되므로
        // dp[a][a] 값들만 비교하면 된다.
        int min = Integer.MAX_VALUE;
        for (int a = 0; a < V; a++) {
            if(dp[a][a] >= lnf || dp[a][a] == 0) continue;
            min = Math.min(dp[a][a] , min);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
