package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_7569 {
    static int height;
    static int width;
    static List<List<int[][]>> boxes = new ArrayList<>();
    static int floor;
    static int empty = 0;
    static int ripen = 0;
    static int day = 0;
    static int total = 0;
    static Queue<int[]> que = new LinkedList<>();
    static List<int[]> wait = new ArrayList<>();
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        width = Integer.parseInt(s[0]);
        height = Integer.parseInt(s[1]);
        floor = Integer.parseInt(s[2]);

        total = width * height * floor;
        for (int f = 0; f < floor; f++) {
            List<int[][]> oneBox = new ArrayList<>();
            int[][] box = new int[height][width];
            for (int h = 0; h < height; h++) {
                String[] t = br.readLine().split(" ");
                for (int w = 0; w < width; w++) {
                    box[h][w] = Integer.parseInt(t[w]);
                }
            }
            oneBox.add(box);
            boxes.add(oneBox);
        }

        // 각 층에있는 상자들의 익은 토마토들을 한번에 큐에 넣는다.
        for (int f = 0; f < floor; f++) {
            int[][] now = boxes.get(f).get(0);
            for (int h = 0; h < height; h++) {
                for (int w = 0; w < width; w++) {
                    if (now[h][w] == -1) empty++;
                    if (now[h][w] == 1) {
                        que.offer(new int[]{f, h, w}); //해당 박스의 층수도 전달
                    }
                }
            }
        }

        bfs();

        if (total - empty != ripen) System.out.println(-1);
        else System.out.println(day);
    }

    public static void bfs() {
        while (!que.isEmpty()) {
            ripen++;
            int[] now = que.poll();
            int f = now[0]; //현재 층

            //아래,위층
            if (f - 1 >= 0 && boxes.get(f - 1).get(0)[now[1]][now[2]] == 0) {
                boxes.get(f - 1).get(0)[now[1]][now[2]]++;
                wait.add(new int[]{f - 1, now[1], now[2]});
            }
            if (f + 1 < floor && boxes.get(f + 1).get(0)[now[1]][now[2]] == 0) {
                boxes.get(f + 1).get(0)[now[1]][now[2]]++;
                wait.add(new int[]{f + 1, now[1], now[2]});
            }

            //같은 박스의 앞뒤좌우
            for (int i = 0; i < 4; i++) {
                int a = now[1] + directions[i][0];
                int b = now[2] + directions[i][1];

                if (a >= 0 && b >= 0 && a < height && b < width && boxes.get(f).get(0)[a][b] == 0) {
                    boxes.get(f).get(0)[a][b]++;
                    wait.add(new int[]{f, a, b});
                }
            }
        }
        nexDay();
    }

    public static void nexDay() {
        while (wait.size() > 0) {
            day++;
            for (int[] w : wait) {
                que.offer(new int[]{w[0], w[1], w[2]});
            }
            wait.clear();  //List는  for문을 돌 때 수정이 불가능하므로 마지막에 초기화 함
            bfs();
        }
    }
}
