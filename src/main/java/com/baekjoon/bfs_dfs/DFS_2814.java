package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

//swea 2814.최장경로
public class DFS_2814 {
    static Boolean visited[];
    static int map[][];
    static int N;
    static int M;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = func.apply(st.nextToken()); //  테스트케이스 수
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
             N = func.apply(st.nextToken()); // 정점의 수
             M = func.apply(st.nextToken()); // 간선의 수

            // 배열
            visited = new Boolean[N+1];
            map = new int[N+1][N+1];
            Arrays.fill(visited,false);
            for (int j = 1; j < M+1; j++) {
                st = new StringTokenizer(br.readLine());
                int n1 = func.apply(st.nextToken());
                int n2 = func.apply(st.nextToken());
                map[n1][n2] = 1;
                map[n2][n1] = 1;
            }

            for (int v = 1; v < N+1; v++) {
                dfs(1,v);
                visited[v] = false;
            }
            System.out.println("#"+ (i+1) + " " + max);
            max = 0;
        }
    }

    public static void dfs(int dept, int v) {
        visited[v] = true;
        for (int i = 1; i < N+1; i++) {
            if(map[v][i] == 1 && !visited[i]) {
                dfs(dept+1,i);
                visited[i] = false;
            }
        }
        max = Math.max(dept, max);
    }
}
