package com.example.baekjoon.baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Stack_9012 {
    static int N;
    static char[] parenthesis;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int count;
        for (int c = 0; c < N; c++) {
            parenthesis = br.readLine().toCharArray();
            count = 0;
            for (char s : parenthesis) {
                if (s == '(') count++;
                else count--;
                if (count < 0) break;
            }
            if (count != 0) result.add("NO");
            else result.add("YES");
        }

        for (String s : result) System.out.println(s);
    }
}
