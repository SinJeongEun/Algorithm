package com.example.baekjoon.baekjoon.level5;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("�����Է�");
        int n = sc.nextInt();
        System.out.println(n + "���� ���� �Է��Ͻÿ�");

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[n - 1]);
    }
}
