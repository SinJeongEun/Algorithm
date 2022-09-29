package com.example.baekjoon.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Cctv_15683 {
    // 순열을 사용하여 풀면 된다.
//    static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상 우 하 좌
    static int[][] board;
    static List<Point> cctvList = new ArrayList<>();
    static int N;
    static int M;
    static int limit;
    static int min = Integer.MAX_VALUE;
    static class Point {
        int num, y, x;

        Point(int n, int y, int x) {
            this.num = n;
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = func.apply(st.nextToken());
        M = func.apply(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = func.apply(st.nextToken());
                if(board[i][j] != 0 &&  board[i][j] != 6){
                    cctvList.add(new Point(board[i][j], i, j));
                }
            }
        }
        limit = cctvList.size();
        backTrack(board, 1);
        System.out.println(min);

    }

    private static void backTrack(int[][]arr, int dept) {
        if(dept == limit) {
            // 사각지대 개수 구하기
            solution(arr);
        }
        else {
            int tmp[][];
            for (int num = 0; num < limit; num++) {
                Point now = cctvList.get(dept - 1);
                if (now.num == 1){
                    tmp = arr.clone();
                    checkDown(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkRight(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkUp(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkLeft(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);
                }
               else if (now.num == 2){
                    tmp = arr.clone();
                    checkDown(tmp, now.y, now.x);
                    checkUp(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkRight(tmp, now.y, now.x);
                    checkLeft(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);


                }
                else if (now.num == 3){
                    tmp = arr.clone();
                    checkDown(tmp, now.y, now.x);
                    checkRight(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkDown(tmp, now.y, now.x);
                    checkLeft(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkLeft(tmp, now.y, now.x);
                    checkUp(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkUp(tmp, now.y, now.x);
                    checkRight(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                }
                else if (now.num == 4){
                    tmp = arr.clone();
                    checkLeft(tmp, now.y, now.x);
                    checkRight(tmp, now.y, now.x);
                    checkUp(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkUp(tmp, now.y, now.x);
                    checkDown(tmp, now.y, now.x);
                    checkLeft(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkLeft(tmp, now.y, now.x);
                    checkRight(tmp, now.y, now.x);
                    checkDown(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                    tmp = arr.clone();
                    checkUp(tmp, now.y, now.x);
                    checkDown(tmp, now.y, now.x);
                    checkRight(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);

                }
                else if (now.num == 5){
                    tmp = arr.clone();
                    checkDown(tmp, now.y, now.x);
                    checkRight(tmp, now.y, now.x);
                    checkUp(tmp, now.y, now.x);
                    checkLeft(tmp, now.y, now.x);
                    backTrack(tmp, dept + 1);
                }

            }
        }
    }

    private static void solution(int arr[][]) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) result++;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        min = Math.min(min, result);
    }


    private static void checkDown(int[][] arr, int y, int x){
        int ny = y + 1;
        while (ny < N && arr[ny][x] == 0) {
            arr[ny][x] = -1;
            ny++;
        }
    }
    private static void checkUp(int[][] arr, int y, int x){
        int ny = y - 1;
        while (ny >= 0 && arr[ny][x] == 0) {
            arr[ny][x] = -1;
            ny--;
        }
    }
    private static void checkLeft(int[][] arr, int y, int x){
        int nx = x - 1;
        while (nx >= 0 && arr[y][nx] == 0) {
            arr[y][nx] = -1;
            nx--;
        }
    }
    private static void checkRight(int[][] arr, int y, int x){
        int nx = x + 1;
        while (nx < M  && arr[y][nx] == 0) {
            arr[y][nx] = -1;
            nx++;
        }
    }

}
