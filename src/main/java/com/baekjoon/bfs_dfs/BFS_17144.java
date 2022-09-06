package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class BFS_17144 {
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int R;
    static int C;
    static int T;
    static List<Integer>[][] map;
    static Point point1;
    static Point point2;
    static Queue<Point> que = new LinkedList<>();


    static class Point{
        int x;
        int y;

         Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        StringTokenizer stt = new StringTokenizer(br.readLine());
        R = func.apply(stt.nextToken());
        C = func.apply(stt.nextToken());
        T = func.apply(stt.nextToken());
        map = new List[R][C];

        for (int i = 0; i < R; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int num = func.apply(st.nextToken());
                List<Integer> tmp = new ArrayList<>();
                tmp.add(num);
                map[i][j] = tmp;
                if(num > 0) que.offer(new Point(i,j));
                if(num == -1){
                    if(point1 == null) point1 = new Point(i,j);
                    if(point2 == null) point2 = new Point(i,j);
                }
            }
        }
        //미세먼지 확산
        bfs();

        //확산된 미세먼지 계산
        add();

        //공기청정기 가동

        for (int a = 0; a < R; a++) {
            for (int b = 0; b < C; b++) {
                System.out.print(map[a][b].get(0) + " ");
            }
            System.out.println();
        }
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Point now = que.poll();
            System.out.println(now.y);

            for(int[]d : directions){
                int y = now.y + d[0];
                int x = now.x + d[1];

                if(y>=0 && y<R && x>=0 && x<C && (map[y][x].get(0) != -1)){
                    map[y][x].add(map[now.y][now.x].get(0) / 5);
                }
            }

        }
    }

    private static void add() {
        int sum;
        for (int a = 0; a < R; a++) {
            for (int b = 0; b < C; b++) {
                sum = 0;
                for(int i : map[a][b]){
                    sum += i;
                }
                map[a][b].add(0, sum);
            }
        }
    }
}
