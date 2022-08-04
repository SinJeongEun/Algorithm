package com.example.baekjoon.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Sudoku2580 {
    //백트래킹 2580번 문제
    //스도쿠 문제
    // 0이 적혀있는 칸은 빈칸이고 해당 칸에 숫자를 채워야 된다!!!
    static int[][] board = new int[9][9];
    static List<ZeroState> emptySpot = new LinkedList<>();

    static class ZeroState {
        int x, y;

        public ZeroState(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> fun = Integer::parseInt;

        //스도쿠판 입력 받기
        for (int x = 0; x < 9; x++) {
            String[] tmp = br.readLine().split(" ");
            for (int y = 0; y < 9; y++) {
                board[x][y] = fun.apply(tmp[y]);
                //0인 부분 저장해두기
                if (fun.apply(tmp[y]) == 0) emptySpot.add(new ZeroState(x, y));
            }
        }
        fillSudoku(0);
    }

    public static void fillSudoku(int dept) {
        //종료 조건
        if (dept == emptySpot.size()) {
            //출력하기
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            //종료
            System.exit(0);
        }

        int nowX = emptySpot.get(dept).x;
        int nowY = emptySpot.get(dept).y;

        for (int num = 1; num <= 9; num++) {
            if (check(nowX, nowY, num)) {
                board[nowX][nowY] = num;
                fillSudoku(dept + 1);
                board[nowX][nowY] = 0; //다시 0으로 만들어서 새롭게 스도쿠를 채운다.
            }
        }

    }

    public static boolean check(int x, int y, int num) { //x는 행 , y 는 열
        //가로줄 검사
        for (int a = 0; a < 9; a++) {
            if (board[x][a] == num) return false;
        }

        //세로줄 검사
        for (int b = 0; b < 9; b++) {
            if (board[b][y] == num) return false;
        }

        //3*3 검사
        int startX = x / 3 * 3; //반복문을 실행할 시작 위치를 구한다.
        int startY = y / 3 * 3;

        for (int n = startX; n < startX + 3; n++) {
            for (int m = startY; m < startY + 3; m++) {
                if (board[n][m] == num) return false;
            }
        }

        return true;
    }
}
