package com.example.baekjoon.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Cogwheel_14891 {
    //  1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
    //  2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
    //  3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
    //  4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
    //  0은 N극 , 1은 S극
    // 1 : 시계 방향 , -1 : 반시계 방향
    static List<CogWheel> wheelList = new ArrayList<>();
    static class CogWheel {
        int[] arr;

        CogWheel(int[]a) {
            this.arr = a;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer :: parseInt;

        // 톱니바퀴 값 정보 담기
        for (int i = 0; i < 4; i++) {
            String[] c = br.readLine().split("");
            int[] tmp = new int[8];
            for (int j = 0; j < 8; j++) {
                tmp[j] = func.apply(c[j]);
            }
            wheelList.add(new CogWheel(tmp));
        }

        // 입력 받은 바퀴 회전시키기
        int spin = func.apply(br.readLine());
        int target = 0;
        int direction = 0;
        for (int s = 0; s < spin; s++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            target = func.apply(st.nextToken()) - 1; // wheelList 는 0부터 시작하므로
            direction = func.apply(st.nextToken());

            // 동시에 톱니바퀴를 회전시키기 위해서 리스트에 담고 한번에 돌린다.
            List<int[]> candidates = new ArrayList<>();
            candidates.add(new int[]{target, direction});

            //주변 톱니바퀴와 맞닿은 극이 다르면 target 과 다른 방향으로 회전시키기
            int now = target;
            int left = now - 1;
            int dir = direction;
            while (left >= 0) {
                if(wheelList.get(left).arr[2] != wheelList.get(now).arr[6]) {
                    dir = -dir; // 방향을 계속 바꿔줘야 됨 !!
                    candidates.add(new int[]{left, dir});
                    now = left;
                    left--;
                }
                else break;

            }

            now = target;
            int right = now + 1;
            int dir2 = direction;
            while (right < 4) {
                if(wheelList.get(right).arr[6] != wheelList.get(now).arr[2]) {
                    dir2 = -dir2;
                    candidates.add(new int[]{right, dir2});
                    now = right;
                    right++;
                }
                else break;
            }

            // 한 번에 회전시키기
            for(int[] ar : candidates){
                spinWheel(ar[0], ar[1]);
            }
        }

        // 최종 답 계산하기
        int result = 0;
        int n;
        // 0은 N극 , 1은 S극
        for (int w = 0; w < 4; w++) {
            n = wheelList.get(w).arr[0];
            switch (w) {
                case 0: if(n == 1) result += 1;
                    break;

                case 1: if(n == 1) result += 2;
                    break;

                case 2: if(n == 1) result += 4;
                    break;

                case 3: if(n == 1) result += 8;
                    break;
            }
        }

        System.out.println(result);
    }

    // 톱니바퀴 회전 메소드
    private static void spinWheel(int target, int direct) {
        int[] now = wheelList.get(target).arr;
        int[] cpy = now.clone();
        int idx = 0;
        // 시계 방향 (index + 1) % 8
        if(direct == 1){
            for (int i = 0; i < 8; i++) {
                idx = (i + 1) % 8;
                now[idx] = cpy[i];
            }
        }
        // 반시계 방향 (index + 7) % 8
        else {
            for (int i = 0; i < 8; i++) {
                idx = (i + 7) % 8;
                now[idx] = cpy[i];
            }

        }
    }
}
