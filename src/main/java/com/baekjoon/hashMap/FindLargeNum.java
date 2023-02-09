package com.example.baekjoon.baekjoon.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class FindLargeNum {
    static  TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
    static int arr[];
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> func = Integer::parseInt;

        n = func.apply(st.nextToken());
        k = func.apply(st.nextToken());
        arr = new int[n];

        String tmp[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
           arr[i] = func.apply(tmp[i]);
        }

        List<Integer> list = new ArrayList<>();
        backtrack(list,0);

//        for(int a : treeSet) {
//            System.out.println(a);
//        }
//
        for (int i = 0; i < k-1; i++) {
           treeSet.pollFirst();
        }
        Integer answer = treeSet.pollFirst();
        if(answer == null) answer = -1;
        System.out.println(treeSet.pollFirst());
    }

    public static void backtrack(List<Integer> list, int start) {
        if(list.size() == 3) {
            int sum = list.get(0) + list.get(1) + list.get(2);
            treeSet.add(sum);
        } else {
            for (int i = start; i < n; i++) {
                list.add(arr[i]);
                backtrack(list, i + 1);
                list.remove(list.size() -1 );

            }
        }
    }
}
