package hw.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stu = new int[n * 2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<stu.length; i++){
            stu[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(stu);
    }
}
