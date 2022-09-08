package com.example.baekjoon.baekjoon.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.function.Function;

public class MinHeap_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        int total = func.apply(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int num;
        for (int i = 0; i < total; i++) {
            num = func.apply(br.readLine());
            if(num == 0){
                //최소 힙을 출력한다.
                if(minHeap.isEmpty()) System.out.println(0);
                else System.out.println(minHeap.poll());
            }else {
                minHeap.offer(num);
            }
        }
    }
}
