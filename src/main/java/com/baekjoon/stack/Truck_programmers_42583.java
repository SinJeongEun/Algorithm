package com.example.baekjoon.baekjoon.stack;

import java.util.LinkedList;
import java.util.Queue;

public class Truck_programmers_42583 {

    public static void main(String[] args) {
//        int bridge_length = 2;
//        int weigh = 10;
//        int[] truck_weights = {7,4,5,6};

//        int bridge_length = 100;
//        int weigh = 100;
//        int[] truck_weights = {10};

        int bridge_length = 100;
        int weigh = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length, weigh, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        if(bridge_length == 1) return truck_weights.length+1;
        if(truck_weights.length == 1) return bridge_length+1;

        // 순서대로만 출발 가능
        Queue<Truck> truckQue = new LinkedList<>();
        int idx = 0;
        int time = 1;
        int now_weight =0;

        truckQue.offer(new Truck(truck_weights[idx], 1));

        while (!truckQue.isEmpty() && truckQue.peek().cnt <= bridge_length) {
            truckQue.forEach(truck -> truck.cnt++);
            time++;

            if(truckQue.peek().cnt > bridge_length) truckQue.poll();

            // 무게 여유 있으면 다른 트럭도 출발
            now_weight = calNowWeight(truckQue);
            if(truckQue.size() < bridge_length && idx +1 < truck_weights.length && truck_weights[idx + 1] + now_weight <= weight) {
                truckQue.offer(new Truck(truck_weights[++idx], 1));
            }
        }

        return time;
    }

    public static int calNowWeight(Queue<Truck> que) {
        int sum = 0;
        if(que.isEmpty()) return sum;
        else {
            for(Truck t : que) sum += t.weight;
            return sum;
        }
    }


    static class Truck {
        int weight;
        int cnt;

        public Truck(int w, int c) {
            this.weight = w;
            this.cnt = c;
        }
    }
}
