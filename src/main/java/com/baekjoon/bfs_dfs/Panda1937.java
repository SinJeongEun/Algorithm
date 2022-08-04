package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Panda1937 {
    //백준 1937번
    //첫째 줄에 대나무 숲의 크기 n(1 ≤ n ≤ 500)이 주어진다. 그리고 둘째 줄부터 n+1번째 줄까지 대나무 숲의 정보가 주어진다.
    //판다는 상 하 좌 우 이동 가능하며, 현재 칸의 대나무 수 보다 더 큰 칸으로만 이동 가능하다.
    //최대로 이동 가능한 칸 수를 구하여라.

    static int N;
    static int[][] map;
    static int[][] stored; //해당 칸에서 이동 가능한 칸을 저장해두어 시간 절약한다.
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        N = func.apply(br.readLine());
        map = new int[N][N];
        stored = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = func.apply(tmp[j]);
            }
        }

        //각 좌표를 시작으로 탐색을 시작한다.
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int r = bfs(y, x, 1);
                answers.add(r);
            }
        }
        Collections.sort(answers);
        System.out.println(answers.get(answers.size() - 1));
    }

    static int bfs(int y, int x, int count) {
        //방문한 경우 : 정보가 저장되어 있음
        if (stored[y][x] > 0) {
            return stored[y][x];
        } else {
            for (int dir[] : directions) {
                int a = y + dir[0];
                int b = x + dir[1];
                if (a >= 0 && b >= 0 && a < N && b < N && map[y][x] < map[a][b]) {
                    int t = bfs(a, b, 1);
                    count = Math.max(t + 1, count);
                    stored[y][x] = count;
                }
            }
        }
        return count;

    }

}
