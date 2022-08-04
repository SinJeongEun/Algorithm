package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_7576 {
    static int height;
    static int width;
    static int[][] box;
    static int empty = 0;
    static int ripen = 0;
    static int day = 0;
    static int total = 0;
    static Queue<int[]> que = new LinkedList<>();
    static List<int[]> wait = new ArrayList<>();
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        width = Integer.parseInt(s[0]);
        height = Integer.parseInt(s[1]);
        box = new int[height][width];
        total = width * height;

        for (int h = 0; h < height; h++) {
            String[] t = br.readLine().split(" ");
            for (int w = 0; w < width; w++) {
                box[h][w] = Integer.parseInt(t[w]);
            }
        }

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (box[h][w] == -1) empty++;
                if (box[h][w] == 1) {
                    que.offer(new int[]{h, w});
                }
            }
        }
        bfs();

        if (total - empty != ripen) System.out.println(-1);
        else System.out.println(day);
    }

    public static void bfs() {
        while (!que.isEmpty()) {
            ripen++;
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int a = now[0] + directions[i][0];
                int b = now[1] + directions[i][1];

                if (a >= 0 && b >= 0 && a < height && b < width && box[a][b] == 0) {
                    box[a][b]++;
                    wait.add(new int[]{a, b});
                }
            }
        }
        nexDay();
    }

    public static void nexDay() {
        while (wait.size() > 0) {
            day++;
            for (int[] w : wait) {
                que.offer(new int[]{w[0], w[1]});
            }
            wait.clear();  //List는  for문을 돌 때 수정이 불가능하므로 마지막에 초기화 함
            bfs();
        }
    }
}
