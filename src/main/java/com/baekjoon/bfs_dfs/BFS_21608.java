package com.example.baekjoon.baekjoon.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class BFS_21608 {
    // 상어 초등학교
    // 우선순위
    // 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
    // 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
    // 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
    static int N;
    static Point[][] map;
    static Map<Integer,Queue<Point>> info = new HashMap<>();
    static List<Point> students;
    static List<Point> current = new ArrayList<>();
    static int[][] directions = {{-1,0}, {0,-1}, {0,1}, {1,0}}; // 행열이 작은순을 고려한 순서로 배열 구성.

     static class Point implements Comparator<Point>{
        int val,y,x,liked,empty;

        Point(int val, int y, int x, int liked, int empty){
            this.val = val;
            this.y = y;
            this.x = x;
            this.liked = liked;
            this.empty = empty;
        }

        @Override
        public int compare(Point o1, Point o2) {
            // 1. 비어있는 칸들 중에서 좋아하는 학생의 인접을 우선으로 한다.
            // 2. 1번을 만족하는 동일한 칸이 있다면, 주변에 비어있는 칸이 많은 곳을 우선으로 한다.
            // 3. 2번을 만족하는 동일한 칸이 있다면, 행이 낮은 곳을 우선으로, 행마저 같다면 열이 낮은 곳이 우선이
            if(o1.liked != o2.liked) return o1.liked - o2.liked;
            else if(o1.empty != o2.empty) return o2.empty - o1.empty;
            else if(o1.y != o2.y) return  o1.y - o2.y;
            else return o1.x - o2.x;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        N = Integer.parseInt(br.readLine());
        map = new Point[N][N];
        students = new ArrayList<>(N+1);

        //각 학생들이 좋아하는 학생리스트 Map<> 에 저장한다.
        for (int i = 0; i <= N*N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = func.apply(st.nextToken());
            int val = func.apply(st.nextToken());
            Point p;
            if(students.get(val) == null){
               p = new Point(val,-1,-1,-1,-1);
            } else p = students.get(val);
            students.add(student,p);

            //좋아하는 학생 힙으로 우선순위 관리
            Queue<Point> tmp = new PriorityQueue<>();
            for (int j = 0; j < 4; j++) {
                tmp.add(new Point(func.apply(st.nextToken()),-1, -1, -1,-1));
            }
            info.put(student, tmp);
        }

        // 모두 비어있는 상태에서는 첫번째 학생을 (2,2) 에 삽입하면 된다.
        map[2][2] = students.get(1);
        students.get(1).y = 2;
        students.get(1).x = 2;
        students.get(1).empty = 4;
        //현재 자리에 앉은 학생
        current.add(students.get(1));

        //두번째 학생부터 자리 배치 시작
        for (int a = 2; a <= N; a++) {
            Point now = students.get(a);

            for(Point p : current){
                if(info.get(a).contains(p)){
                    //현재 좋아하는 학생이 자리에 앉아있는 경우 -> bfs로 그 주변 자리 중에 빈칸이 많고,행열이 가장 작은 자리에 위치
                    bfs(p);
                }
            }
        }
    }

    //우선순위에 맞는 자리 선정하는 메소드
    static void bfs(Point p) {
        for (int i = 0; i < 4; i++) {
            int y = p.y + directions[i][0];
            int x = p.x + directions[i][0];

            if(y>=0 && y<=N && x >=0 && x<=N) {

            }
        }
    }

}
