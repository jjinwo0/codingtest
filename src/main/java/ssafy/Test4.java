package ssafy;/*
Test4.java : 팀원 평균

[테스트케이스]

5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91

*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) throws FileNotFoundException {
				
		Scanner input = new Scanner(System.in);
		
		int T = input.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int n = input.nextInt();
			
			int[] ssafy = new int[n];
			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				ssafy[i] = input.nextInt();
				sum += ssafy[i];
			}
			
			double avg = 1.0 * sum / n;
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (ssafy[i] > avg)
					cnt++;
			}
			
			double result = 1.0 * cnt / n * 100;
			
			System.out.printf("#%d %.3f%%", test_case, result);
			System.out.println();
				
		}

	}
}
