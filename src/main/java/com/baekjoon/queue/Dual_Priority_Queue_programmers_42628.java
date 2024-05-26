package com.example.baekjoon.baekjoon.queue;

import java.util.*;
import java.util.stream.Collectors;

public class Dual_Priority_Queue_programmers_42628 {
    public static void main(String[] args) {
        String operations[] = 	{"I 4", "I -1", "I 6", "I 3"};
        int[] solution = solution(operations);
    }

    public static int[] solution(String[] operations) {
        Queue<Integer> asc_que = new PriorityQueue<>();
        Queue<Integer> desc_que = new PriorityQueue<>(Collections.reverseOrder());

        for(String oper : operations) {
            String arr[] =oper.split(" ");
            if(arr[0].equals("I")) {
                asc_que.offer(Integer.parseInt(arr[1]));
                desc_que.offer(Integer.parseInt(arr[1]));
            } else {
                if(arr[1].equals("1")) { // 큐에서 최댓값을 삭제합니다.
                    if(!desc_que.isEmpty()) {
                        int max = desc_que.poll();
                        asc_que.remove(max);
                    }
                } else { // -1 -> 	큐에서 최솟값을 삭제합니다.
                    if(!asc_que.isEmpty()) {
                        int min = asc_que.poll();
                        desc_que.remove(min);
                    }
                }
            }
        }

        if(asc_que.isEmpty()) return new int[]{0,0};
        else return new int[]{desc_que.poll(), asc_que.poll()};
    }

    public List<Integer> solution2(String[] operations) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> que = new PriorityQueue<>(); // 오름차순

        for(String a : operations) {

            //명령어와 데이터 읽기
            String[] now = a.split(" ");

            if (now[0].equals("I")) {
                que.offer(Integer.parseInt(now[1]));
            }

            else if (now[0].equals("D")) {
                //큐가 비면,,,?
                if(!que.isEmpty()) {
                    //큐에서 최댓값 삭제
                    if (now[1].equals("1")) {
                        List<Integer> tmp = que.stream().collect(Collectors.toList());
                        Collections.sort(tmp);
                        //최댓값
                        int max = tmp.get(tmp.size() - 1);
                        que.remove(max);

                    }
                    //큐에서 최솟값 삭제
                    else que.poll();
                }
                else continue;
            }
        }
        List<Integer> list = que.stream().collect(Collectors.toList());
        Collections.sort(list);
        if(list.size()>0){
            answer.add(list.get(list.size() - 1));
            answer.add(list.get(0));
        }
        else{
            answer.add(0);
            answer.add(0);
        }

        return answer;
    }
}
