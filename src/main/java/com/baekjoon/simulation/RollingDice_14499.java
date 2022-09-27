package com.example.baekjoon.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class RollingDice_14499 {
    static int N; // 세로
    static int M; // 가로
    static int K; // 명령 갯수
    static int board[][];
    static Dice dice;
    static int x, y; // 현재 주사위가 있는 보드의 좌표
    static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; //1:동 2:서 3:북 4:남
    static class Dice {
        int up, left, top, right
        ,down, botton;

        Dice(int u, int l, int t, int r, int d, int b) {
            this.up = u;
            this.left = l;
            this.top = t;
            this.right = r;
            this.down = d;
            this.botton = b;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer :: parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = func.apply(st.nextToken());
        M = func.apply(st.nextToken());
        int y = func.apply(st.nextToken());
        int x = func.apply(st.nextToken());
        K = func.apply(st.nextToken());
        dice = new Dice(0, 0, 0, 0, 0, 0);

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = func.apply(st.nextToken());
            }
        }

        // 명령들
        st = new StringTokenizer(br.readLine());
        int command = 0;
        for (int c = 0; c < K; c++) {
            command = func.apply(st.nextToken()) - 1;

            //보드 이동 시 나가면 좌표 이동 x , 출력 x
            int ny = y + directions[command][0];
            int nx = x + directions[command][1];
            if(ny < 0 || ny >= N || nx < 0 || nx >= M || command < 0 || command > 3 ){
                continue;
            }
            y += directions[command][0];
            x += directions[command][1];

            int u = dice.up;
            int l = dice.left;
            int t = dice.top;
            int r = dice.right;
            int d = dice.down;
            int b = dice.botton;

           switch (command){
                case 0: // 동
                    dice.right = b;
                    dice.top = r;
                    dice.left = t;
                    dice.botton = l;
                    break;

                case 1: // 서
                    dice.left = b;
                    dice.top = l;
                    dice.right = t;
                    dice.botton = r;
                    break;

                case 2: //북
                    dice.up = b;
                    dice.top = u;
                    dice.botton = d;
                    dice.down = t;
                    break;

                case 3: // 남
                    dice.up = t;
                    dice.top = d;
                    dice.down = b;
                    dice.botton = u;
                    break;
            }

            if(board[y][x] == 0) board[y][x] = dice.botton;
            else {
                dice.botton = board[y][x];
                board[y][x] = 0;
            }
            System.out.println(dice.top);
        }

    }
}
