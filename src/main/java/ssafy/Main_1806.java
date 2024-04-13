package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int min = Integer.MIN_VALUE;
        int sum = 0;

        while(start < N && end < N){

            if (sum < S)
                sum += arr[end++];

            if (sum >= S && min > end-start)
                min = end - start;

            else sum -= arr[start++];
        }

        if (min == Integer.MIN_VALUE) {
            System.out.println(0);
            return;
        }

        System.out.println(min);
    }
}
