package com.example.baekjoon.baekjoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountAlphabet {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int alpha[] = new int[26];
        for (int j = 0; j < 26; j++) {
            alpha[j] = 0;
        }

        for (int i = 0; i < str.length(); i++) {
            if (65 <= str.charAt(i) && str.charAt(i) <= 90) {
                alpha[str.charAt(i) - 'A']++;
            } else {
                alpha[str.charAt(i) - 'a']++;
            }
        }

        int max = 0;
        char ch = '?';


        for (int i = 0; i < 26; i++) {
            if (alpha[i] > max) {
                max = alpha[i];
                ch = (char) (i + 'A');
            } else if (alpha[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);

    }

}
