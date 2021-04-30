package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ManipulatedScore {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1. 점수 저장
		double score[] = new double[Integer.parseInt(br.readLine())];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<score.length; i++) {
			score[i] = Double.parseDouble(st.nextToken());
		}
		//정렬하여 최댓값이 마지막에 오도록
		Arrays.sort(score);
		
		//2 점수 조작
		double sum = 0;
		for(int i=0; i<score.length; i++) {	
			sum += (score[i] / score[score.length-1])*100;	
		}		
		System.out.println(sum/score.length);
	}
}
