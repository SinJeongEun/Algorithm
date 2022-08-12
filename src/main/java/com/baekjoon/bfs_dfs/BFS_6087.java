package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BFS_6087 {
    //레이저 통신
    //최단거리 이므로 bfs 사용
    //레이저 통신에서 거울의 갯수가 최소여야 된다. 즉 경로에서 꺽이는 횟수가 최소여야됨
    // 이를 위해 방문했던 지점도, 다시 방문하여 거울 갯수를 확인하고 최소인 경우로 바꿔줘야 된다.
    static int W;
    static int H;
    static char map[][];
    static int mirrors [][]; // 각 지점까지의 거울의 개수 저장하는 배열
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Point startPoint, endPoint;
    static int min = Integer.MAX_VALUE;
    static class Point {
        int x;
        int y;
        int dir; // 레이저의 현재 방향 1, 2, 3 ,4 : 동 서 남 북 / 기본은 -1 로 세팅
        int mirror; // 현재 지점까지 설치된 거울의 개수

        Point(int y, int x, int dir, int mirror) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = func.apply(st.nextToken());
        H = func.apply(st.nextToken());
        map = new char[H][W];
        mirrors = new int[H][W];

        for (int y = 0; y < H; y++) {
            String str = br.readLine();
            for (int x = 0; x < W; x++) {
                map[y][x] = str.charAt(x);

                if(map[y][x] == 'C') {
                    if(startPoint == null) startPoint = new Point(y, x, -1, 0);
                    else endPoint = new Point(y, x, -1, 0);
                }
            }
        }

        bfs();
        System.out.println(min);

    }

    public static void bfs() {
        Queue<Point> que = new LinkedList<>();
        que.offer(startPoint);
        mirrors[startPoint.y][startPoint.x] = 1;

        while (!que.isEmpty()){
            Point now = que.poll();
            int nx = now.x;
            int ny = now.y;
            int nd = now.dir;
            int nm = now.mirror;

            if(ny == endPoint.y && nx == endPoint.x){
                min = Math.min(min, nm);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int y = ny + directions[i][0];
                int x = nx + directions[i][1];
                int direction = i;

                if(y >= 0 && y < H && x >= 0 && x < W && map[y][x] != '*'){
                    int countMirror = nm;
                    if(nd != -1 && nd != direction){
                        // 방향이 현재 진행하는 방향과 다르므로 꺽였다는 뜻이다. -> 거울 추가 조건
                        ++countMirror;
                    }

                    if(mirrors[y][x] == 0 || mirrors[y][x] >= countMirror) {
                        // 방문하지 않은 경우 이거나
                        // 이전 탐색보다 더 적은 개수의 거울을 사용한 경우, 값을 변경해준다.
                        mirrors[y][x] = countMirror;
                        que.offer(new Point(y, x, direction, countMirror));
                    }
                }
            }
        }
    }
}
