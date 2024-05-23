package com.example.baekjoon.baekjoon.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Test1 {
    static int N;
    static int arr[];
    static int answer = 0;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = func.apply(st.nextToken()); // 테스트 케이스 수
        for (int t = 0; t < T; t++) {
            answer = 0;
            N = func.apply(br.readLine()); // 사람의 수
            //System.out.println(N);
            arr = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = func.apply(st.nextToken());
            }

            // 편지 주고받기 진행
            for (int i = 1; i <= N; i++) {
                // 이미 계산된 경우
                if(arr[i] == -1) continue;

                // 해당 위치에 사람이 없는 경우
                if(i + arr[i] > N || i + arr[i] < 1) continue;

                // 0이면 주고 받은 것
                int sum = arr[i] + arr[i+ arr[i]];
                if(sum == 0) {
                    arr[i] = -1;
                    arr[i+ arr[i]] = -1;
                    answer++;
                }
            }

            // 결과
            System.out.println("#" + (t + 1) + " " + answer);
        }

    }
}