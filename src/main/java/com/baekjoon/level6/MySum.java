package com.example.baekjoon.baekjoon.level6;

import java.util.Scanner;


public class MySum {
    static long sum(int a[]) {
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("���� ����");

        int n = sc.nextInt();

        System.out.println("���� �Է�");

        int num[] = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        sum(num);

    }

}
