package com.example.baekjoon.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prime2023 {
    // 2023번 문제
    // 7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
    // 수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.
    // N 이 주어지고 N자리의 숫자 중 신기한 소수를 찾는다.

    static int N;
    static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    static StringBuilder tmp = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        backtracking(tmp);

    }

    public static void backtracking(StringBuilder tmp) {
        if (tmp.length() == N) {
            System.out.println(tmp);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmp.length() > 0) {
//                    System.out.println(tmp.toString() + nums[i]);
                    if (isPrime(Integer.parseInt(tmp.toString() + nums[i]))) {
                        tmp.append(nums[i]);
                        backtracking(tmp);
                        tmp.deleteCharAt(tmp.length() - 1);
                    } else continue;
                } else {
                    if (isPrime(nums[i])) {
                        tmp.append(nums[i]);
                        backtracking(tmp);
                        tmp.deleteCharAt(tmp.length() - 1);
                    } else continue;

                }
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number == 1) return false;
        for (int j = 2; j <= Math.sqrt(number); j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }
}
