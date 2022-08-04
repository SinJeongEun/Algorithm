package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Lab14502 {
    //백준 14502번 그래프 탐색
    //연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며,
    // 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
    //일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다.
    // 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다. !!
    // 0 : 빈칸 , 1 : 벽 , 2: 바이러스

    // 1. 벽을 새운다.
    // 2. 바이러스를 퍼뜨린다.
    // 3. 안전영역을 구하고, 최대인 경우를 출력한다.
    static int N; //세로
    static int M; //가로
    static int[][] map;
    static HashSet<Integer> result = new HashSet<>();
    static Queue<int[]> virus = new LinkedList<>();
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        String[] s = br.readLine().split(" ");
        N = func.apply(s[0]);
        M = func.apply(s[1]);
        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            String[] tmp = br.readLine().split(" ");
            for (int m = 0; m < M; m++) {
                map[n][m] = func.apply(tmp[m]);
            }
        }

        bfs(0);
        int len = result.size();
        List<Integer> r = new ArrayList<>();
        result.forEach(a -> r.add(a));
        Collections.sort(r);
        System.out.println(r.get(len - 1));

    }

    //빈칸에 총 3개의 벽을 세운다.
    public static void bfs(int d) {
        if (d == 3) {
            spreadVirus();
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        bfs(d + 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    //바이러스를 퍼트린다.
    public static void spreadVirus() {
        int[][] cpymap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cpymap[i][j] = map[i][j];
                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
//                        System.out.println(i + "  " + j);
                }
            }
        }

        while (!virus.isEmpty()) {
            int[] vi = virus.poll();
            for (int[] direc : directions) {
                int i = vi[0] + direc[0];
                int j = vi[1] + direc[1];
                if (i >= 0 && j >= 0 && i < N && j < M && cpymap[i][j] == 0) {
                    cpymap[i][j] = 2;
                    virus.offer(new int[]{i, j});
                }
            }
        }
        safeArea(cpymap);
    }

    //안전지대 영역을 계산한다.
    public static void safeArea(int[][] cpymap) {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cpymap[i][j] == 0) safe++;
            }
        }
        result.add(safe);
//        System.out.println(safe);
    }
}
