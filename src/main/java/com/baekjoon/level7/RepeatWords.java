package com.example.baekjoon.baekjoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatWords {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("�׽�Ʈ���̽� ��");

        int testcase = Integer.parseInt(br.readLine());


        for (int i = 0; i < testcase; i++) {

            String[] str = br.readLine().split(" ");

            int repeat = Integer.parseInt(str[0]);

            String s = str[1];

            StringBuilder sb = new StringBuilder();

            for (int a = 0; a < s.length(); a++) {
                for (int j = 0; j < repeat; j++) {
                    sb.append(s.charAt(a));
                }
            }
            System.out.println(sb);
        }

    }

}
