package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BulbAndSwitch_2138 {
    static int n;
//    static int now[];
    static int mmin = Integer.MAX_VALUE;
    static boolean goal[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        n = func.apply(br.readLine());
        boolean now[] = new boolean[n];
        goal = new boolean[n];

        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            boolean b = str.charAt(i) == '0' ? false : true;
            now[i] = b;
        }

        str = br.readLine();
        for (int j = 0; j < n; j++) {
            boolean b = str.charAt(j) == '0' ? false : true;
            goal[j] = b;
        }

        turnOnOff(1,now.clone(),0);
        turnOnOff(1,changeArray(0, now),1);
        System.out.println(mmin == Integer.MAX_VALUE ? -1 : mmin);
    }

    public static void turnOnOff(int idx, boolean[]arr, int cnt) {
        int result = cnt;
        if(idx == n) {
            for (int i = 0; i < n; i++) {
                if(arr[i] != goal[i]) {
                    result = Integer.MAX_VALUE;
                    break;
                }
            }
            mmin = Math.min(mmin, result);
            return;
        }
        if(arr[idx - 1] != goal[idx - 1]) turnOnOff(idx + 1, changeArray(idx, arr), cnt + 1);
        else turnOnOff(idx + 1, arr, cnt);
    }

    public static boolean[] changeArray(int idx, boolean[] arr) {
        arr[idx] = !arr[idx];
        if (idx - 1 >= 0 )  arr[idx - 1] = !arr[idx - 1];
        if (idx + 1 < n)  arr[idx + 1] = !arr[idx + 1];
        return arr;
    }


}
