package com.example.baekjoon.baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class QueueTest {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer command;

        while (N-- > 0) {
            command = new StringTokenizer(br.readLine(), " ");    // ���ڿ� �и�

            switch (command.nextToken()) {

                case "push":
                    // offer�� ť�� �� �ڿ� ��Ҹ� �߰��Ѵ�.
                    q.offer(Integer.parseInt(command.nextToken()));
                    break;

                case "pop":
                    /*
                     *  poll�� ���� �տ� �ִ� ��Ҹ� �����ϸ�
                     *  ������ ���Ұ� ���� ��� ���ܸ� ������ ���� �ƴ� null�� ��ȯ�Ѵ�.
                     */
                    Integer item = q.poll();
                    if (item == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(item).append('\n');
                    }
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;

                case "front":
                    // peek()�� ť�� ���� ��Ұ� ���� ��� null�� ��ȯ�Ѵ�.
                    Integer ite = q.peek();
                    if (ite == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(ite).append('\n');
                    }
                    break;

                case "back":
                    // peekLast()�� ť�� ���� ��Ұ� ���� ��� null�� ��ȯ�Ѵ�.
                    Integer it = q.peekLast();
                    if (it == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(it).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}