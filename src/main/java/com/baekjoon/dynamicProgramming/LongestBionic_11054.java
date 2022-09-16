package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class LongestBionic_11054 {
//    바이토닉의 경우 특정 값을 기준으로 왼쪽 부분은 오름차순,
//    오른쪽 부분은 내림차순인 수열 또는 그러한 부분 순환이동을 말한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        int n = func.apply(br.readLine());
        int nums[] = new int[n];
        int idp[] = new int[n];
        int rdp[] = new int[n];
        int result[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = func.apply(st.nextToken());
        }
        idp[0] = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] == 1) {
                idp[i] = 1;
                continue;
            }
            for (int p = i-1; p >= 0; p--) {
                if(nums[p] == nums[i]) {
                    idp[i] = Math.max(idp[i], idp[p]);
                }
                if(nums[p] < nums[i]) {
                    idp[i] = Math.max(idp[i], idp[p] + 1);
                }
                if(idp[i] == 0) idp[i] = 1;

            }
        }

        rdp[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            if(nums[i] == 1) {
                rdp[i] = 1;
                continue;
            }
            for (int p = i+1; p < n; p++) {
                if(nums[p] == nums[i]) {
                    rdp[i] = Math.max(rdp[i], rdp[p]);
                }
                if(nums[p] < nums[i]) {
                    rdp[i] = Math.max(rdp[i], rdp[p] + 1);
                }
                if(rdp[i] == 0) rdp[i] = 1;

            }
        }

        int max = 0;
        for (int b = 0; b < n; b++) {
            result[b] = idp[b] + rdp[b];
            max = Math.max(max, result[b]);
        }
        System.out.println(max - 1);

    }
}
