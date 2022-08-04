package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Iceberg2573 {
    //백준 2573번
    //상 하 좌 우의 바다(0)의 개수 만큼 1년마다 빙산의 높이가 줄어든다.
    //빙산이 2개 이상으로 분리되려면 몇년이 걸린지 구한다.
    //분리되지 않고 녹는 경우 0 을 출력한다.

    static int N;
    static int M;
    static int[][] map;
    static int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static Stack<Point> stack = new Stack<>();
    static int years = 0;
    static int[][] melt;
    static Function<String, Integer> func = Integer::parseInt;

    static class Point {
        int row, col;

        Point(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nm[] = br.readLine().split(" ");
        N = func.apply(nm[0]);
        M = func.apply(nm[1]);
        map = new int[N][M];
        melt = new int[N][M];
        for (int y = 0; y < N; y++) {
            String[] tmp = br.readLine().split(" ");
            for (int x = 0; x < M; x++) {
                int num = func.apply(tmp[x]);
                map[y][x] = num;
            }
        }

        while (true) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(melt[i], 0);
            }

            int count2 = 0;
            boolean[][] visited2 = new boolean[N][M];
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    if (map[a][b] > 0 && !visited2[a][b]) {
                        stack.add(new Point(a, b));
                        visited2[a][b] = true;
                        dfs(visited2);
                        count2++;
                    }
                }
            }

            if (count2 >= 2) { //분리된 경우
                break;
            } else if (count2 == 0) { // 애초에 모두 0인 경우, 분리되지 않고 다 녹아버린 경우
                years = 0;
                break;
            }

            //빙산이 있는 경우
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] > 0) {
                        for (int[] d : directions) {
                            int a = y + d[0];
                            int b = x + d[1];
                            if (a >= 0 && b >= 0 && a < N && b < M && map[a][b] <= 0) {
                                //주변에 빙산이 있다켠 해당 빙산의 주변 바다 갯수 ++
                                //1년에 동시에 줄어드므로, 이 반복문이 끝나고 처리해야 함
                                melt[y][x]++;
                            }
                        }
                    }
                }
            }

            //빙산 녹이기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] -= melt[i][j];
                }
            }
            years++;
        }

        System.out.println(years);
    }

    static void dfs(boolean visited[][]) {
        while (!stack.isEmpty()) {
            Point now = stack.pop();
            int y = now.row;
            int x = now.col;

            for (int[] d : directions) {
                int a = y + d[0];
                int b = x + d[1];
                if (a >= 0 && b >= 0 && a < N && b < M && map[a][b] > 0 && !visited[a][b]) {
                    visited[a][b] = true;
                    stack.add(new Point(a, b));
                }
            }
        }
    }

}
