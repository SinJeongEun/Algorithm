package com.example.baekjoon.baekjoon.sliding_window;

import java.util.Scanner;

public class SuccessiveNumSum {
    // 연속된 자연수의 합
//    N 입력으로 양의 정수 N이 입력되면 '2개 이상의 연속된 자연수'의 합으로 정수 N을 표현하는
//    방법의 가짓수를 출력한다.
//        15 -> 3 출력
    public int solution(int n) {
        int lt = 0, sum = 0;
        int m = n/2 + 1; // n=8 일때 4+5=9 이므로 이미 8을 넘게되므로 그 이후의 연산은 의미 없다.
        int answer = 0;
        int arr[] = new int [m];

        for (int i = 0; i < m; i++) arr[i] = i+1;

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n) {
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new SuccessiveNumSum().solution(n));
    }
}
