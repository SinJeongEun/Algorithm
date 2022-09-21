package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Lectures_2109<sum> {
    static class Lecture {
        int day;
        int pay;

        Lecture(int d, int p) {
            this.day = d;
            this.pay = p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st;
        PriorityQueue<Lecture> pq = new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o2.pay - o1.pay;
            }
        });
        int n = func.apply(br.readLine());
        int a = 0;
        int b = 0;
        int dayMax = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = func.apply(st.nextToken()); // 요금
            b = func.apply(st.nextToken()); // 일자
            dayMax = Math.max(dayMax, b);
            pq.add(new Lecture(b, a));
        }

        boolean checkDay[] = new boolean[dayMax + 1];
        int day = 1;
        int sum = 0;
        while (!pq.isEmpty()) {
            Lecture lec = pq.poll();
//            System.out.println(lec.pay + "  day: " + lec.day);
            for(int i = lec.day; i >= 1; i--) {
                if(!checkDay[i]) {
                    checkDay[i] = true;
                    sum += lec.pay;
                    break;
                }
            }
        }

        System.out.println(sum);

    }
}
