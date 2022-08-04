package com.example.baekjoon.baekjoon.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountWhatNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String result = Integer.toString(a * b * c);

        int counts[] = new int[10];
        for (int i = 0; i < 9; i++) {
            counts[i] = 0;
        }

        for (int i = 0; i < result.length(); i++) {
            int value = result.charAt(i) - '0';
            counts[value]++;
        }

        for (int i : counts) {
            System.out.println(i);
        }


    }

}
