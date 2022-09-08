package com.example.baekjoon.baekjoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Subsequence {
    //N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
    //부분수열의 합이 S 가 되는 경우의 수 출력하기
    static int N;
    static int S;
    static int count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = func.apply(st.nextToken());
        S = func.apply(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = func.apply(st.nextToken());
        }
        dfs(0,0);

        //S 가 0 인 경우에는 공집합도 경우로 포함되므로 이를 제거한다
        if(S == 0) System.out.println(count-1);
        else System.out.println(count);
    }

    private static void dfs(int depth, int sum) {
        if(depth == N){
            if(sum == S) count++;
        }else {
            dfs(depth + 1,sum + arr[depth]);
            dfs(depth + 1,sum);
        }
    }
}
