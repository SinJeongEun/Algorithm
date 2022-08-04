package com.example.baekjoon.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SimilarWord {
    //백준 2179번 문제
//    N개의 영단어들이 주어졌을 때, 가장 비슷한 두 단어를 구해내는 프로그램을 작성하시오.
//    두 단어의 비슷한 정도는 두 단어의 접두사의 길이로 측정한다. 접두사란 두 단어의 앞부분에서 공통적으로 나타나는 부분문자열을 말한다. 즉, 두 단어의 앞에서부터 M개의 글자들이 같으면서 M이 최대인 경우를 구하는 것이다. "AHEHHEH", "AHAHEH"의 접두사는 "AH"가 되고, "AB", "CD"의 접두사는 ""(길이가 0)이 된다.
//    접두사의 길이가 최대인 경우가 여러 개일 때에는 입력되는 순서대로 제일 앞쪽에 있는 단어를 답으로 한다. 즉, 답으로 S라는 문자열과 T라는 문자열을 출력한다고 했을 때, 우선 S가 입력되는 순서대로 제일 앞쪽에 있는 단어인 경우를 출력하고, 그런 경우도 여러 개 있을 때에는 그 중에서 T가 입력되는 순서대로 제일 앞쪽에 있는 단어인 경우를 출력한다.
//    사실 최종적으로 무엇을 출력해야하는지 이해 부족,,,
    static String[] words;
    static Map<String, Integer> map = new HashMap<>();
    static List<Word> answer = new ArrayList<>();
    static List<String> duplicated = new ArrayList<>();
    static int N;
    static int max = 0;

    static class Word {
        int idx;
        String str;

        public Word(int idx, String str) {
            this.idx = idx;
            this.str = str;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            words[i] = tmp;
            map.put(tmp, map.getOrDefault(tmp, i)); //같은 단어가 있는 경우 또 넣지 않는다.
        }

        for (int n = 0; n < N; n++) {
            int count = 0;

            for (int x = 1; x < words[n].length(); x++) {
                if (map.containsKey(words[n].substring(0, x))) {
                    System.out.println("~~~     " + max + words[n].substring(0, x));
                    String now = words[n].substring(0, x);
                    count += x;
                    System.out.println(count);
                    //비슷한 단어 넣기
                    if (count > max && !duplicated.contains(now)) {
                        System.out.println("clear   ");
                        max = count;
                        answer.clear();
                        answer.add(new Word(map.get(words[n]), words[n]));
                        answer.add(new Word(map.get(now), now));
                        duplicated.add(now);
                    }
//                    else if (count == max && !duplicated.contains(now)){
//                        System.out.println("Add  ");
//                        answer.add(new Word(map.get(words[n]),words[n]));
//                        answer.add(new Word(map.get(now),now));
//                        duplicated.add(now);
//                    }

                }
            }

        }

        Collections.sort(answer, Comparator.comparingInt(a -> a.idx));
        answer.forEach(a -> System.out.println(a.str));
    }
}
