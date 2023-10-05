package baekjoon.silver;

import java.util.Scanner;

public class S4_11047 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 배열 크기 입력
        int K = sc.nextInt(); // 구하고자 하는 값 입력
        int[] arr = new int[N]; // 금액을 담는 배열 선언
        int flag = -1;

        for (int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            if (arr[i] > K)
                flag = i-1;
        }

        if (flag == -1){ // total값이 배열의 마지막 인덱스 값보다 큰 경우,
            calc(N-1, K, arr);
        }else { // total값이 배열의 마지막 인덱스 값보다 작은 경우,
            calc(flag, K, arr);
        }

        System.out.println(answer);
    }

    public static void calc(int N, int K, int[] arr){
        for (int i=N; i>=0; i--){
            int temp = K / arr[i];
            if (temp > 0){
                answer += temp;
                K = K - arr[i] * temp;
            }
        }
    }
}
