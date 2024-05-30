package com.example.baekjoon.baekjoon.bfs_dfs;

import java.util.*;

public class Puzzle_programmers_84021 {
    public static void main(String[] args) {
        int[][] gameBoard = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
        int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};

        solution(gameBoard, table);
    }

    public static int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        // 게임판 공백
        List<List<Point>> blanks = getGroups(game_board, 0);

        // 퍼즐 좌표
        List<List<Point>> puzzles = getGroups(table, 1);

        // todo 맞추기
        // 1. 공백의 넓이 == 퍼즐의 넓이
        // 2. 모양 일치
        for(List<Point> blankShape : blanks) {
            for(List<Point> puzzle : puzzles) {
                if(blankShape.size() != puzzle.size()) continue;
                // 모양검사


            }
        }
        return answer;
    }

    // 테이블의 퍼즐좌표, 게임보드의 공백좌표 저장
    public static List<List<Point>> getGroups(int[][] board, int targetValue) {
        List<List<Point>> groupsList= new ArrayList<>();
        int N = board.length;
        boolean visited[][] = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && board[i][j] == targetValue) {
                    List<Point> tmp = new ArrayList<>();
                    bfs(i, j, board, visited, targetValue, tmp);
                    groupsList.add(tmp);
                }
            }
        }

        return  groupsList;
    }

    public static void bfs(int x, int y, int[][] board, boolean visited[][], int targetValue, List<Point> group) {
        int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(x,y));
        visited[x][y] = true;

        while (!que.isEmpty()) {
            Point now = que.poll();
            group.add(now);

            for(int[] dir : directions) {
                int a = now.x + dir[0];
                int b = now.y + dir[1];
                if( a > -1 && a < board.length && b > -1 && b < board.length && !visited[a][b] && board[a][b] == targetValue) {
                    que.offer(new Point(a, b));
                    visited[a][b] = true;
                }
            }
        }
    }

    public static boolean checkShape(List<Point> board, List<Point> table) {
        boolean result = true;

        int[][] board_tmp = new int[board.size()][board.size()];
        int[][] table_tmp = new int[board.size()][board.size()];

        Collections.sort(board, Comparator.comparing(Point::getX).thenComparing(Point::getY));
        Collections.sort(table, Comparator.comparing(Point::getX).thenComparing(Point::getY));

        Point start = board.getFirst();
        int x = start.x;
        x = x < board.size() ? x : ;


        return result;
    }


    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
