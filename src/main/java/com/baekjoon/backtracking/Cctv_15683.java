package com.example.baekjoon.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Cctv_15683 {
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
        int[][] board = new int[N][M];

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
        backTrack(board, 0);
//        if(cctvList.size() == 0) min = 0;
        System.out.println(min);

    }

    private static void backTrack(int[][]arr, int dept) {
        if(dept == limit) {
            // 사각지대 개수 구하기
            solution(arr);
        }
        else {
            Point now = cctvList.get(dept);
            int tmp[][];
                switch (now.num) {
                    case 1 :
                        tmp = deepCopy(arr);
                        checkDown(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        // clone 은 깊은 복사가 아니다 깊은 복사하는 함수를 구현해야한다!!!!!!
                        tmp = deepCopy(arr);
                        checkRight(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        tmp = deepCopy(arr);
                        checkUp(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        tmp = deepCopy(arr);
                        checkLeft(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);
                        break;

                    case 2:
                        tmp = deepCopy(arr);
                        checkDown(tmp, now.y, now.x);
                        checkUp(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        tmp = deepCopy(arr);
                        checkRight(tmp, now.y, now.x);
                        checkLeft(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);
                        break;

                    case 3:
                        tmp = deepCopy(arr);
                        checkDown(tmp, now.y, now.x);
                        checkRight(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        tmp = deepCopy(arr);
                        checkDown(tmp, now.y, now.x);
                        checkLeft(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        tmp = deepCopy(arr);
                        checkLeft(tmp, now.y, now.x);
                        checkUp(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        tmp = deepCopy(arr);
                        checkUp(tmp, now.y, now.x);
                        checkRight(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);
                        break;

                    case 4:
                        tmp = deepCopy(arr);
                        checkLeft(tmp, now.y, now.x);
                        checkRight(tmp, now.y, now.x);
                        checkUp(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        tmp = deepCopy(arr);
                        checkUp(tmp, now.y, now.x);
                        checkDown(tmp, now.y, now.x);
                        checkLeft(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        tmp = deepCopy(arr);
                        checkLeft(tmp, now.y, now.x);
                        checkRight(tmp, now.y, now.x);
                        checkDown(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);

                        tmp = deepCopy(arr);
                        checkUp(tmp, now.y, now.x);
                        checkDown(tmp, now.y, now.x);
                        checkRight(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);
                        break;

                    case 5:
                        tmp= deepCopy(arr);
                        checkDown(tmp, now.y, now.x);
                        checkRight(tmp, now.y, now.x);
                        checkUp(tmp, now.y, now.x);
                        checkLeft(tmp, now.y, now.x);
                        backTrack(tmp, dept + 1);
                        break;
                    default: break;
                }
        }

    }

    private static void solution(int[][] arr) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) result++;
//                System.out.print(arr[i][j] + " ");
            }
//            System.out.println();
        }
//        System.out.println();
        min = Math.min(min, result);
    }

    private static int[][] deepCopy(int [][] arr) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }

    private static void checkDown(int[][] arr, int y, int x){
        int ny = y + 1;
        while (ny < N && (arr[ny][x] >= -1 && arr[ny][x] < 6)) {
            arr[ny][x] = -1;
            ny++;
        }
    }
    private static void checkUp(int[][] arr, int y, int x){
        int ny = y - 1;
        while (ny >= 0 && (arr[ny][x] >= -1 && arr[ny][x] < 6)) {
            arr[ny][x] = -1;
            ny--;
        }
    }
    private static void checkLeft(int[][] arr, int y, int x){
        int nx = x - 1;
        while (nx >= 0 && arr[y][nx] >= -1 && arr[y][nx] < 6) {
            arr[y][nx] = -1;
            nx--;
        }
    }
    private static void checkRight(int[][] arr, int y, int x){
        int nx = x + 1;
        while (nx < M  && arr[y][nx] >= -1 && arr[y][nx] < 6) {
            arr[y][nx] = -1;
            nx++;
        }
    }

}
