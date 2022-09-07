package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class BFS_17144 {
//    미세먼지가 확산된다.
//    확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
//    (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
//    인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
//    확산되는 양은 Ar,c/5이고 소수점은 버린다.
//     (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.

//    공기청정기가 작동한다.
//    공기청정기에서는 바람이 나온다.
//    위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
//    바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
//    공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.

    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int R;
    static int C;
    static int T;
    static int [][] map;
    static Point point1;
    static Point point2;
    static Queue<Point> que = new LinkedList<>(); // 먼지가 있는 위치가 저장됨
    static Queue<Dusts> dList = new LinkedList<>(); // 확산된 먼지를 더하기 위함, 위치와 더할 먼지의 양이 저장된다.


    static class Point{
        int x;
        int y;

         Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static class Dusts{
        int y,x,dust;

        Dusts(int y, int x, int dust){
            this.y = y;
            this.x = x;
            this.dust = dust;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        StringTokenizer stt = new StringTokenizer(br.readLine());
        R = func.apply(stt.nextToken());
        C = func.apply(stt.nextToken());
        T = func.apply(stt.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int num = func.apply(st.nextToken());
                map[i][j] = num;
                if(num == -1){
                    if(point1 == null) point1 = new Point(i,j);
                    else point2 = new Point(i,j);
                }
            }
        }

        for (int t = 0; t < T; t++) {
            //미세먼지 위치 파악
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] > 0) {
                        que.offer(new Point(i,j));
                    }
                }
            }
            //미세먼지 확산
            bfs();

            //확산된 미세먼지 계산
            add();

            //공기청정기 가동
            cleaner();
        }
        //남은 미세먼지 합 계산
        total();
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            Point now = que.poll();
            int count = 0;
            if(map[now.y][now.x] < 5) continue;
            int val = map[now.y][now.x] / 5;

            for(int[]d : directions){
                int y = now.y + d[0];
                int x = now.x + d[1];

                if(y>=0 && y<R && x>=0 && x<C){
                    if(map[y][x] == -1) continue;

                    count++;
                    dList.add(new Dusts(y, x, val));
                }
            }
            dList.add(new Dusts(now.y, now.x, -val*count));

        }
    }

    private static void add() {
        while (!dList.isEmpty()){
            Dusts dust = dList.poll();
            map[dust.y][dust.x] += dust.dust;
        }
    }

    private static void cleaner(){
        //반시계 : point1
        //아래로 당기기
        for (int i = point1.y - 1; i > 0; i--) {
            map[i][0] = map[i-1][0];
        }
        //왼쪽으로 당기기
        for (int i = 0; i < C-1; i++) {
            map[0][i] = map[0][i+1];
        }
        //위쪽으로 당기기
        for (int i = 0; i < point1.y; i++) {
            map[i][C-1] = map[i+1][C-1];
        }
        //오른쪽으로 당기기
        for (int i = C-1; i > 0; i--) {
            map[point1.y][i] = map[point1.y][i-1];
        }
        map[point1.y][1] = 0;
        map[point1.y][0] = -1;

        //시계방향 : point2
        //위로 당기기
        for (int i = point1.y+1; i < R-1; i++) {
            map[i][0] = map[i+1][0];
        }
        //완쪽으로 당기기
        for (int i = 0; i < C-1; i++) {
            map[R-1][i] = map[R-1][i+1];
        }
        //아래로 당기기
        for (int i = R-1; i > point2.y; i--) {
            map[i][C-1] = map[i-1][C-1];
        }
        //오른쪽으로 당기기
        for (int i = C-1; i > 0 ; i--) {
            map[point2.y][i] = map[point2.y][i-1];
        }
        map[point2.y][1] = 0;
        map[point2.y][0] = -1;

    }

    private static void total(){
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1) continue;
                result += map[i][j];
            }
        }
        System.out.println("~~~~~~~" + result);
    }
}
