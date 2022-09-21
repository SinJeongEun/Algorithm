package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Refueling_1826 {
    static class Spot {
        int distance;
        int fuel;

        Spot(int d, int f) {
            this.distance = d;
            this.fuel = f;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st;
        int N = func.apply(br.readLine()); // 주유소 개수
        List<Spot> list = new ArrayList<>(); // 주유소 정보 큐
        Queue<Spot> que = new LinkedList<>();
        int now_distance = 0; // 현재 거리
        int now_fuel = 0; // 현재 연료
        int goal_distance = 0; // 마을까지의 거리
        int result = 0; // 주유소에서 멈추는 횟수

        // 주유소 정보 담기
        int d = 0;
        for (int i = 0; i < N; i++) {
//            System.out.println(">>>> " + i);
            st = new StringTokenizer(br.readLine());
            d = func.apply(st.nextToken());
            list.add(new Spot(d, func.apply(st.nextToken())));
//            System.out.println(d - tmp);
//            tmp = d;
        }

        Collections.sort(list, new Comparator<Spot>() {
            @Override
            public int compare(Spot o1, Spot o2) {
                return o1.distance - o2.distance;
            }
        });

        int tmp = 0;
        int c = 0;
        for (int i = 0; i < N; i++) {
//            System.out.println(">>>> " + i);
            c = list.get(i).distance - tmp;
            que.add(new Spot(c, list.get(i).fuel));
//            System.out.println(d - tmp);
            tmp = c;
        }


        //마을 까지의 거리, 현재 연료량 값 받기
        st = new StringTokenizer(br.readLine());
        goal_distance = func.apply(st.nextToken());
        now_fuel = func.apply(st.nextToken());
        que.add(new Spot(goal_distance - tmp, 0));
//        System.out.println("///" +( goal_distance - tmp));

        while (!que.isEmpty()) {
            if(que.size() == 1){
                int dd = now_fuel - que.poll().distance;
//                System.out.println("dd : " + dd);
                if(dd < 0) result = -1;
                break;
            }
            Spot sp = que.poll();
            Spot next = que.peek();
            int d1 = sp.distance;
            int f1 = sp.fuel;

            if(now_fuel - d1 < next.distance) {
                now_fuel += f1;
                result++;
            }else now_fuel -= d1;
//            System.out.println(now_fuel);

        }

        if(result == -1) {
            Collections.sort(list, new Comparator<Spot>() {
                @Override
                public int compare(Spot o1, Spot o2) {
                    return o2.fuel - o1.fuel;
                }
            });

        }

        System.out.println("~~~" + result);

    }
}
