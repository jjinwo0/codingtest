package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] ant = new int[2];

        st = new StringTokenizer(br.readLine());

        ant[0] = Integer.parseInt(st.nextToken());
        ant[1] = Integer.parseInt(st.nextToken());

        int hour = Integer.parseInt(br.readLine());

        int x = 1, y = 1;

        for (int i=0; i<hour; i++){

            if (ant[0]+x > w)
                x = -1;

            if (ant[1]+y > h)
                y = -1;

            if (ant[0]+x < 0)
                x = 1;

            if (ant[1]+y < 0)
                y = 1;

            ant[0] += x;
            ant[1] += y;
        }

        System.out.println(ant[0] + " " + ant[1]);
    }
}
