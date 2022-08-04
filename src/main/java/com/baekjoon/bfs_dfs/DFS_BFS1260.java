package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DFS_BFS1260 {
    //���� �湮 Ȯ�� �迭
    static Boolean visited[];
    static StringBuilder sb1 = new StringBuilder();
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] graph;

        String[] a = br.readLine().split(" ");

        n = Integer.parseInt(a[0]);
        m = Integer.parseInt(a[1]);
        int start = Integer.parseInt(a[2]);
        visited = new Boolean[n + 1];
        Arrays.fill(visited, false);

        graph = new int[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            String[] tmp = br.readLine().split(" ");
            int n1 = Integer.parseInt(tmp[0]);
            int n2 = Integer.parseInt(tmp[1]);

            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }

        dfs(graph, visited, start);
        System.out.println(sb1);
        //�ʱ�ȭ
        Arrays.fill(visited, false);
        sb1.delete(0, sb1.length());

        bfs(graph, visited, start);

    }

    public static void dfs(int[][] graph, Boolean visited[], int start) {
        sb1.append(start + " ");
        visited[start] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[start][i] == 1 && visited[i] == false) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void bfs(int[][] graph, Boolean visited[], int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        while (!que.isEmpty()) {

            int now = que.poll();
            visited[now] = true;
            sb1.append(now + " ");
            for (int j = 1; j <= n; j++) {
                if (graph[now][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    que.offer(j);
                }
            }
        }
        System.out.println(sb1);
    }

}