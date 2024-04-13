package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String T = br.readLine();

        int[] map = {0, 0};

        for (int i=0; i<T.length()*K; i++){

            char temp = T.charAt(i % N);

            if (temp == 'U'){
                map[0] -= 1;
            }
            if (temp == 'R'){
                map[1] += 1;
            }
            if (temp == 'L'){
                map[1] -= 1;
            }
            if (temp == 'D'){
                map[0] += 1;
            }

            if (map[0] == 0 && map[1] == 0){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
