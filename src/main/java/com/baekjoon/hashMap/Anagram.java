package com.example.baekjoon.baekjoon.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Anagram {
    // 아나그램 : 두 문자열이 알파벳의 나열 순서는 다르지만, 그 구성이 일치하면
    // 두 단어는 아나그램이라고 한다.
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character,Integer> map = new HashMap<>();
        String s1 = br.readLine();
        String s2 = br.readLine();
        String answer = "YES";
        for(char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(char c : s2.toCharArray()) {
            if(!map.containsKey(c) || map.get(c) == 0) {
                answer = "NO";
                break;
            }
            map.put(c, map.get(c) - 1);
        }
        System.out.println(answer);
    }
}
