package com.example.baekjoon.baekjoon.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
// 인프런- 해쉬맵 4.LRU
public class LRU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> func = Integer::parseInt;

        String[] tmp = br.readLine().split(" ");
        int csize = func.apply(tmp[0]);
        int nums = func.apply(tmp[1]);
        List<Integer> cache = new ArrayList<>(csize);

        String snumarr[] = br.readLine().split(" ");
        int idx = -1;
        int num = 0;
        for(String n : snumarr) {
            num = func.apply(n);
            if(cache.size() == csize) cache.remove(csize-1);
            if(cache.contains(num)) {
                cache.remove(cache.indexOf(num));
                cache.add(0,num);
            } else {
                cache.add(0,num);
            }

        }
        System.out.println(cache);
    }
}
