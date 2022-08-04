package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS_1012 {
    static int testCase;
    static int col;
    static int row;
    static int cabbage = 0;
    static int[][] land;
    static boolean[][] visited;
    static int[][] directions = {{0, 1}, {0, 1}, {1, 0}, {-1, 0}};
    static Stack<int[]> stack = new Stack<>();
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());
        while (testCase > 0) {
            --testCase;
            String[] s = br.readLine().split(" ");
            col = Integer.parseInt(s[0]);
            row = Integer.parseInt(s[1]);
            cabbage = Integer.parseInt(s[2]);
            land = new int[col][row];
            visited = new boolean[col][row];

            int answer = 0;

            String[] tmp = {};
            for (int i = 0; i < cabbage; i++) {
                tmp = br.readLine().split(" ");
                land[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = 1;
            }

            for (int x = 0; x < col; x++) {
                for (int y = 0; y < row; y++) {
                    if (land[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        stack.push(new int[]{x, y});
                        answer++;
                        dfs(x, y);

                    }
                }
            }
            result.add(answer);
        }
        for (int a : result) System.out.println(a);

    }

    public static void dfs(int x, int y) {
        while (!stack.isEmpty()) {
            int[] point = stack.pop();
            for (int d = 0; d < 4; d++) {
                int a = point[0] + directions[d][0];
                int b = point[1] + directions[d][1];

                if (a >= 0 && b >= 0 && a <= col - 1 && b <= row - 1 && land[a][b] == 1 && !visited[a][b]) {
                    stack.push(new int[]{a, b});
                    visited[a][b] = true;
                }
            }
        }
    }
}
