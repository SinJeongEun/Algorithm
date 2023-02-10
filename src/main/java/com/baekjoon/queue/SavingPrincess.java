package com.example.baekjoon.baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class SavingPrincess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> func = Integer::parseInt;

        int n = func.apply(st.nextToken());
        int k = func.apply(st.nextToken());
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            que.add(i);
        }

        int tmp = 0;
        while (que.size() > 1) {
            for (int i = 0; i < k-1; i++) {
                tmp = que.poll();
                que.add(tmp);
            }
            que.poll();
        }

        System.out.println(que.peek());

    }
}

