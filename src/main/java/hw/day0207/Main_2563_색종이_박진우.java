package hw.day0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 14132KB
 * 시간 : 120ms
 *
 * 접근 방법
 * -- 최대 영역을 0~100까지로 잡는다.
 * -- for문을 돌면서 색종이로 덮인 영역을 true로 잡아 중복된 곳을 넘길 수 있도록 조정한다.
 *
 * @author 박진우
 */
public class Main_2563_색종이_박진우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        int n = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[101][101];

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    if (!arr[j][k]) {
                        arr[j][k] = true;
                        total++;
                    }
                }
            }
        }
        System.out.print(total);
    }
}
