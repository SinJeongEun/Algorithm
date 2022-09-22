package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class MultiTab_1700 {
    // 1. map 에 각 전기용품 번호와, 해당 용품이 사용되는 인덱스 값을 list타입으로 추가하여 저장한다.
    // 2. n개의 구멍이 남았다면 멀티탭에 추가하고, 해당 map의 value인 리스트의 0번째 값을 제거한다.
    // 3. 구멍이 꽉 찬 경우 현재 사용 중인 전기용품들의 각 list의 0번째를 조회하여 가장 큰 수(가장 나중에 사용된다는 의미)
    // 인 상품을 제거하고, 새로운 전기 용품을 추가한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = func.apply(st.nextToken()); // 멀티탭 구멍의 개수
        int k = func.apply(st.nextToken()); // 전기용품의 총 사용 횟수
        int seq[] = new int[k]; // 전기용품 사용 순서 저장 배열
        Map<Integer, List<Integer>> map = new HashMap<>(); // 전기용품별 사용 시점 인덱스 저장하기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int a= func.apply(st.nextToken());
//            System.out.println(a);
            seq[i] = a;
            // 전기용품별 사용 순서 인덱스 리스트로 저장하기
            List<Integer> tmp;
            if(map.containsKey(a)) {
                tmp = map.get(a);
                tmp.add(i);
            }
            else {
                tmp = new ArrayList<>();
                tmp.add(i);
            }
            map.put(a, tmp);
        }

        // 멀티탭 사용하기
        int result = 0;
        List<Integer> tab = new ArrayList<>();
        for (int s = 0; s < k; s++) {
            //현재 멀티탭에 있다면 map에 list 0번쨰를 지우고 넘어간다.
            if(tab.contains(seq[s])) {
                if(map.get(seq[s]).size() > 0) map.get(seq[s]).remove(0);
                continue;
            }
            // 멀티탭에 여유가 있는 경우, 멀티탭에 추가하고, map에 list 0번째를 지운다.
            if(tab.size() == 0 || tab.size() < n) {
                tab.add(seq[s]);
                map.get(seq[s]).remove(0);
            }
            //하나의 코드를 뽑아야 하는 경우
            else if (!tab.contains(seq[s]) && tab.size() == n) {
                int removeIdx = 0;
                int max = 0;
                //현재 코드들 중, 가장 나중에 쓰이게 되는 코드를 뽑아야 된다. (그래야 최소로 뽑게 된다.)
                for(int idx = 0; idx < n; idx++) {
                    if(map.get(tab.get(idx)).size() == 0) { // 다음에 쓰이지 않는 코드가 있으면 그 코드를 뽑는다.
                        removeIdx = idx;
                        break;
                    }
                    if(max < map.get(tab.get(idx)).get(0)){ // 가장 나중에 쓰이게 될 코드 찾기
                        max = map.get(tab.get(idx)).get(0);
                        removeIdx = idx;
                    }
                }
                tab.remove(removeIdx);
                result++;
                tab.add(seq[s]);
                map.get(seq[s]).remove(0);
            }

        }

        System.out.println(result);
    }
}
