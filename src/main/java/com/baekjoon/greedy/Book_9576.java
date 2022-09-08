package com.example.baekjoon.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Book_9576 {
    static int testCase;
    static List<int[]> lists = new ArrayList<>();
    static boolean visited[];
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
        Function<String, Integer> func = Integer::parseInt;

        testCase = func.apply(br.readLine());

        for (int test = 0; test < testCase; test++) {
            lists.clear();
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int books = func.apply(st.nextToken());
            int people = func.apply(st.nextToken());
            visited = new boolean[books+1];
            //원하는 책 범위(a,b) 받기
            for (int p = 0; p < people; p++) {
                st = new StringTokenizer(br.readLine());
                lists.add(new int[]{func.apply(st.nextToken()), func.apply(st.nextToken())});
            }

            //b가 작은 순으로 정렬한다.
            Collections.sort(lists, (o1, o2) -> o1[1] - o2[1]);
            share();
            System.out.println(count);

        }
    }

    private static void share() {
        //책 나눠주기
        //b가 가장 낮은 순부터, a-b 에서 아직 빌려주지 않은 가장 번호가 낮은 책을 빌려준다.
        lists.stream().forEach(o -> {
                    for (int a = o[0]; a <= o[1]; a++) {
                        if(!visited[a]){
                            System.out.println(">>  " + a);
                            System.out.println(visited[a]);
                            count++;
                            visited[a] = true;
                            break;
                        }
                    }
                }
        );
    }
}
