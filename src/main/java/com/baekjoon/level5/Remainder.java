package com.example.baekjoon.baekjoon.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Remainder {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. ���������� key �� �ǵ���  hashmap�� ����
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            int remain = num % 42;
            map.put(remain, map.getOrDefault(remain, 0) + 1);
        }

        //2. ���� �ٸ� ���� � �ִ��� ���
        int count = 0;
        for (Integer key : map.keySet()) {
            count++;
        }
        System.out.println(count);
    }

}
