package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Remainder {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1. 나머지값이 key 가 되도록  hashmap에 저장
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0; i<10;i++){
			int num = Integer.parseInt(br.readLine());
			int remain = num % 42;
			map.put(remain, map.getOrDefault(remain, 0)+1);
		}
		
		//2. 서로 다른 값이 몇개 있는지 출력
		int count =0;
		for(Integer key : map.keySet()) {
			count++;
		}
		System.out.println(count);
	}

}
