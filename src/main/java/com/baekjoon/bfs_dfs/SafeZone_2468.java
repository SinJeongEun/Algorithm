package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class SafeZone_2468 {
    static int N;
    static int map[][];
    static int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        Map<Integer, Integer> hash = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        N = func.apply(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = func.apply(str[j]);
                hash.put(map[i][j], hash.getOrDefault(map[i][j],0)+1);
            }
        }

        for(Integer key : hash.keySet()){

            pq.offer(dfs(key));
        }

        System.out.println(pq.poll());

    }

    static int dfs(int key) {
        int total = 0;
        boolean visited[][] = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] >= key && !visited[i][j]){
                    dfs2(key, i, j, visited);
                    ++total;
                }
            }
        }
        return total;
    }

    static void dfs2 (int key, int y, int x, boolean[][] visited) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{y, x});

        while (!stack.isEmpty()){
            int[] now = stack.pop();

            for (int i = 0; i < directions.length; i++) {
                int a = now[0] + directions[i][0];
                int b = now[1] + directions[i][1];
                if(a>=0 && a<N && b>=0 && b<N && !visited[a][b] && map[a][b]>= key){
                    stack.add(new int[]{a,b});
                    visited[a][b] = true;
                }
            }
        }


    }
}
