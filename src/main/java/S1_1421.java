import java.io.*;
import java.util.StringTokenizer;

public class S1_1421 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int max = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                int cut = 0;
                if(arr[j] >= i) {
                    if(arr[j] % i == 0) cut = arr[j] / i - 1;
                    else cut = arr[j] / i;
                    if(W * i * (arr[j] /i) - cut * C > 0) sum += W * i * (arr[j] /i) - cut * C;
                }
            }
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }

}