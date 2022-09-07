package com.example.baekjoon.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

public class Combination_6603 {
    static int num;
    static int[] arr;
    static Queue<List<Integer>> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;

        while(true) {
            String str = br.readLine();
            if(str.equals("0")){
                break;
            }

            String[] s = str.split(" ");
            //값 입력받기
            num = Integer.parseInt(s[0]);
            arr = new int[num];
            for(int i = 0; i < num; i++) {
                arr[i] = Integer.parseInt(s[i+1]);
            }

            //combination 으로 6개의 조합 만들기
            List<Integer> tmp = new ArrayList<>();
            combination(tmp, 0);

            //만든 조합 출력하기
            System.out.println();

        }

    }

    private static void combination(List<Integer> tmp, int start){
        if(tmp.size() == 6){
            StringBuilder s = new StringBuilder();
            for (int a : tmp) {
                s.append(a).append(" ");
            }
            System.out.println(s);
        } else {
            for(int i = start; i < arr.length; i++) {
                tmp.add(arr[i]);
                combination(tmp,i + 1);
                tmp.remove(tmp.size()-1);
            }
        }


    }


}
