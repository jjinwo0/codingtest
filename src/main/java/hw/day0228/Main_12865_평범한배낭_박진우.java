package hw.day0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭_박진우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
        }
    }
}
