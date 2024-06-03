package com.example.baekjoon.baekjoon.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Network_programmers_43162 {
    public static void main(String[] args) {

    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean visited[] = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if(visited[i]) continue;
            answer++;
            bfs(computers, visited, i);
        }
        return answer;
    }

    public static void bfs(int[][] computers, boolean visited[], int i) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(i);
        visited[i] = true;

        while (!que.isEmpty()) {
            int now = que.poll();
            for(int j = 0; j < computers.length; j++){
                if(computers[now][j] == 1 && !visited[j]){
                    que.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
