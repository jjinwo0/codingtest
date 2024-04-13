package hw;

import java.util.Scanner;

/*
    작성자 : 박진우
    제출 : 2024년 1월 18일 00:00:18
    결과 : 통과
    성능 요약 : 메모리: 19456 KB, 시간: 488 ms
*/
public class BJ_2444 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();

        for(int i = 1; i <= N ; i++) {
            for(int j = 0; j < N-i; j++)
                System.out.print(" ");
            for(int j = 0; j < i*2-1; j++)
                System.out.print("*");
            System.out.println();
        }

        for(int i = N-1; i >= 0 ; i--) {
            for(int j = 0; j < N-i; j++)
                System.out.print(" ");
            for(int j = 0; j < i*2-1; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
