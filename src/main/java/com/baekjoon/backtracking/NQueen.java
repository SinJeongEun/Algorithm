package com.example.baekjoon.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
// 9663번 문제
// 퀸은 상,하,좌,우,대각선을 거리제한 없이 이동 가능하다.
// 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

    static int N;
    static int total = 0;
    static int[] queenIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queenIndex = new int[N];
//        Arrays.fill(queenIndex,-1);
        //우선 쳐음 위치부터 마지막 위치까지 하나의 Queen을 배치해본다.
        backtracking(0);
        System.out.println("!!!  " + total);
    }

    public static void backtracking(int nowX) {
        if (nowX == N) {
            total++;
        } else {
            for (int y = 0; y < N; y++) {
                queenIndex[nowX] = y; //x는 행 , y는 열
                if (isPossible(nowX)) {
                    backtracking(nowX + 1); //다른 행으로 넘어가므로 열,대각선만 신경쓰면 된다.
                }
            }
        }
    }

    public static boolean isPossible(int row) {
        for (int x = 0; x < row; x++) {
            //우선 다른 행에 위차한다는 것은 보장
            //퀸과 대각선에 위치하면 return  false

            //같은 열에 위치한 경우
            if (queenIndex[x] == queenIndex[row]) return false;
            //대각선에 위치하는 경우
            if (Math.abs(x - row) == Math.abs(queenIndex[x] - queenIndex[row])) {
                return false;
            }
        }
        return true;
    }


}
