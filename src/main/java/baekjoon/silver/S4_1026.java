package baekjoon.silver;


import java.util.Arrays;
import java.util.Scanner;

public class S4_1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i=0; i<N; i++){
            A[i] = sc.nextInt();
        }
        for (int i=0; i<N; i++){
            B[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i=0; i<N; i++){
            sum += A[i] * B[N-1-i];
        }
        System.out.println(sum);
    }
}
