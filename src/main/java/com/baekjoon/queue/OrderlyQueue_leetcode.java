package com.example.baekjoon.baekjoon.queue;

import java.util.Arrays;

public class OrderlyQueue_leetcode {
    public static void main(String[] args) {
        String result =  orderlyQueue("baaca", 3);
//       String result =  orderlyQueue("cba", 1);
        System.out.println(result);
    }

    public static String orderlyQueue(String s, int k) {
        if(k > 1) {
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }else {
            String s2 = new String(s);
            for (int i = 0; i < s.length(); i++) {
                s2 = s2.substring(1) + s2.charAt(0);
                if(s2.compareTo(s) < 0) s = s2;
            }
            return s;
        }
    }

}
