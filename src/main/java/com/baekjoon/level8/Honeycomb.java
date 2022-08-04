package com.example.baekjoon.baekjoon.level8;

import java.util.*;

public class Honeycomb {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 1;
        int start = 2;


        if (n == 1) {
            System.out.println(1);
        } else {
            while (start <= n) {
                start += count * 6;
                count++;
            }
            System.out.println(count);
        }
        sc.close();
    }

}
