package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_18310 {
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i=0; i<N; i++){

            int sum = 0;

            for (int j=0; j<N; j++){

                if (arr[j] > arr[i])
                    sum += arr[j]-arr[i];
                else sum += arr[i]-arr[j];
            }

            if (sum < max) {
                max = sum;
                answer = arr[i];
            }
        }

        System.out.println(answer);
    }
}
