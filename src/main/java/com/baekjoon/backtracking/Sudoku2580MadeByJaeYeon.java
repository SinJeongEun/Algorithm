package com.example.baekjoon.baekjoon.backtracking;

import java.util.*;
import java.io.*;
import java.util.function.Function;

public class Sudoku2580MadeByJaeYeon {
    static int N = 9;
    static int[][] map;
    static List<Point> zeros = new LinkedList<>();

    static class Point {
        int y;
        int x;

        Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    static void dfs(int depth) {
        // 3 개 있으면 list.size == 3,
        // 3, depth = 2
        if (depth == zeros.size()) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        int y = zeros.get(depth).y;
        int x = zeros.get(depth).x; // 현재 Zero 의 위치
        int[] number = findNumber(y, x);

        for (int i = 0; i < number.length; i++) {
            if (number[i] != 0) {
                map[y][x] = number[i];
                dfs(depth + 1);
                map[y][x] = 0;
            }
        }
    }

    static int[] findNumber(int y, int x) {
        // 들어갈 수 없는 수이면 0으로 바꿔준다.
        int[] res = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < 9; i++) {
            if (i != x && map[y][i] != 0) { // 가로축을 검사
                res[map[y][i]] = 0;
            }

            if (i != y && map[i][x] != 0) { // 세로축을 검사
                res[map[i][x]] = 0;
            }
        }

        int ny = y / 3; // 0, 1, 2
        int nx = x / 3; // 0, 1, 2

        ny *= 3;
        nx *= 3;

        for (int i = ny; i < ny + 3; i++) {
            for (int j = nx; j < nx + 3; j++) {
                if ((i != y && i != x) && map[i][j] != 0) {
                    res[map[i][j]] = 0;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> fun = Integer::parseInt;

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = fun.apply(input[j]);
                if (map[i][j] == 0) {
                    zeros.add(new Point(i, j));
                }
            }
        }

        dfs(0);
    }
}
