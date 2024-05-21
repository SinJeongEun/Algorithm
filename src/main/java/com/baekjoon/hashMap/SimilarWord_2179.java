package com.example.baekjoon.baekjoon.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SimilarWord_2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> wordList = new ArrayList<>();  // Set은 순서 보장 안되므로 list 에 담음

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(!wordList.contains(str)) wordList.add(str);
        }

        int max = Integer.MIN_VALUE;
        int now = 0;
        int s_index = Integer.MAX_VALUE;
        int t_index = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i+1; j < N; j++) {
                now = countSameChar(wordList.get(i), wordList.get(j));

                if(now > max) {
                    max = now;
                    s_index = i;
                    t_index = j;
                }
            }
        }

        System.out.println(wordList.get(s_index));
        System.out.println(wordList.get(t_index));


    }

    public static int countSameChar(String str1, String str2) {
        int cnt = 0;
        int size = Math.min(str1.length(), str2.length());

        for (int s = 0; s < size; s++) {
            if(str1.charAt(s) == str2.charAt(s)) cnt++;
            else break;
        }
        return cnt;
    }
}
