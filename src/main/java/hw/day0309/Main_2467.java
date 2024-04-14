package hw.day0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;
        int minLeft = 0;
        int minRight = 0;
        long minValue = Long.MAX_VALUE;

        while(left < right){

            long sum = arr[left] + arr[right];

            if (minValue > Math.abs(sum)) {

                minValue = Math.abs(sum);
                minLeft = left;
                minRight = right;
            }

            if (sum >= 0) right--;
            else left++;
        }

        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}
