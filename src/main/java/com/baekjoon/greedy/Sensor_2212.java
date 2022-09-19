package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Sensor_2212 {
    // 1. 센서 좌표를 오름차순 정렬한다.
    // 2. 센서 사이의 간격을 구하고 최대 힙으로 저장한다.
    // 3. k-1 만큼 poll 하고 나머지를 모두 더하면 답이 나온다.
    // 집중국을 놓을 때 두 센서를 한 구역에 포함시키지 않고 분리했으므로 최대 간격은 무시된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        int n = func.apply(br.readLine());
        int k = func.apply(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> nums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
           nums.add(func.apply(st.nextToken()));
        }

        Collections.sort(nums);

        for (int i = 0; i < nums.size()-1; i++) {
            maxHeap.add(Math.abs(nums.get(i) - nums.get(i+1)));

        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        int sum = 0;
        while (!maxHeap.isEmpty()){
            sum += maxHeap.poll();
        }

        System.out.println(sum);
    }
}
