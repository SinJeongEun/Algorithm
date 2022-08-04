package com.example.baekjoon.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Password1759 {
    //1759번 문제
    // 첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15) 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다. 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.
    // L 자릿수의 비밀번호, C개의 알파벳 제시
    // 알파벳 오름차순 정렬 필요
    // 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성 !!!!!!!!!!!!

    static int L;
    static int C;
    static String[] alphabets;
    static StringBuilder tmp = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] b = br.readLine().split(" ");
        alphabets = br.readLine().split(" ");
        Arrays.sort(alphabets);

        L = Integer.parseInt(b[0]); // 패스워드 자릿수
        C = Integer.parseInt(b[1]); //포함 가능성 있는 총 알파벳 수

        backtracking(tmp, 0);

    }

    public static void backtracking(StringBuilder tmp, int start) {
        if (tmp.length() == L) {
            int count = 0;
            for (int n = 0; n < L; n++) {
                if (tmp.charAt(n) == 'a' || tmp.charAt(n) == 'e' || tmp.charAt(n) == 'i' || tmp.charAt(n) == 'o' || tmp.charAt(n) == 'u') {
                    count++;
                }
            }
            if (count >= 1 && L - count >= 2) {
                System.out.println(tmp);
            }
        } else {
            for (int i = start; i < C; i++) {
                if (tmp.length() > 0 && String.valueOf(tmp.charAt(tmp.length() - 1)).compareTo(alphabets[i]) > 0)
                    continue;
                for (int j = 0; j < tmp.length(); j++) {
                    if (String.valueOf(tmp.charAt(j)).compareTo(alphabets[i]) > 0) {
                        backtracking(tmp, i + 1);
                    }
                }
                tmp.append(alphabets[i]);
                backtracking(tmp, i + 1);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }

    }


}
