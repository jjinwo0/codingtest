package ssafy;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String result = input.next();

		if (result.equals("*")) {
			printStar();
		}else if (result.equals("A"))
			printAlpha();
		else
			System.out.println("올바른 입력이 아닙니다.");

	}

	public static void printAlpha() {
		int num = 0;

		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < i; k++)
				System.out.print(" ");

			for (int j = 0; j < 2*(4-i) + 1; j++) {
				System.out.print((char)((num%26) + 'A') + " ");
				num++;
			}

			System.out.println();

			for (int l = 0; l < i+1; l++)
				System.out.print(" ");
		}
	}

	public static void printStar() {
		for(int i = 0; i < 4; i++) {
			for (int k = 0; k < i; k++)
				System.out.print(" ");
			for (int j = 4-i; j > 0; j--)
				System.out.print("*" + " ");
			System.out.println();
			for (int l = 0; l < i+1; l++)
				System.out.print(" ");
		}
	}


}
