package com.example.baekjoon.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest2 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            result.add(num);
        }
        Collections.sort(result);
        for (Integer a : result) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);

    }
}
