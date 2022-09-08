package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Road_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = func.apply(st.nextToken()); // 물 웅덩이 갯수
        int L = func.apply(st.nextToken()); // 널빤지의 길이
        //웅덩이의 시작위치가 작은순으로 정렬하기
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];            }
        }); // 웅덩이 정보 저장

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{func.apply(st.nextToken()), func.apply(st.nextToken())});
        }

        int range = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int start = now[0];
            int end = now[1];

            while(range < end) {
                if(range < start) range = start;
                range += L;
                count++;
            }
        }

        System.out.println(count);

    }
}
