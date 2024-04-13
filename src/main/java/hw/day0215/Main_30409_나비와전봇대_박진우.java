package hw.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_30409_나비와전봇대_박진우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long[] pole = new long[N+1];
        long[] onLeft = new long[N+1];
        long[] onRight = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++){
            pole[i] = Long.parseLong(st.nextToken());
        }

        for (int i=1; i<=N; i++) {
            onLeft[i] = i-1;
            while (onLeft[i] > 0 && pole[(int)onLeft[i]] < pole[i]) {
                onLeft[i] = onLeft[(int)onLeft[i]];
            }
        }

        for (int i=N; i>=1; i--) {
            onRight[i] = i+1;
            while (onRight[i] <= N && pole[(int)onRight[i]] < pole[i]) {
                onRight[i] = onRight[(int)onRight[i]];
            }
        }

        int Q = Integer.parseInt(br.readLine());

        for (int i=0; i<Q; i++){
            long p = Long.parseLong(br.readLine());
            long answer = 0;

            long left = p, right = p;

            while (onLeft[(int)left] > 0) {

                long next = onLeft[(int)left];
                answer += (left-next)*(left-next) + (pole[(int)left]-pole[(int)next])*(pole[(int)left]-pole[(int)next]);
                left = next;
            }

            while (onRight[(int)right] <= N) {

                long next = onRight[(int)right];
                answer += (right-next)*(right-next) + (pole[(int)right]-pole[(int)next])*(pole[(int)right]-pole[(int)next]);
                right = next;
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
