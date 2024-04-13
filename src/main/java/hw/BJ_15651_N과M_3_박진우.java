package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 207920KB
 * 시간 : 592ms
 * 접근 방식
 * -- 배열의 첫 인덱스 값을 기준으로 recursion
 * -- 처음 진입한 후, 반복문을 통해 배열에 값 추가
 * -- 첫 번째 값을 가지고 간 후, index값을 추가하여 재귀 진입
 * -- index값을 키우면서 재귀 탈출 조건 (index == M)을 만나면 배열에 담긴 값을 모두 출력
 * -- 재귀를 빠져나오면서 반복문이 진행되는 구조
 * @author 박진우
 */
public class BJ_15651_N과M_3_박진우 {

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
            arr[index] = i;
            rec(index + 1);
        }
    }
}