package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * 수행 결과: 정답
 * 메모리: 14328 KB
 * 시간: 128 ms
 * 코드 길이: 1189B
 * 접근 방식
 * -- 주어진 r과 c값을 확인
 * -- 크게 사분면으로 나누었을 때, 해당 값이 위치한 부분을 제외한 나머지 사분면의 값을 모두 합
 * -- 반복문으로 사분면의 크기를 계속 줄여나가면서 체크
 */
public class BJ_1074_Z_박진우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;
        int square = (int) Math.pow(2, N);

        while(true){
            square /= 2;

            if (r < square && c < square){
                answer += 0;
            } else if (r < square){
                answer += square * square;
                c -= square;
            } else if (c < square){
                answer += square * square * 2;
                r -= square;
            } else {
                answer += square * square * 3;
                r -= square;
                c -= square;
            }

            if (square <= 1) {
                System.out.println(answer);
                break;
            }
        }
    }
}
