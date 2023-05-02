package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class MoveDoor_2666 {
    static int N;
    static int door[];
    static int answer = Integer.MAX_VALUE;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> func = Integer::parseInt;

        N = func.apply(br.readLine());
        st = new StringTokenizer(br.readLine());

        int o1 = func.apply(st.nextToken());
        int o2 = func.apply(st.nextToken());
        M = func.apply(br.readLine());
        door = new int[M];

        for (int i = 0; i < M; i++) {
            door[i] = func.apply(br.readLine());
        }
        dfs(o1, o2, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int o1, int o2, int idx, int count) {
        if(idx == M){
            answer = Math.min(answer,count);
            return;
        }
        int tmp1 = Math.abs(o1 - door[idx]);
        int tmp2 = Math.abs(o2 - door[idx]);
        dfs(door[idx], o2, idx+1, count + tmp1);
        dfs(o1, door[idx], idx+1, count + tmp2);
    }

}
