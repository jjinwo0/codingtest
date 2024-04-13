package hw.day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15898_피아의아틀리에_박진우 {

    static int N;

    static int[][][] values;
    static int[][][] elements;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        values = new int[N][4][4];
        elements = new int[N][4][4];

        for (int n=0; n<N; n++){
            for (int i=0; i<4; i++){
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<4; j++){
                    values[n][i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<4; i++){
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<4; j++){
                    values[n][i][j] = st.nextToken().charAt(0) - 'A';
                }
            }
        }
    }
}
