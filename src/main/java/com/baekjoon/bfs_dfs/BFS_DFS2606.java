package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS2606 {
    static int[] visited;
    static int computers;
    static int connects;
    static int[][] graph;
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computers = Integer.parseInt(br.readLine());
        connects = Integer.parseInt(br.readLine());
        visited = new int[computers + 1];
        graph = new int[computers + 1][computers + 1];

        Arrays.fill(visited, 0);

        for (int i = 0; i < connects; i++) {
            String[] tmp = br.readLine().split(" ");
            int n1 = Integer.parseInt(tmp[0]);
            int n2 = Integer.parseInt(tmp[1]);

            graph[n1][n2] = 1;
            graph[n2][n1] = 1;
        }
        bfs(1); //1����ǻ�� ����
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = 1;

        while (!que.isEmpty()) {

            int now = que.poll();
            visited[now] = 1;
            count++;
            for (int i = 1; i <= computers; i++) {
                if (graph[now][i] == 1 && visited[i] == 0) {
                    que.offer(i);
                    visited[i] = 1;
                }
            }
        }
        System.out.println(count - 1);
    }

}
