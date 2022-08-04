package com.example.baekjoon.baekjoon.level5;

import java.util.Scanner;

public class OXquize {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("�����Է�");
        int n = sc.nextInt();
        sc.nextLine();
        String testCase[] = new String[n];

        System.out.println("�׽�Ʈ ���̽� �Է�");


        for (int i = 0; i < n; i++) {
            testCase[i] = sc.nextLine();
        }

        for (String s : testCase) {
            int point = 0;
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {

                if (s.substring(i, i + 1).equals("O")) {
                    ++point;
                    sum += point;
                } else {
                    point = 0;
                }
            }
            System.out.println(sum);
            sc.close();
        }

    }
}
