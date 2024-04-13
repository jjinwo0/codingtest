package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_12865 {

    static int weight, value;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] pack = new int[N][2];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            pack[i][0] = Integer.parseInt(st.nextToken());
            pack[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pack, (o1, o2) -> {return o1[0] - o2[0];});

        int max = 0;

        for (int i=0; i<N; i++) {
            weight = 0;
            value = 0;
            for (int j=i; j<N; j++) {

                if (weight+pack[j][0] > K) {
                    break;
                }

                weight += pack[j][0];
                value += pack[j][1];
            }

            if (value > max)
                max = value;
        }

        System.out.println(max);
    }
}
