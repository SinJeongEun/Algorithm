package com.example.baekjoon.baekjoon.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class GetItem_programmers_87694 {
    public static void main(String[] args) {
        int[][]rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        solution(rectangle, 1, 3, 7, 8);
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int[][] map = new int[20][20];

        for(int[]rec : rectangle) {
            int a = rec[0] * 2;
            int b = rec[1] * 2;
            int c = rec[2] * 2;
            int d = rec[3] * 2;

            for(int i = a;i <= c; i++) {
                for(int j = b;j <= d; j++) {
                    if(map[i][j] != 0) {
                        map[i][j] = 1;
                        continue;
                    }
                    if(i == a || i == c || j == b || j == d) map[i][j] = 2; // 테두리
                    else map[i][j] = 1;  // 내부
                }
            }

        }
        answer = bfs(map, characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return answer/2;
    }

    public static int bfs(int[][] map, int charX, int charY, int itemX, int itemY) {
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int min = Integer.MAX_VALUE;
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(charX, charY, 0));
        map[charX][charY] = 2;

        while (!que.isEmpty()) {
            Point now = que.poll();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;

            System.out.println(now);

            if(x == itemX && y == itemY) {
                min = Math.min(min, cnt);
                continue;
            }

            for(int[] dir : directions) {
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                if(x1 < 2 || y1 < 2 || x1 > 100 || y1 > 100) continue;
                if(map[x1][y1] != 2) continue;

                map[x1][y1] = 3; // 지나감
                que.offer(new Point(x1, y1, cnt+1));
            }
        }
        return min;
    }

    public static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.cnt = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
