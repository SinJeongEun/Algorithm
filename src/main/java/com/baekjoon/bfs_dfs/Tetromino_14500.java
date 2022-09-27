package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Tetromino_14500 {
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int board[][];
    static boolean visited[][];
    static final int NUM = 4;
    static int result = 0;
    static int r;
    static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = func.apply(st.nextToken());
        c = func.apply(st.nextToken());
        board = new int[r][c];
        visited = new boolean[r][c];
        for (int y = 0; y < r; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < c; x++) {
                board[y][x] = func.apply(st.nextToken());
            }
        }
        
        //각 지점마다 dfs 실행, 다른 모양으로도 해야하므로 다시 재방문 가능하도록 처리 필요
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                visited[i][j] = true;
                dfs(i,j,board[i][j],1);
                visited[i][j] = false;
            }
        }
        System.out.println(result);

    }

    public static void dfs(int y, int x, int sum, int dept) {
        if(dept == NUM) {
            result = Math.max(sum, result);
            return;
        }

        for(int[]d : directions) {
            int ny = y + d[0];
            int nx = x + d[1];

            if(ny >= 0 && ny < r && nx >= 0 && nx < c && !visited[ny][nx]) {
                // ㅗ, ㅜ, ㅓ, ㅏ .. 의 테트로미노 만들기
                // 3번쨰 탐색을 할 때 2번째 칸에서 다시 한번 탐색하도록 하면 위의 테트로미노 모양을 만들 수 있다.
                // ny , nx 는 방문하였고 다시 2번째를 방문하는 것이다. (3번을 만들고 다시 2번에서 상하좌우로 탐색하도록)
                if(dept == 2){
                    visited[ny][nx] = true;
                    dfs(y, x, sum + board[ny][nx], dept + 1);
                    visited[ny][nx] = false;
                }

                // 일반 테트로미노 만들기
                visited[ny][nx] = true;
                dfs(ny, nx, sum + board[ny][nx], dept + 1);
                visited[ny][nx] = false;
            }
        }
    }
}
