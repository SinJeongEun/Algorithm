package com.example.baekjoon.baekjoon.stack;

import java.util.Stack;

public class LexicographicallySmallestString_leetcode_2434 {
    // s(== queue) 는 매번 poll() 할 것이다.
    // t(== stack) 은 언제 pop() 할 것인가?
    // 1. 큰 글자일 수록 stack 에서 나중에 나오는게 좋다.
    // 2. 작은 글자일 수록 stack 에서 먼저 나오는게 좋다.
    // 3. stack 에 사전역순으로 쌓여야 좋다.

    // 어떤 글자 push 되려 할 때 pop을 하지 않으면, 먼저 push 된 글자는 무조건 뒤에 적힐 수 밖에 없다.
    // 어떤 글자가 push 되려 할 때
    // 1. 더 작은 글자가 push 되려 할 때 -> 오히려 좋아. 순서대로 쌓인다.
    // 2. 같은 글자가 push 되려 할 때 -> 사전순에 영향 없음.
    // 3. 더 큰 글자가 push 되려 할 때 -> 그대로 push 하면 더 큰 글자가 앞에 나오니까 pop 하고 push!
    // 3.1 pop 하고 push 가 언제나 옳을까?
    // 3.2 bdda -> badd (x)
    // 3.3 pop 할 글자보다 더 작은 글자가 미래에 들어올 예정이라면.. 미리 빼면 안된다.
    
    public static void main(String[] args) {
//       String result = robotWithString("zza");
//       String result = robotWithString("bac");
       String result = robotWithString("bdda");
       System.out.println(result);
    }

    public static String robotWithString(String s) {
        var stack = new Stack<Character>();
        var sb = new StringBuilder();
        var minimumChar = new char[s.length()];

        // 부분합 응용(partial sum)? DP?
        minimumChar[s.length() - 1] = s.charAt(s.length() - 1);
        for (int i = s.length() - 2; i >=  0; i--) {
            minimumChar[i] = s.charAt(i) < minimumChar[i + 1] ? s.charAt(i) : minimumChar[i + 1];
        }
        // bdda
        // aaaa

        // queue 진행
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i); //poll();
            // 2번 조건
            if (stack.isEmpty() || c == stack.peek()) {
                stack.push(c);
                continue;
            }

            // 3번 조건
            while(!stack.isEmpty() && stack.peek() <= minimumChar[i]) {
                sb.append(stack.pop());
            }

            // 1번 조건
            stack.push(c);
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
