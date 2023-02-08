package com.example.baekjoon.baekjoon.hashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.function.Function;

public class TypesOfSales {
    // HashMap , sliding window 사용함
    /*현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
    각 구간별로 구하라고 했습니다.
    만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
    20 12 20 10 23 17 10
    각 연속 4일간의 구간의 매출종류는
    첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
    두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
    세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
    네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
    N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요.

    [입력]                        [출력]
    7 4                           3 4 4 3
    20 12 20 10 23 17 10

*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> func = Integer::parseInt;
        int n = func.apply(st.nextToken());
        int k = func.apply(st.nextToken());
        int arr[] = new int[n];

        String tmp[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = func.apply(tmp[i]);
        }

        for(int x : solution(n, k, arr)) System.out.println(x + " ");
    }

    public static ArrayList<Integer> solution(int n, int k, int[]arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int lt = 0;

        // 우선 k-1개만 넣어 놓는다.
        for (int i = 0; i < k-1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // 이후 rt를 추가해서 k개로 만들고 맵의 사이즈를 구하여 매출 종류의 수를 얻는다.
        // lt를 하나  빼고, 다음 rt를 추가해여 sliding window를 구현한다.
        for (int rt = k-1; rt < n; rt++) {
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());

            map.put(arr[lt], map.get(arr[lt]) - 1 );
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return answer;
    }
}
