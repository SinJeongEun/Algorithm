package com.example.baekjoon.baekjoon.level6;

import java.util.*;

public class Hansoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int han = 0;

        if (n < 100) {
            han = n;
        } else if (n == 100) {
            han = 99;

        } else {
            han = 99;
            for (int i = 100; i <= n; i++) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if ((hun - ten) == (ten - one)) han++;
            }
        }

        System.out.println(han);
        sc.close();
    }
}