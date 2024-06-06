package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakeNumByN_programmers_42895 {
    public static void main(String[] args) {
        solution(5, 12);
    }

    public static int solution(int N, int number) {
        int answer = 0;

        List<Set<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }

        String n = N + "";
        list.get(1).add(Integer.parseInt(n));
        for (int i = 2; i <= 8; i++) {
            n += N;
            list.get(i).add(Integer.parseInt(n));
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = list.get(j);
                Set<Integer> set2 = list.get(i - j);
                
                for (int now : set1) {
                    for(int p : set2) {
                        list.get(i).add(now + p);
                        list.get(i).add(now - p);
                        list.get(i).add(now * p);

                        if(now != 0 && p != 0) list.get(i).add(now / p); 
                    }
                }
            }
        }

        for(Set<Integer> set : list) {
            if(!set.contains(number)) continue;
            return list.indexOf(set);
        }
        
        return -1;
    }
}
