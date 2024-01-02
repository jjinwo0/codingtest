package swacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;

            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp % 2 == 1) sum += temp;
            }

            System.out.println("#" + (i + 1) + " " + sum);
            sum = 0;
        }
    }
}
