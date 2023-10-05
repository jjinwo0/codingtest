package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_2018 {
    public static void main(String[] args) throws IOException {

        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(sb.readLine());
        int sum = 0, answer = 0;

        for (int i=1; i<=N/2; i++){

            for (int j=i; j<=N; j++){

                sum += j;
                System.out.println("j : " + j + ", sum : " + sum);

                if (sum == N) {
                    answer++;
                    sum=0;
                    break;
                }
                if(sum > N) {
                    sum = 0;
                    break;
                }
            }
        }

        System.out.println(answer+1);
    }
}
