package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while(true){
            if (N%5 == 0) { // 5로 나누어 떨어지면,
                System.out.println(cnt + N/5); // cnt + 5로 나눈 값
                break;
            }else if (N < 0){ // 3으로 계속 빼다가 음의 수로 접어들면, == 3의 배수가 아니라는 뜻
                System.out.println(-1);
                break;
            }
            N -= 3; // 3씩 뺄셈
            cnt++;
        }
    }
}
