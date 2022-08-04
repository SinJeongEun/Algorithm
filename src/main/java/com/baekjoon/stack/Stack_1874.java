package com.example.baekjoon.baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        int[] numbers = new int[N];
        List<Character> result = new ArrayList<>();
        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            sequence[i] = num;
            numbers[i] = i + 1;
        }

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < N; i++) {
            stack.push(numbers[i]);
            result.add('+');
            while (!stack.isEmpty()) {
                if (stack.peek() != sequence[index]) break;
                else {
                    stack.pop();
                    result.add('-');
                    index++;
                }
            }
        }
        if (!stack.isEmpty()) System.out.println("NO");
        else {
            for (char c : result) System.out.println(c);
        }
    }
}
