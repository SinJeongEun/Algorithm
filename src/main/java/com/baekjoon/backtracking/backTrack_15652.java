package com.example.baekjoon.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class backTrack_15652 {
    static int N;
    static int M;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        int nums[] = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = i;
        List<Integer> tmp = new ArrayList<>();
        backTrack(1, tmp, nums);

        System.out.println(result.size());

        for (String st : result) {
            System.out.println(st);
        }

    }

    public static void backTrack(int index, List<Integer> tmp, int[] nums) {
        if (tmp.size() == M) {
            StringBuilder s = new StringBuilder();
            for (int a : tmp) {
                s.append(a).append(" ");
            }
            result.add(s.toString());
        } else {
            for (int i = index; i <= N; i++) {
                tmp.add(i);
                backTrack(i, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
