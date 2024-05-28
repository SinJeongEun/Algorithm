package com.example.baekjoon.baekjoon.exhaustiveSearch;

import java.util.ArrayList;
import java.util.List;

public class Dictionary_programmers_84512 {
    static String arr[] = {"A", "E", "I", "O", "U"};
    static List<String> dictionary = new ArrayList<>();

    public static void main(String[] args) {

        String word = "AAAAE";
//        String word = "AAAE";
//        String word = "I";
//        String word = "EOU";

        int result = solution(word);
        System.out.println(result);
    }

    public static int solution(String word) {
        int answer = 0;

        backTrack(0, "");

        return answer;
    }

    public static void backTrack(int index, String str) {
        if (str.length() > 0 && str.length() <= 5) {
            dictionary.add(str);
        }

        if(str.length() == 5) return;

        for (int i = index; i < 5; i++) {
//            str += arr[i];
//            backTrack(i, str);
//            str = str.substring(0, str.length() - 1);
//            str = "";
//            index++;
            backTrack(i, str + arr[i]);
//            str = str.substring(0, str.length() - 1);
        }
    }
}
