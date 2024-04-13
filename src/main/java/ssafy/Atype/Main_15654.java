package ssafy.Atype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654 {

    static int[] arr;

    static int[] answer;

    static int N, M;

    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        combi(0, 0);
    }

    private static void combi(int start, int depth) {

        if (depth == M){

            for (int i=0; i<M; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println();

            return;
        }

        for (int i=start; i<N; i++){
            if (!isSelected[i]){
                isSelected[i] = true;
                answer[depth] = arr[i];
                combi(start, depth + 1);
                isSelected[i] = false;
            }
        }
    }
}
