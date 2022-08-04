package com.example.baekjoon.baekjoon.level5;

import java.util.Scanner;

public class UpAvg {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("��ȸ?");
        int testCase = sc.nextInt();


        int score[];


        for (int i = 0; i < testCase; i++) {

            System.out.println("�� ��");
            int mem = sc.nextInt();
            score = new int[mem];

            System.out.println("����?");

            double sum = 0;

            for (int j = 0; j < mem; j++) {
                score[j] = sc.nextInt();
                sum += score[j];
            }


            double count = 0;

            for (int j = 0; j < mem; j++) {
                if (score[j] > (sum / mem)) {
                    count++;
                }
            }


            System.out.printf("%.3f%%\n", (count / mem) * 100);

        }

    }
}
