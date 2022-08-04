package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_2178 {
    //미로 탐색
    static int height;
    static int width;
    static int[][] miro;
    static boolean[][] visited;
    static Queue<int[]> que = new LinkedList<>();
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        height = Integer.parseInt(s[0]);
        width = Integer.parseInt(s[1]);
        miro = new int[height][width];
        visited = new boolean[height][width];

        for (int x = 0; x < height; x++) {
            String[] line = br.readLine().split("");
            for (int y = 0; y < width; y++) {
                miro[x][y] = Integer.parseInt(String.valueOf(line[y]));
            }
        }

        que.offer(new int[]{0, 0});
        visited[0][0] = true;
        bfs();

//        for(int x=0;x<height;x++){
//            for (int y=0;y<width;y++){
//                System.out.print(miro[x][y]);
//            }
//            System.out.println();
//        }
        System.out.println(miro[height - 1][width - 1]);


    }

    public static void bfs() {
        while (!que.isEmpty()) {
            int now[] = que.poll();

            for (int d = 0; d < 4; d++) {
                int a = now[0] + directions[d][0];
                int b = now[1] + directions[d][1];

                if (a >= 0 && b >= 0 && a < height && b < width && miro[a][b] == 1 && !visited[a][b]) {
                    miro[a][b] = miro[now[0]][now[1]] + 1;
                    que.offer(new int[]{a, b});
                    visited[a][b] = true;
                }
            }
        }
    }
}
