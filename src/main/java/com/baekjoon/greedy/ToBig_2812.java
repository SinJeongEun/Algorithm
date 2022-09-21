package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.Function;

public class ToBig_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = func.apply(st.nextToken());
        int k = func.apply(st.nextToken());

        int[] nums = new int[n];
        Stack<Integer> stack = new Stack<>();

        String tmp = br.readLine();
        for (int i = 0; i < n; i++) {
            nums[i] = func.apply(String.valueOf(tmp.charAt(i)));
        }

        int cnt = 0;
        for (int a : nums) {
            if(stack.isEmpty()) {
                stack.push(a);
                continue;
            }
            for (int j : stack) System.out.println(j);
            System.out.println("------------------");
            if(cnt < k) {
                int pre = stack.peek();
                if(pre >= a) {
                    stack.push(a);
                    continue;
                }
                stack.pop();
                stack.push(a);
                cnt++;
            }else stack.push(a);
        }

//        while (cnt < k) {
//            for (int j : stack){
//                stack.g
//            }
//        }
        StringBuilder sb = new StringBuilder();
        for (int j : stack) sb.append(j);

        while (cnt < k) {
            String s = sb.toString();
            if(Integer.parseInt(s.substring(1,s.length())) - Integer.parseInt(s.substring(0,s.length() - 1)) > 0){
                sb.deleteCharAt(0);
            }
            else sb.deleteCharAt(sb.length()-1);
            cnt++;
        }
//        if(cnt < k){
//            for (int i = 0; i < stack.size() - (k - cnt); i++) {
//                sb.append(stack.get(i));
//            }
//        }else {
//            for (int j : stack) sb.append(j);
//        }
        System.out.println(sb);
    }
}
