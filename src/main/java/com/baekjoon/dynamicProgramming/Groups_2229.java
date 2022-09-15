package com.example.baekjoon.baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Groups_2229 {
//    각각의 조가 잘 짜여진 정도는 그 조에 속해있는 가장 점수가 높은 학생의 점수와 가장 점수가 낮은 학생의 점수의 차이가 된다.
//    또한 전체적으로 조가 잘 짜여진 정도는, 각각의 조가 잘 짜여진 정도의 합으로 나타난다.
//    한 명으로 조가 구성되는 경우에는 그 조의 잘 짜여진 정도가 0이 된다(가장 높은 점수와 가장 낮은 점수가 같으므로).
//    학생들의 점수가 주어졌을 때, 조가 잘 짜여진 정도의 최댓값을 구하는 프로그램을 작성하시오.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> func = Integer::parseInt;
        int n = func.apply(br.readLine());
        int nums[] = new int[n];
        int dp[] = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = func.apply(st.nextToken());
        }

        dp[0] = 0;
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            int min = 10001;
            for (int j = i; j > 0; j--) {
                max = Math.max(max, nums[j-1]);
                min = Math.min(min, nums[j-1]);
                dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
            }
        }
        System.out.println(dp[n]);

    }

}
