package swacademy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i=0; i<T; i++){
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int n=0; n<N; n++)
                arr[n] = sc.nextInt();

            long money = 0;
            long max = 0;

            for (int j=N-1; j>=0; j--){
                if (arr[j] > max)
                    max = arr[j];

                if (arr[j] < max)
                    money += max - arr[j];
                else continue;
            }

            System.out.println("#"+(i+1)+" "+money);
        }
    }
}
