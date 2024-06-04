package com.example.baekjoon.baekjoon.greedy;

import java.util.*;

public class LinkIslands_programmers_42861 {
    public static void main(String[] args) {
        int costs[][] = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int n = 4;

        solution(n, costs);
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        List<List<Node>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < costs.length; i++) {
            int idx = costs[i][0];
            int next = costs[i][1];
            int cos = costs[i][2];

            list.get(idx).add(new Node(next, cos));
        }

        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparing(Node::getCost));
        boolean visited[] = new boolean[n];

        que.offer(new Node(0, costs[0][0]));
        visited[0] = true;

        while (!que.isEmpty()) {
            Node now = que.poll();
            answer += now.cost;

            if(list.get(now.idx).size() > 0 && !visited[list.get(now.idx).get(0).idx]) {
                int next = list.get(now.idx).get(0).idx;
                visited[next] = true;
                que.offer(new Node(next, costs[now.idx][next]));
            }
        }

        return answer;
    }

    public static class Node {
        int idx;
        int cost;

        public Node(int i, int c) {
            this.idx = i;
            this.cost = c;
        }

        public int getCost() {
            return cost;
        }
    }
}
