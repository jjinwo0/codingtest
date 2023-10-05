package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[(int) Math.pow(3, N)];
        for (int i=0; i<arr.length; i++){
            arr[i] = "-";
        }
        division(arr, 0, arr.length);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    public static void division(String[] arr, int s, int n){
        int start = (n-s)/3;
        for (int i=start; i<start*2; i++){
            arr[i] = " ";
        }
        if (start/3 <= 1)
            return ;
        division(arr, 0, start/3);
        division(arr, start*2, arr.length);
    }
}
