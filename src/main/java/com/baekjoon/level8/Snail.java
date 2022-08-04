package com.example.baekjoon.baekjoon.level8;

import java.util.*;

public class Snail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int climb = sc.nextInt();
        int slip = sc.nextInt();
        int meter = sc.nextInt();

        int day = (meter - slip) / (climb - slip);

        if ((meter - slip) % (climb - slip) != 0) {
            day++;
        }
        System.out.println(day);
        sc.close();
    }

}
