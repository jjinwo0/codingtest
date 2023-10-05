package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i=0; i<M; i++){
            StringTokenizer temp = new StringTokenizer(br.readLine(), " ");

            int bundle = Integer.parseInt(temp.nextToken());
            int single = Integer.parseInt(temp.nextToken());
        }
    }
}
