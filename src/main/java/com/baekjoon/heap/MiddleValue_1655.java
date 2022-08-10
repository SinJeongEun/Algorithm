package com.example.baekjoon.baekjoon.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.function.Function;

public class MiddleValue_1655 {
    //최대힙, 최소힙을 만든다.
    //앞의 힙에서는 가장 오른쪽 노드는 작은수들 중 최댓값을 유지하고
    //뒤의 힙엥서 가장 왼쪽 노드는 큰수들 중에서 최솟값을 유지한다.
    //즉 이 부분들은 각 힙들이 완벽한 정렬이 되지 않아도 이 부분들은 항상 중앙값을 유지하게 된다.(루트 노드는 최대, 최소 는 보장되기 때문)
    //최대힙[  (root)]  [(root   ]최소힙
    // 값을 먼저 최대힙에 넣고, 개수일치를위해 다음은 최소힙에 넣는ㄴ다.
    // 각 peek() 값의 크기는 최소힙쪽이 더 크도록 해야되고, 그렇지 않다면 두 값을 swap 한다.
    // 출력은 중앙값이고, 중앙값이 2개인 경우 더 작은 쪽을 출력하면 되므로 무조건 최대힙의 peek 를 출력하면 된다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Function<String, Integer> func = Integer::parseInt;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        int N = func.apply(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = func.apply(br.readLine());

            if(minHeap.size() == maxHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            // 각 힙의 peek 를 검사하여 작은 수가 뒤쪽의 힙(최소힙)에 위치하지 않도록 한다.
            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    //각 루트노트 값들을 swap 한다.
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }

            //항상 앞부분의 힙인 최대힙의 루트노드 값이 중앙값이다.(중앙값이 두개인 경우 더 작은 수를 출력해야 되므로)
            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb);
    }
}
