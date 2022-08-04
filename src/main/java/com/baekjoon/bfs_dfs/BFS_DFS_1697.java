package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;


public class BFS_DFS_1697 {

    static int bro;
    static int anwer = 0;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int subin = Integer.parseInt(a[0]);
        bro = Integer.parseInt(a[1]);
        Arrays.fill(visited, false);

        if (subin == bro) {
            System.out.println(0);
        } else {
            visited[subin] = true;
            find(subin, 0);

            System.out.println(anwer);
        }

    }

    public static void find(int subin, int time) {
        Queue<int[]> que = new LinkedList<>();
        int add;
        int sub;
        int mul;
        int[] now;
        int point;
        que.offer(new int[]{subin, time});
        while (!que.isEmpty()) {
            now = que.poll();
            point = now[0];
            time = now[1];

            add = point + 1;
            sub = point - 1;
            mul = point * 2;

            if (add == bro || sub == bro || mul == bro) {
                anwer = time + 1;
                break;
            }

            if (add >= 0 && add < 100001 && !visited[add]) {

                visited[add] = true;
                que.offer(new int[]{add, time + 1});
            }
            if (sub >= 0 && sub < 100001 && !visited[sub]) {

                visited[sub] = true;
                que.offer(new int[]{sub, time + 1});
            }
            if (mul >= 0 && mul < 100001 && !visited[mul]) {
                visited[mul] = true;
                que.offer(new int[]{mul, time + 1});
            }
        }

    }
}
