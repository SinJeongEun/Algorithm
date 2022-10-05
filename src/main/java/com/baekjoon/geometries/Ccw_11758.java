package com.example.baekjoon.baekjoon.geometries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Ccw_11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1, y1, x2, y2, x3, y3;
        x1 = func.apply(st.nextToken());
        y1 = func.apply(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x2 = func.apply(st.nextToken());
        y2 = func.apply(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x3 = func.apply(st.nextToken());
        y3 = func.apply(st.nextToken());

        int ccw = (x1*y2 - x2*y1 + x2*y3 - x3*y2 + x3*y1 - x1*y3);
//        System.out.println(ccw);

        if(ccw < 0) System.out.println(-1); // 시계방향
        else if(ccw > 0) System.out.println(1); // 반시계방향
        else if(ccw == 0) System.out.println(0); // 일직선
    }
}
