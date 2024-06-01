package com.example.baekjoon.baekjoon.bfs_dfs;

import java.util.*;

public class TravelRoot_programmers_43164 {
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};
//        String[][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
        solution(tickets);
    }

    public static String[] solution(String[][] tickets){
        List<String> tmp = new ArrayList<>();

        List<Root> rootList = new ArrayList<>();
        boolean visited[] = new boolean[tickets.length];

        for(String t[] : tickets) {
            rootList.add(new Root(t[0], t[1]));
        }

        Collections.sort(rootList, Comparator.comparing(Root::getStart).thenComparing(Root::getEnd));

        tmp.add("ICN");
        dfs(rootList, "ICN", tmp, 0, visited);

        // 모든 경우 중 첫 루트가 조건에 부합하므로 첫 루트만 리턴한다.
        return result.subList(0, rootList.size()+1).stream().toArray(String[]::new);
    }

    public static void dfs(List<Root> rootList, String start, List<String> tmp, int depth, boolean visited[]) {
        if(depth == rootList.size() && tmp.size() == rootList.size() + 1) {
            result.addAll(tmp); // 가능한 모든 경로가 저장됨
        } else {
            for(int i=0; i< rootList.size(); i++) {
                if(rootList.get(i).start.equals(start) && !visited[i]) {
                    visited[i] = true;
                    tmp.add(rootList.get(i).end);
                    dfs(rootList, rootList.get(i).end, tmp, depth + 1, visited);
                    visited[i] = false;
                    if(tmp.size() > 0) tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    public static class Root {
        String start;
        String end;

        public Root(String s, String e) {
            this.start = s;
            this.end = e;
        }

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }
    }

        // 2022.01.08
        public String[] solution2(String[][] tickets) {
            ArrayList<String> result = new ArrayList<String>();
            //방문경로를 저장하기위한 배열
            Boolean[] visited = new Boolean[tickets.length];
            Arrays.fill(visited, Boolean.FALSE);

            //깊이탐색 시작
            dfs2(visited, "ICN", "", tickets, 0,result);

            //알파벳순서로 가장 빠른 경로를 가져오기 위한 정렬
            //모든 경우의 수를 result에 저장되어 있으니 정렬 후 가장 앞에 있는 배열을 출력한다.
            Collections.sort(result);

            String[] answer = result.get(0).split(",");
            return answer;
        }

        static void dfs2(Boolean[] visited, String station, String path, String[][] tickets, int index,  ArrayList<String> result)  {
            if("".equals(path)) {
                path = station;
            }else {
                path = path + ","+ station;
            }

            if(index == tickets.length) {
                result.add(path);
            }

            for(int i=0; i<tickets.length; i++) {
                //사용하지 않은 티켓이고 가는 경로가 있을 경우
                if(!visited[i] && tickets[i][0].equals(station)) {
                    visited[i] = true;

                    dfs2(visited, tickets[i][1], path, tickets, index+1,result);
                    visited[i] = false;

                }
            }
        }

}
