package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class ShortestPath_1753 {
    // 다익스트라 알고리즘 사용
    static List<Node>[] dist;
    static int[] dp;
    static boolean visited[];
    static class Node {
        int num, weight;

        Node(int n , int w){
            this.num = n;
            this.weight = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = func.apply(st.nextToken()); // 정점의 개수
        int E = func.apply(st.nextToken()); // 간선의 개수
        int K = func.apply(br.readLine());  // 시작 정점

        dist = new List[V + 1];
        dp = new int[V + 1];
        visited = new boolean[V + 1];

        // 배열 초기화
        Arrays.fill(dp,Integer.MAX_VALUE);
//        Arrays.fill(dist, new LinkedList<>());
        dp[K] = 0; // 시작점에서 시작점이므로 0으로 설정

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = func.apply(st.nextToken());
            int e = func.apply(st.nextToken());
            int w = func.apply(st.nextToken());
            if(dist[s] == null) dist[s] = new ArrayList<>();
            dist[s].add(new Node(e, w));
        }

        // 다익스트라 알고리즘으로 풀이
        dijkstra(K);

        for (int i = 1; i < dp.length; i++) {
            if(dp[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dp[i]);
        }


    }

    private static void dijkstra (int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            visited[now.num] = true;

            if(dist[now.num] == null) continue;
            for(Node next : dist[now.num]) {
                if(!visited[next.num] && dp[next.num] > now.weight + next.weight){
                    dp[next.num] = now.weight + next.weight;
                    pq.add(new Node(next.num, dp[next.num]));
                }
            }
        }
    }
}
