package com.example.baekjoon.baekjoon.greedy;

import java.util.Stack;

public class Remove_K_Digits_leetcode_402 {
    public static void main(String[] args) {
//        String result = removeKdigits("1432219", 3);
//        String result = removeKdigits("10200", 1);
        String result = removeKdigits("10", 1);

        System.out.println(result);
    }

    public static String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";

        char arr[] = num.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char n : arr) {
            while (!stack.isEmpty() && k > 0&& stack.peek() > n) {
                stack.pop();
                k--;
            }
            stack.push(n);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.toString();
    }
}
