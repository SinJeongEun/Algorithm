package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class BFS_16234 {
//    국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
//    위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
//    국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
//    연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
//    연합을 해체하고, 모든 국경선을 닫는다.
    // 1. 연합과 인구이동을 진행하면서 반복적으로 연합이 가능한지 확인해야 된다.
    // 2. 모든 좌표에 대해서 탐색해야 된다.
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = func.apply(st.nextToken());
        L = func.apply(st.nextToken());
        R = func.apply(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        //입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = func.apply(st1.nextToken());
            }
        }
        //결과 출력
        System.out.println(move());

    }

    //인구 이동 발생일 수 구하기
    static int move() {
        int result = 0;

        while(true) {
            visited = new boolean[N][N];
            boolean isMove = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i,j);
                        if(list.size() > 1 ){// 연합이 발생했다는 뜻 -> 인구이동
                            isMove = true;
                            changePeople(sum);
                        }
                    }
                }
            }
            if(!isMove) { // 인구이동이 일어날 수 없을 때  까지 반복된다.
                return result;
            }
            result++;
        }


    }

    public static int bfs(int i, int j) {
        list = new ArrayList<>();
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i,j});
        list.add(new int[]{i,j});

        //총 연합 인구 수 구하기
        visited[i][j] = true;
        int sum = map[i][j];

        while (!que.isEmpty()){
            int[] now = que.poll();
            for (int[] d: directions) {
                int y = now[0] + d[0];
                int x = now[1] + d[1];
                if(y >= 0 && y < N && x >= 0 && x < N && !visited[y][x]) {
                    int a = map[now[0]][now[1]];
                    int b = map[y][x];
                    if(Math.abs(a-b) >= L && Math.abs(a-b) <= R){
                        visited[y][x] = true;
                        que.offer(new int[]{y, x});
                        sum += map[y][x];
                        list.add(new int[]{y,x});
                    }
                }

            }
        }
        return sum;
    }

    public static void changePeople(int sum) {
        int avg = sum / list.size();

        for(int[]m : list){
            map[m[0]][m[1]] = avg;
        }
    }
}
