package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 결과: 맞았습니다!!
 * 메모리: 264840KB
 * 시간: 780ms
 * 접근방식
 * -- N과M(6) 방식과 동일하게 진행
 * -- 반복문의 시작점만 초기화
 *
 * @author 박진우
 */
public class BJ_15656_N과M_7_박진우 {

    static int N, M;

    static int[] arr, temp;

    static boolean[] visited;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temp = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        recursion(0, 0);

        System.out.println(sb.toString());
    }

    private static void recursion(int depth, int start) {

        if (depth == M){
            for (int i=0; i<temp.length; i++){
                sb.append(temp[i] + " ");
            }
            sb.append("\n");
            return ;
        }

        for (int i=start; i<N; i++){
            visited[i] = true;
            temp[depth] = arr[i];
            recursion(depth+1, start);
            visited[i] = false;
        }
    }
}
