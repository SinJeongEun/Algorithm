package level5;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("개수입력");
		int n = sc.nextInt();
		System.out.println(n + "개의 수를 입력하시오");
		
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}	
		sc.close();
		Arrays.sort(arr);
		System.out.println(arr[0] + " " + arr[n-1]);
	}
}
