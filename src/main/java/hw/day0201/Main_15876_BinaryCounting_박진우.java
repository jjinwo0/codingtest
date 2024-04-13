package hw.day0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 14156KB
 * 시간 : 124ms
 * 접근 방법
 * -- 반복문을 돌면서 0부터 최대 수(100) 전까지 수를 이진수로 변환합니다.
 * -- 구한 이진수를 전체 이진수 문자열에 붙여줍니다.
 * -- 진수의 차례만큼 건너뛰면서 출력합니다.
 */
public class Main_15876_BinaryCounting_박진우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String binary = "";

        for (int i=0; i<100; i++){
            binary += Integer.toBinaryString(i);
        }

        for (int j=k-1; j<n*5; j+=n){
            sb.append(binary.charAt(j)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
