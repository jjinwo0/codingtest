package hw.day0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int PISANO = 15 * (int)Math.pow(10, 5);

        long size = Long.parseLong(br.readLine()) % PISANO;

        long[] arr = new long[PISANO + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i=2; i<=PISANO; i++){
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1000000;
        }

        System.out.println(arr[(int)size]);
    }
}
