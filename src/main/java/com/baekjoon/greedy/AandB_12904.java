package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AandB_12904 {
    static StringBuilder goal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        goal = new StringBuilder(br.readLine());

        while (str.length() < goal.length()) {
            if(goal.charAt(goal.length() - 1) == 'B'){
                goal.deleteCharAt(goal.length() - 1);
                goal.reverse();
            }
            else goal.deleteCharAt(goal.length() -1 );
        }

        if (goal.toString().equals(str)) System.out.println(1);
        else System.out.println(0);
    }

}
