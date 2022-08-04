package com.example.baekjoon.baekjoon.level7;

import java.util.*;
import java.util.StringTokenizer;


public class CountWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();

        StringTokenizer st = new StringTokenizer(words, " ");

        System.out.println(st.countTokens());


    }

}
