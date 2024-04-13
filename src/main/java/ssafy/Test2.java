package ssafy;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {

		int[][] jumsu = { { 95, 60, 72, 80 }, { 44, 52, 68, 94 }, { 65, 67, 57, 72 }, { 70, 72, 76, 77 } };
		
		double avgAll = getAvgAll(jumsu);
		double avgOne = getAvgOne(jumsu, avgAll);
		
		System.out.printf("전체 평균 : %.2f 과목 평균 : %.2f", avgAll, avgOne);
		
	}

	public static double getAvgOne(int[][] jumsu, double avgAll) {
		double avg = 0.0;
		double max = 0.0;
		double result = 0.0;
		for (int i = 0; i < 4; i++) {
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += jumsu[j][i];
			}
			avg = 1.0*sum / 4;
			double temp = Math.abs(avg-avgAll);
			if (temp > max) {
				result = avg;
			}
		}
		return result;
	}

	public static double getAvgAll(int[][] jumsu) {
		double avg = 0.0;
		for (int i = 0; i < 4; i++) {
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += jumsu[i][j];
			}
			avg += 1.0*sum / 4;
		}
		return 1.0 * avg/4;
	}

}
