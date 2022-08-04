package com.example.baekjoon.baekjoon.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMaxNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nums[] = new int[9];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i] > nums[max]) max = i;
        }
        System.out.println(nums[max]);
        System.out.println(max + 1);
    }

}
