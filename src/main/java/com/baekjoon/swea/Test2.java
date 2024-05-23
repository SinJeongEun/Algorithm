package com.example.baekjoon.baekjoon.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Test2 {
    static Deque<Point> dque = new LinkedList<>();
    static int answer = 0;
    // 지연장치 객체
    public static class Point{
        int x, time;

        public Point(int x, int t) {
            this.x = x;
            this.time = t;
        }
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 수
        int T = func.apply(st.nextToken());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = func.apply(st.nextToken());
            int D = func.apply(st.nextToken());

            // 시간 지연장치 좌표, 지연 정보 담기
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                dque.add(new Point(func.apply(st.nextToken()), func.apply(st.nextToken())));
            }

            int x1 = 0;
            int x2 = D;
            int xtime = 0;
            int dtime = 0;
            while (!dque.isEmpty()) {
                Point p = dque.pollFirst();
                xtime += p.x + p.time;
                x1 = p.x;
                x2 -= p.x;

                // D에도 해당 시간 내에 지연장치가 있는 경우
                while (!dque.isEmpty() && dque.peekLast().x <= x2) {
                    Point p2 = dque.pollLast();
                    if(p2.x >= x2) {
                        x2 = p2.x;
                        dtime = p2.time;
                    }
                }
                xtime += dtime;
                // 추가 지연된 dtime 만큼 동안 x가 지나간 곳에도 추가적으로 지연장치가 있는지 확인
                while(!dque.isEmpty() && dque.peekFirst().x <= x1) {
                    Point p3 = dque.pollFirst();
                    xtime += p3.x + p3.time;
                    x1 = p3.x;
                    x2 -= p3.x;
                }
                xtime++;
            }

            int mid = (dtime - xtime) / 2;
            int answer = xtime + mid;

            System.out.println("#" + (t + 1) + " " + answer);
        }

    }
}
