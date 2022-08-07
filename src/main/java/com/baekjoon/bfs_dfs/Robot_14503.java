package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.function.Function;

public class Robot_14503 {
//    1. 현재 위치를 청소한다.
//    2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다. 반시계로 탐색 진행
//    3. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//    4. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
//    5. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//    6. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
//    7. 로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
    static int N; //세로
    static int M; //가로
    static int[][] map ;
    static int clean = 0;
    static HashMap<Integer,int[]> moves = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> func = Integer::parseInt;

        String[] nm = br.readLine().split(" ");
        N = func.apply(nm[0]);
        M = func.apply(nm[1]);
        map = new int[N][M];

        moves.put(0,new int[]{-1,0}); //북
        moves.put(3,new int[]{0,-1}); //서
        moves.put(2,new int[]{1,0}); //남
        moves.put(1,new int[]{0,1}); //동

        String[] position = br.readLine().split(" ");
        //청소기 시작 위치
        int y = func.apply(position[0]);
        int x = func.apply(position[1]);
        int direct = func.apply(position[2]); //처음에 청소기가 바라보는 뱡향 북:0 동:1 서:3 남:2


        for (int a = 0; a < N; a++) {
            String[] tmp = br.readLine().split(" ");
            for (int b = 0; b < M; b++) {
                map[a][b] = func.apply(tmp[b]);
            }
        }
        cleanUp(y,x,direct);
        System.out.println(clean);
    }

    public static void cleanUp(int y, int x, int direct){
        //1.  현재 위치를 청소한다.
        if(map[y][x] == 0){
            map[y][x] = 2;
            clean++;
        }

        //2. 현재 방향 기준에서 왼쪽 방향으로 탐색한다.
        int next_y = 0;
        int next_x = 0;
        boolean flag = false;
        int origin = direct;
        for (int i = 0; i < 4; i++) {
            int next_d = (direct + 3) % 4;
            next_y = y +  moves.get(next_d)[0];
            next_x = x +  moves.get(next_d)[1];

            if(next_y >=0 && next_y >=0 && next_y < N && next_x < M && map[next_y][next_x] == 0){
                cleanUp(next_y, next_x, next_d);
                flag = true;
                break;
            }
            direct = (direct + 3) % 4;
        }

        //3. 사방이 모두 벽이거나, 청소가 된 경우 방향을 유지하고 후진한다. 후진 방향이 벽이면 종료
        if(!flag) {
            int back = (origin + 2) % 4;
            int dy = y + moves.get(back)[0];
            int dx = x + moves.get(back)[1];
            if(dy >= 0 && dx >=0 && dy<N && dx<M && map[dy][dx] != 1){ // 벽이 아니면
                cleanUp(dy, dx, origin); // 방향 유지한채로 후진 ! 이 부분때문에 stackoverfolow error
            }

        }
    }

}
