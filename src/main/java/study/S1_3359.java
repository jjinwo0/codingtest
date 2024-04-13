package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_3359 {

    static int first;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        if (N < 2) {
            System.out.println(Math.max(arr[0][0], arr[0][1]));
            return;
        }

        first = Math.max(Math.max(Math.max(arr[0][0] + Math.abs(arr[0][1] - arr[1][0]) + arr[1][1],
                                arr[0][0] + Math.abs(arr[0][1] - arr[1][1]) + arr[1][0]),
                        arr[0][1] + Math.abs(arr[0][0] - arr[1][0]) + arr[1][1] ),
                arr[0][1] + Math.abs(arr[0][0] - arr[1][1]) + arr[1][0]);

        if(N > 2) {
            for (int i = 2; i < N; i++) {
                int temp1 = Math.max(Math.abs(arr[i - 1][0] - arr[i][0]) + arr[i][1], Math.abs(arr[i - 1][0] - arr[i][1]) + arr[i][0]);
                int temp2 = Math.max(Math.abs(arr[i - 1][1] - arr[i][0]) + arr[i][1], Math.abs(arr[i - 1][0] - arr[i][1]) + arr[i][0]);

                first += Math.max(temp1, temp2);
            }
        }

        System.out.println(first);
    }
}

