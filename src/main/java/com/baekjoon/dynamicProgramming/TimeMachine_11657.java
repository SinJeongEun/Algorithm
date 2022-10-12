package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class TimeMachine_11657 {
    private static final int INF = 500 * 100_000;

    static class Bus {
        int start, end, weight;

        Bus(int s, int e, int w){
            this.start = s;
            this.end = e;
            this.weight = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = func.apply(st.nextToken()); // 도시의 개수
        int M = func.apply(st.nextToken()); // 버스 노선의 개수

        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        List<Bus> buses = new ArrayList<>();

        // 노선 입력 받기
         for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = func.apply(st.nextToken());
            int e = func.apply(st.nextToken());
            int w = func.apply(st.nextToken());
            buses.add(new Bus(s, e, w));
         }

         //벨만 포드
         distance[1] = 0;
        for (int i = 1; i <= N; i++) { // 1번 버스 부터 ~
            for (int j = 0; j < M; j++) {
                Bus bus = buses.get(j);
                if(distance[bus.start] == INF) continue;
                distance[bus.end] = Math.min(distance[bus.end], distance[bus.start] + bus.weight );
//                System.out.println(bus.end + " ]  " + bus.start + " ---->  " + bus.end + " : " + distance[bus.start] + bus.weight);
            }
        }
        
        // 음수 사이클 확인
        // 값이 갱신되면 음수 사이클이 있다는 의미
        boolean is = false;
        for (int i = 0; i < M; i++) {
            Bus bus = buses.get(i);
            if(distance[bus.start] != INF && distance[bus.end] > distance[bus.start] + bus.weight) is = true;
        }

        if(!is) {
            for (int i = 2; i <= N; i++) {
                System.out.println(distance[i] == INF ? -1 : distance[i]);
            }
        }
        else System.out.println(-1);




    }
}
