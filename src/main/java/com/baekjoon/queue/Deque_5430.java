package com.example.baekjoon.baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Deque_5430 {
    static int N; // 테스트 케이스 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                System.out.println("error");
                continue;
            }
            String str = br.readLine();
            String tmp = str.substring(1, str.length()-1);
            Deque<Integer> deque = new LinkedList<>();
            int[] arr = Arrays.stream(tmp.split(",")).mapToInt(Integer::parseInt).toArray();

            for (int a = 0; a < arr.length; a++) {
                deque.add(arr[a]);
            }
            AC(commands, deque);

        }
    }

    public static void AC(String commands, Deque<Integer> deque){
        StringBuilder sb = new StringBuilder();
        boolean isFront = true;
        for(char c : commands.toCharArray()){
            if(c == 'R') {
                isFront = !isFront;
                continue;
            }
            // D 인 경우
            if(isFront) {
                if(deque.isEmpty()){
                    System.out.println("error");
                    return;
                }
                deque.pollFirst();
            }else {
                if(deque.isEmpty()){
                    System.out.println("error");
                    return;
                }
                deque.pollLast();
            }
        }

        //출력문 만들기
        if(deque.isEmpty()) {
            System.out.println("error");
            return;
        }
        if(isFront){
            sb.append("[");
            sb.append(deque.pollFirst());
            while(!deque.isEmpty()){
                sb.append(',').append(deque.pollFirst());
            }
            sb.append("]");
        } else {
            sb.append("[");
            sb.append(deque.pollLast());
            while(!deque.isEmpty()){
                sb.append(',').append(deque.pollLast());
            }
            sb.append("]");
        }
        System.out.println(sb);
    }
}
