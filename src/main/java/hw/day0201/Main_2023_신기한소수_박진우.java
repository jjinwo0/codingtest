package hw.day0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2023_신기한소수_박진우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> answer = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int start = (int) Math.pow(10, N);
        int end = (int)Math.sqrt(Math.pow(10, N - 1));

        for (int i=start; i<end; i++){

            if (i/start != 2 || i/start != 3 || i/start != 5 || i/start != 7){
                continue;
            }


        }
    }
}
