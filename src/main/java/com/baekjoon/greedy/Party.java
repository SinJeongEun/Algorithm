package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Party {
    // 다익스트라 알고리즘
    // X 지점 방문 후 다시 집으로 돌아오른 시간이 가장 큰 경우를 출력
    static int N;
    static int M;
    static int X;
    static boolean visited[];
    static List<Village> go[]; // 각 노드에서 X번 노드로 가기
    static List<Village> back[]; // X번 노드에서 각 노드로 가기
    static int dp[];
    static int dp2[];
    static PriorityQueue result = new PriorityQueue<>(Collections.reverseOrder());
    static class Village {
        int num, cost;

        Village(int n, int c) {
            this.num = n;
            this.cost = c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = func.apply(st.nextToken());
        M = func.apply(st.nextToken());
        X = func.apply(st.nextToken());
        go = new List[N + 1];
        back = new List[N + 1];
        dp = new int[N + 1];
        dp2 = new int[N + 1];
        visited = new boolean[N + 1];

        // 배열 초기화
        Arrays.fill(dp,Integer.MAX_VALUE);
        Arrays.fill(dp2,Integer.MAX_VALUE);
        dp[X] = 0;
        dp2[X] = 0;

        // 경로, 시간 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = func.apply(st.nextToken());
            int e = func.apply(st.nextToken());
            int c = func.apply(st.nextToken());
            if(go[e] == null) go[e] = new ArrayList<>();
            if(back[s] == null) back[s] = new ArrayList<>();
            go[e].add(new Village(s, c)); // 간선의 방향 바꿔서 저장
            back[s].add(new Village(e, c)); // 본래의 간선 방향에 맞춰서 저장
        }

        dijkstraGo(X);
        dijkstraBack(X);

        for (int i = 1; i <= N; i++) {
            result.add(dp[i] + dp2[i]);
        }

        System.out.println(result.poll());
    }

    // (출발) 각 마을에서 X 마을로 가는 최소 경로
    private static void dijkstraGo (int start) {
        PriorityQueue<Village> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Village(start, 0));

        while (!pq.isEmpty()) {
            Village now = pq.poll();
            visited[now.num] = true;

            if(go[now.num] == null) continue;
            for(Village next : go[now.num]) {
                if(!visited[next.num] && dp[next.num] > now.cost + next.cost){
                    dp[next.num] = now.cost + next.cost;
                    pq.add(new Village(next.num, dp[next.num]));
                }
            }
        }
    }

    private static void dijkstraBack (int start) {
        Arrays.fill(visited, false);
        PriorityQueue<Village> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.offer(new Village(start, 0));

        while (!pq.isEmpty()) {
            Village now = pq.poll();
            visited[now.num] = true;

            if(back[now.num] == null) continue;
            for(Village next : back[now.num]) {
                if(!visited[next.num] && dp2[next.num] > now.cost + next.cost){
                    dp2[next.num] = now.cost + next.cost;
                    pq.add(new Village(next.num, dp2[next.num]));
                }
            }
        }
    }
}
