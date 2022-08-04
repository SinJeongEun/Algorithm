package com.example.baekjoon.baekjoon.level7;

import java.util.Scanner;

public class FindAlphabet {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        int alphabet[] = new int[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }


        for (int j = 0; j < word.length(); j++) {
            int num = word.charAt(j) - 'a';

            if (alphabet[num] == -1) {
                alphabet[num] = j;
            }

        }

        for (int a : alphabet) {
            System.out.print(a + " ");
        }
        sc.close();
    }

}
