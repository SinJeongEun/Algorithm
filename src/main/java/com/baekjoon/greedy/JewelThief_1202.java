package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class JewelThief_1202 {
    //int 범위 -2147483648 ~ 2147483647
    //long 범위 -9223372036854775808 ~ 9223372036854775807
    static class Jewel{
        int weight;
        int price;

        Jewel(int w, int p) {
            this.weight = w;
            this.price = p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = func.apply(st.nextToken()); // 보석 개수
        int k = func.apply(st.nextToken()); // 가방 개수
        List<Jewel> jewels = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();

        // 보석 정보 담기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jewels.add(new Jewel(func.apply(st.nextToken()), func.apply(st.nextToken()) ));
        }

        // 가방 정보 담기
        for (int b = 0; b < k; b++) {
            bags.add(func.apply(br.readLine()));
        }

        // 주얼리 무게 오름차순 정렬
        Collections.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if(o1.weight == o2.weight) return o2.price - o1.price;
                return o1.weight - o2.weight;
            }
        });

        // 가방이 감당 가능한 무게가 작은 순으로 정렬하기
        Collections.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 가치가 큰 순서
        long result = 0; // 정답 범위가 int 를 넘어가므로 long
        int start = 0;
        for (int b = 0, c = 0; b < k; b++) {
            while (c < n && jewels.get(c).weight <= bags.get(b)){
                pq.offer(jewels.get(c++).price);
            }
            if(!pq.isEmpty()){
                int j = pq.poll();
                result += j;
//                System.out.println(j);
            }
        }
        System.out.println(result);

    }
}
