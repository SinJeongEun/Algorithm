package com.example.baekjoon.baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class WizardShark_21610 {
    static int[][] directions = { {0,-1}, {-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1} };
    static int[][] diagonal = { {-1,-1}, {-1,1}, {1,-1}, {1,1} };
    static int board[][];
    static boolean visited[][];
    static  int N;
    static Queue<Cloud> que = new LinkedList<>();
    static List<Cloud> list = new ArrayList<>();
    static List<Cloud> magic = new ArrayList<>();
    static class Cloud {
        int y, x;

        Cloud(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = func.apply(st.nextToken());
        int M = func.apply(st.nextToken()); // 이동 횟수
        board = new int[N][N];
        visited = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                board[y][x] = func.apply(st.nextToken());
            }

        }
        // 비바라기 시전 시 비구름 생성됨
        list.add(new Cloud(N-1,0));
        list.add(new Cloud(N-1,1));
        list.add(new Cloud(N-2,0));
        list.add(new Cloud(N-2,1));

        // 이동하기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int direct = func.apply(st.nextToken());
            int steps = func.apply(st.nextToken());
            // 초기화
            for (int i = 0; i < N; i++) {
                Arrays.fill(visited[i], false);
            }

            // 구름 이동
            moveCloud(direct - 1, steps);
            // 뮬의 양 증가 , 구름 사라짐
            addWater();
            // 물복사 버그 마법, 대각선 방향으로 물이있는 바구니 수만큼 물의 양 증가
            copyMagic();
            // 위에서 구름이 사라진 칸을 제외하고 ,물의 양이 2 이상이면 구름이 생기고, 물의 양이 2 줄어든다.
            makeClouds();
        }
        // 모든 칸의 물의 양의 합 구하기
        printBoard();
    }

    private static void moveCloud(int d, int step) {
        for(Cloud cl : list){
            que.add(new Cloud((N + cl.y + directions[d][0] * (step % N)) % N, (N + cl.x + directions[d][1] * (step % N)) % N ));
        }
    }

    private static void addWater() {
        while (!que.isEmpty()) {
            Cloud cloud = que.poll();
            board[cloud.y][cloud.x] += 1;

            visited[cloud.y][cloud.x] = true;
            magic.add(new Cloud(cloud.y, cloud.x));
        }
    }

    private static void copyMagic() {
        for(Cloud cl : magic) {
            int count = 0;
            for(int[]dia : diagonal) {
                int y = cl.y + dia[0];
                int x = cl.x + dia[1];
                if(y >= 0 && y < N && x >= 0 && x < N && board[y][x] > 0) {
                    count++;
                }
            }
            board[cl.y][cl.x] += count; // 대각선의 물이 있는 바구니 수만큼 물의 양 증가
        }
        magic.clear();
    }

    private static void makeClouds() {
        list.clear();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if(!visited[y][x] && board[y][x] >= 2) {
                    list.add(new Cloud(y, x));
                    board[y][x] -= 2;
                }
            }
        }
    }

    private static void printBoard() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += board[i][j];
            }
        }
        System.out.println(sum);
    }

}
