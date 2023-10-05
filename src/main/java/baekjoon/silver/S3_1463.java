package baekjoon.silver;

import java.util.Scanner;

public class S3_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;

        while(true){
            if (N % 3 == 0) {
                N /= 3;
                answer++;
            }
            else if (N % 2 == 0) {
                N /= 2;
                answer++;
            }
            else if (N % 3 != 0 && N % 2 != 0) {
                N -= 1;
                answer++;
            }
            else if (N == 1)
                break;
        }
        System.out.println(answer);
    }
}
