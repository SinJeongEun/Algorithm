package com.example.baekjoon.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class SumOfTwoArrays_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> func = Integer::parseInt;

        int T = func.apply(br.readLine());
        int n1 = func.apply(br.readLine());
        String strArr1[] = br.readLine().split(" ");
        int arr1[] = Arrays.stream(strArr1).mapToInt(Integer::parseInt).toArray();

        int n2 = func.apply(br.readLine());
        String strArr2[] = br.readLine().split(" ");
        int arr2[] = Arrays.stream(strArr2).mapToInt(Integer::parseInt).toArray();

        // 부배열 : 연속된 인덱스로 이뤄진 배열
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            int sum = 0;
            for (int j = i; j < n1 ; j++) {
                sum += arr1[j];
                list1.add(sum);
            }
        }

        for (int i = 0; i < n2; i++) {
            int sum = 0;
            for (int j = i; j < n2 ; j++) {
                sum += arr2[j];
                list2.add(sum);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        // 두 부배열의 합이 T인 개수 찾기
        int cnt = 0;
        int left = 0;
        int right = list2.size() - 1;

        while (left < list1.size() && right >= 0) {
            int sum = list1.get(left) + list2.get(right);

            if(sum == T) {
                int ltCnt = 0;
                int rtCnt = 0;
                int leftVal = list1.get(left);
                int rightVal = list2.get(right);
                while (left < list1.size() && list1.get(left) == leftVal) {
                    ltCnt++;
                    left++;
                }

                while (right >= 0 && list2.get(right) == rightVal) {
                    rtCnt++;
                    right--;
                }

                cnt += ltCnt * rtCnt;
                continue;
            }
            else if(sum < T) {
                left++;
                continue;
            }
            else if(sum > T) {
                right--;
                continue;
            }
        }

        System.out.println(cnt);
    }
}
