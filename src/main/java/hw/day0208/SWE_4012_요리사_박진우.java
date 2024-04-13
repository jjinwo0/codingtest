package hw.day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_4012_요리사_박진우 {

    static int[] dX = {1, 0};
    static int[] dY = {0, 1};
    static boolean[] check;
    static int[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++){
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];


            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            pick(0, 1);
        }
    }

    private static void pick(int y, int x) {

        for (int i=0; i<2; i++){
            int nY = y + dY[i];
            int nX = x + dX[i];

            if (nX >= N || nY >= N)
                continue;

            if (nX == nY || nX <= nY)
                continue;

            combination(y, x, nY, nX);
        }
    }

    private static void combination(int nowY, int nowX, int y, int x) {


    }
}
