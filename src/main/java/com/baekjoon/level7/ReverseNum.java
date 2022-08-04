package com.example.baekjoon.baekjoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");

        int s1 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int s2 = Integer.parseInt((new StringBuilder(st.nextToken()).reverse().toString()));


        System.out.print(s1 > s2 ? s1 : s2);


    }

}
