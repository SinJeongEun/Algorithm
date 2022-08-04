package com.example.baekjoon.baekjoon.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GroupWordsChecker {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // �ܾ� n��
        int groupCount = 0; //�� �׷�ܾ��� ����

        for (int j = 0; j < n; j++) {
            //�ܾ� ����
            String word = br.readLine();

            // map�� �� �ܾ ��ġ�� ���� ���� ����
            Map<Character, Integer> map = new HashMap<>();

            for (char ch : word.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            //�ݺ��Ǵ� ���ڿ� ã��
            int total = 0;
            int repeat = 0; //�ݺ��Ǵ� ���ĺ� ����
            for (Character key : map.keySet()) {

                if (map.get(key) > 1) {
                    repeat++;
                    //�ݺ��Ǵ� ���ڿ��� �׷����� �ƴ���(�پ��ִ��� �����ִ���) Ȯ��
                    int start = word.indexOf(key);
                    int count = 1; //�ش� ���ĺ��� count ���� map.get(key)�� ���ƾߵ�
                    for (int i = start + 1; i < word.length(); i++) {
                        if (word.charAt(i) == key && i - start == 1) {
                            ++count;
                            start = i;
                            if (count == map.get(key)) {
                                total++; // �ϳ��� ���ĺ��� �׷��̸� total++ , �Ŀ� total�� repeat�� ���ƾ� �� �ܾ�� �׷���
                                break;
                            }
                        } else break;
                    }
                }
            }
            if (total == repeat) groupCount++;
        }
        System.out.println(groupCount);

    }
}
