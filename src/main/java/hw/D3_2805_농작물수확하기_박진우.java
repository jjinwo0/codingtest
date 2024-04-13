package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 결과 : 정답
 * 메모리 : 19596KB
 * 실행 시간 : 129ms
 */
public class D3_2805_농작물수확하기_박진우 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine();

                for (int j = 0; j < N; j++) {
                    arr[i][j] = input.charAt(j) - '0';
                }
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {

                if (i <= N / 2) {
                    for (int j = Math.abs(N / 2 - i); j <= Math.abs(N / 2 + i); j++) {
                        System.out.print(j);
                        sum += arr[i][j];
                    }
                } else {
                    for (int j = Math.abs(N / 2 - i); j <= Math.abs(N / 2 + (N - 1 - i)); j++) {
                        System.out.print(j);
                        sum += arr[i][j];
                    }
                }
                System.out.println();
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }
}
