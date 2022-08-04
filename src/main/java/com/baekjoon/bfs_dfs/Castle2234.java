package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Castle2234 {
    // 백준 2234번 문재
    // 벽 계산은 비트연산자로 wall[0][0] & dir[남쪽인덱스(3)]) == 0
    // 1. 이 성에 있는 방의 개수 : dfs : rooms
    // 2. 가장 넓은 방의 넓이 : dfs로 칸 count 하면서 최댓값 찾기 : maxSize
    // 3. 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기 : dfs를 돌며 인접하나 벽이고
    // 이미 방문한 경우 이를 해당 방의 인접한 방으로 취급힌다.
    // 인접한 방이 어떤 방인지 알기 위하여 dfs를 하면서 map 배열에서 각 칸을 해당 방 number로 세팅해 둔다.
    // move{}로 상하좌우를 보다가 벽이고, 방문 한 방인 경우는 해당 칸의 값(=방 number)를 숫자로 가져와 세팅한다.
    //각 방의 크기는 배열에 저장해 둔다.
    //후에 Set을 돌며 인접한 두 방을 더하며 최댓값을 찾는다.
    static int N;
    static int M;
    static int[][] map;
    static int directions[] = {1, 2, 4, 8};  //서, 북, 동, 남
    static Wall inform[][];
    static boolean visited[][];
    static int[][] move = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static Stack<Wall> stack = new Stack<>();
    static Map<Integer, Set<Integer>> near = new HashMap<>(); //인접한 방의 목록
    static List<Integer> roomSize = new ArrayList<>(); // 각 방의 크기가 저장된 리스트

    static int rooms;
    static int maxSize = 0;

    static class Wall {
        int dir[] = new int[4];
        int x, y;

        public Wall(int y, int x, int num) {
            this.y = y;
            this.x = x;
            for (int i = 0; i < 4; i++) {
                if ((num & directions[i]) > 0) this.dir[i] = 1; //벽이 있다는 뜻    11 & 8 -> 8을 리턴한다.
                else this.dir[i] = 0; // 벽이 없는 경우는 0으로 설정
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        String str[] = br.readLine().split(" ");
        N = func.apply(str[0]); // x축
        M = func.apply(str[1]); // y축
        map = new int[M][N];
        inform = new Wall[M][N];
        visited = new boolean[M][N];

        for (int y = 0; y < M; y++) {
            String tmp[] = br.readLine().split(" ");
            for (int x = 0; x < N; x++) {
                map[y][x] = func.apply(tmp[x]);
                inform[y][x] = new Wall(y, x, func.apply(tmp[x]));
            }
        }

        int num = 1; // 방의 고유 넘버
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    stack.add(inform[i][j]);
                    map[i][j] = num;
                    visited[i][j] = true;
                    maxSize = Math.max(maxSize, dfs(num++)); // 가장 큰 방의 크기 갱신
                    ++rooms; // 방의 개수 count
                }
            }
        }

        int addTwo = 0;
        for (int r = 0; r < rooms; r++) {
            if (near.get(r + 1) != null) {
                for (int s : near.get(r + 1)) {
                    addTwo = Math.max(roomSize.get(r) + roomSize.get(s - 1), addTwo);
                }
            }
        }

        System.out.println(rooms);
        System.out.println(maxSize);
        System.out.println(addTwo);
    }

    public static int dfs(int num) {
        Set<Integer> _near = new HashSet<>(); //인접한 방을 담는다.
        int count = 0;
        while (!stack.isEmpty()) {
            Wall now = stack.pop();
            ++count;
            int nowArr[] = now.dir; //서 북 동 남으로 벽이 없으면 0, 있으면 1이다.

            for (int i = 0; i < 4; i++) {
                int ny = now.y + move[i][0];
                int nx = now.x + move[i][1];
                if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
                    if (nowArr[i] == 0 && !visited[ny][nx]) {  //벽이 아닌 경우, 방 탐색
                        stack.add(inform[ny][nx]);
                        visited[ny][nx] = true;
                        map[ny][nx] = num;
                    } else if (visited[ny][nx] && map[ny][nx] != num && map[ny][nx] != 0) { //같은 방이 아닌 인접 방인 경우
                        _near.add(map[ny][nx]);
                    }

                }
            }
        }
        roomSize.add(count); // 방의 크기 저장
        near.put(num, _near); //인접한 방 목록 저장
        return count;
    }


}
