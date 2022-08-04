package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_DFS2667 {
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static List<Integer> groups = new ArrayList<>();
    static boolean[][] visited;
    static int n = 0;
    static Queue<int[]> que = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    que.offer(new int[]{i, j});
                    visited[i][j] = true;
                    find(map);
                }

            }

        }
        if (groups.size() > 0) {
            Collections.sort(groups);
            System.out.println(groups.size());
            for (int c : groups) System.out.println(c);
        } else System.out.println(0);
    }

    public static void find(int[][] map) {

        while (!que.isEmpty()) {
            int point[] = que.poll();
            count++;
            for (int[] dir : direction) {
                int a = point[0] + dir[0];
                int b = point[1] + dir[1];
                if (a >= 0 && b >= 0 && a < n && b < n && map[a][b] == 1 && !visited[a][b]) {
                    que.offer(new int[]{a, b});
                    visited[a][b] = true;
                }
            }
        }
        groups.add(count);
        count = 0; //�ʱ�ȭ
    }
}
