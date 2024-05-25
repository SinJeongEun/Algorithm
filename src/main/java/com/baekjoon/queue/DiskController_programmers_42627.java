package com.example.baekjoon.baekjoon.queue;

import java.util.*;

public class DiskController_programmers_42627 {
    public static void main(String[] args) {

        int jobs[][] = {{0, 3}, {1, 9}, {2, 6}};
//        int jobs[][] = {{0, 3}, {4, 4}, {5, 3}, {4, 1}};
        int solution = solution(jobs);

        System.out.println(solution);
    }

    public static int solution(int[][] jobs) {
        PriorityQueue<Job> q = new PriorityQueue<>((a, b) -> a.time - b.time); //처리시간 순서대로
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //시작시간 순서대로

        int answer = 0;
        int current = 0; //현재 시간
        int i = 0;
        while (i < jobs.length || !q.isEmpty()) {
            while (i < jobs.length && jobs[i][0] <= current) {
                q.add(new Job(jobs[i][0],jobs[i][1]));
                i++;
            }

            if (q.isEmpty()) { //큐가 비어있다. -> 현재 실행할 수 있는 작업이 없다.
                current = jobs[i][0]; //다음 작업의 시작시간으로 이동한다.
            } else {
                Job temp = q.poll();
                answer += current + temp.time - temp.start; //요청 ~ 종료시간
                current += temp.time;
            }
        }
        return answer / jobs.length;

    }

    static class Job{
        int start;
        int time;

        public Job(int start,int time) {
            this.start = start;
            this.time = time;
        }
    }
}
