package level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GroupWordsChecker {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 단어 n개
		int groupCount=0; //총 그룹단어의 개수
		
		for(int j=0;j<n;j++) {
			//단어 저장
			String word= br.readLine();
		
			// map에 한 단어에 겹치는 문자 개수 저장
			Map<Character,Integer> map = new HashMap<>();
			
			for(char ch : word.toCharArray()) {
				map.put(ch,map.getOrDefault(ch, 0)+1);			
			}
			
			//반복되는 문자열 찾기
			int total = 0;
			int repeat = 0; //반복되는 알파벳 개수
			for(Character key : map.keySet()) {
				
				if(map.get(key) >1) {
					repeat++;
					//반복되는 문자열이 그룹인지 아닌지(붙어있는지 떨어있는지) 확인
					int start = word.indexOf(key);
					int count = 1; //해당 알파벳의 count 수가 map.get(key)와 같아야됨
					for(int i=start + 1; i<word.length(); i++) {
						if(word.charAt(i) == key && i - start == 1) {
							++count;
							start = i;
							if(count == map.get(key)) {
								total++; // 하나의 알파벳이 그룹이면 total++ , 후에 total과 repeat이 같아야 이 단어는 그룹임
								break;
							}
						}else break;		
					}		
				}				
			}
			if(total == repeat) groupCount++;	
		}
		System.out.println(groupCount);
			
	}
}
