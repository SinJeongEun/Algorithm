package com.example.baekjoon.baekjoon.level6;

public class SelfNumber {

    public static void main(String[] args) {

        boolean[] check = new boolean[10001];    // 1���� 10000�̹Ƿ�

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) {    // 10000 �� �Ѵ� ���� �ʿ䰡 ����
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {    // false �� �ε����� ���
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }


    public static int d(int number) {
        int sum = number;

        while (number != 0) {
            sum = sum + (number % 10); // ù ° �ڸ���
            number = number / 10;    // 10�� ������ ù ° �ڸ��� ���ش�
        }

        return sum;
    }
}    
 



