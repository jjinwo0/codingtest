package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 20684KB
 * 시간 : 212ms
 * 접근 방식
 * -- N과M(3) 문제에서 배열의 바로 앞 숫자를 확인하는 조건 분기를 추가
 * @author 박진우
 */
public class BJ_15651_N과M_4_박진우 {

    static int[] arr;
    static StringBuilder sb;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        rec(0);

        System.out.println(sb.toString());
    }

    private static void rec(int index) {

        if (index == M){
            for (int i=0; i<M; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; i++){

            if (index > 0 && arr[index-1] > i)
                continue;
            arr[index] = i;
            rec(index + 1);
        }
    }
}