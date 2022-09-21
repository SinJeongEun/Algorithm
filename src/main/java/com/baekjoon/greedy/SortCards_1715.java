package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.function.Function;

public class SortCards_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        int n = func.apply(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(func.apply(br.readLine()));
        }

        if(n == 1) {
            System.out.println(0);
            return;
        }

        int total = 0;
        while (!minHeap.isEmpty()) {
            int together = 0;
            int a = minHeap.poll();
            int b = minHeap.poll();
            total += a + b;
            together = a + b;

            if(minHeap.size() > 0) {
                minHeap.add(together);
            }
        }
        System.out.println(total);
    }
}
