package com.example.baekjoon.baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.stream.Stream;

public class Stack_17298 {
    //백준 17298 번
    //반복문으로 비교 시 시간 초과 됨
    // 두 개의 stack 을 사용하여 peek 과 들어 올 수를 비교하여 작은 peek 은 pop 으로 제거한다. -> 비교되는 수가 감소 됨

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int[] A = Stream.of(str.split(" ")).mapToInt(Integer::parseInt).toArray();

        Stack<Integer> st = new Stack<Integer>(); //오큰수가 저장되는 스택, 비교되는 수가 저장되는 스택
        Stack<Integer> ans = new Stack<Integer>();

        st.push(A[A.length-1]);
        ans.push(-1); // 마지막 값보다 큰 것은 없으므로 미리 -1 넣어 둔다.

        for(int i = A.length-2; i >= 0; i--) {
            int n = A[i];

            while(!st.isEmpty() && st.peek() <= n) {
                st.pop(); // 우큰수 스택의 값이 더 작으므로 해당 값을 제거하고 뒤에 n 을 st 스택에 삽입한다.
            }

            if(st.isEmpty()) {
                ans.push(-1);
            } else {
                ans.push(st.peek());
            }
            st.push(n);
        }

        while(!ans.isEmpty())
            bw.write(ans.pop() + " ");

        bw.flush();
        bw.close();
    }

}