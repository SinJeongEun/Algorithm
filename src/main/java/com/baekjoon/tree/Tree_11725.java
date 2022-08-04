package com.example.baekjoon.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[N + 1];
        List<Integer> edges[] = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            List<Integer> list = new ArrayList<>();
            edges[i] = list;
        }
        int[] answer = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            String s[] = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            edges[a].add(b);
            edges[b].add(a);

        }

//        for(List<Integer>li : edges){
//           for(int a : li) System.out.print(a);
//            System.out.println();
//        }
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);


        while (!que.isEmpty()) {
            int now = que.poll();
            check[now] = true;
            for (int n : edges[now]) {
                if (!check[n]) {
                    que.offer(n);
                    answer[n] = now;
                }

            }
        }

        for (int i = 2; i < N + 1; i++) System.out.println(answer[i]);


    }
}
