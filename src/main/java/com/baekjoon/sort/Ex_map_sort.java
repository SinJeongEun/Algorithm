package com.example.baekjoon.baekjoon.sort;

import java.util.*;

public class Ex_map_sort {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("신", 3);
        map.put("이", 4);
        map.put("김", 1);
        map.put("박", 5);

        // key 기준으로 정렬하기
        Map<String, Integer> sortedMap1 = new TreeMap<>(map);
        for(String key : sortedMap1.keySet()) {
            System.out.println("key : " + key + " >>> " +map.get(key));
        }

        System.out.println();
        System.out.println();

        // value 기준으로 정렬하기
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for(Map.Entry<String, Integer> entry : entryList) {
            System.out.println("key : " + entry.getKey() + " >>> " +entry.getValue());
        }

    }
}
