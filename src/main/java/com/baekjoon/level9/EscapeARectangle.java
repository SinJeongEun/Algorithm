package com.example.baekjoon.baekjoon.level9;

import java.util.Scanner;

public class EscapeARectangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int xmin = Math.min(x, w - x);    // x�� �ּҰŸ�
        int ymin = Math.min(y, h - y);    // y�� �ּҰŸ�

        // x�� y�� �ּҰŸ� �� ���� ���� ��
        System.out.println(Math.min(xmin, ymin));
    }

}
