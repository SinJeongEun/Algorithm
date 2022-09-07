package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.Function;

public class DFS_15686_다시풀기 {
    //첫째 줄에 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값을 출력한다.
    //m 값을 깊이로해서 최대 치킨집을 구하고, 최솟값을 찾는다.
    static int map[][];
    static int n, m, answer;
    static ArrayList<Point> chicken, house;
    static Stack<Point> select;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> func = Integer::parseInt;

        n = func.apply(st.nextToken());
        m = func.apply(st.nextToken());

        chicken = new ArrayList<>(); // 치킨집
        house = new ArrayList<>(); // 집
        map = new int[n][n];
        answer = Integer.MAX_VALUE;
        select = new Stack<>(); // 선택된 치킨집

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = func.apply(st.nextToken());
                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        selectChicken(0, 0);
        System.out.println(answer);
    }

    //조합으로 치킨집 완전 탐색
    public static void selectChicken(int start, int dept) {
        if (dept == m) {
            int sum = 0;
            //각 집마다 치킨 거리를 구하고 도시 치킨 거리의 합을 구한다.
            for (int i = 0; i < house.size(); i++) {
                int r1 = house.get(i).r;
                int c1 = house.get(i).c;
                int min = Integer.MAX_VALUE;

                //한 집당 모든 치킨집과의 거리를 계산하고  최솟값을 찾는다.
                for (Point p : select) {
                    int r2 = p.r;
                    int c2 = p.c;
                    System.out.println("chick : " + r2 + " " + c2);
                    min = Math.min(min, getDistance(r1, c1, r2, c2));
                }
                sum += min;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            select.add(new Point(chicken.get(i).r, chicken.get(i).c));
            System.out.println("chicken : "+ chicken.get(i).r + " " + chicken.get(i).c);
            selectChicken(i + 1, dept + 1);
            select.pop();
        }
    }

    public static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }


}
