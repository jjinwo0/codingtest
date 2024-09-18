package newstudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_13398 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // input
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][2];

        // 초기에는 어떤 경우든 첫 값을 포함하고 시작
        dp[1][0] = arr[1];
        dp[1][1] = arr[1];

        int answer = dp[1][0];

        for (int i = 2; i <= N; i++) {

            // [][0]: 삭제하지 않은 최대값 -> 계속해서 숫자를 더해가는 과정
            // 연속된 수의 합이므로, 지금까지의 합보다 다음에 나오는 수가 크다면 해당 값으로 다시 시작해줘야 함
            // 만약 현재까지의 합 + 현재 수 (arr[i])가 더 크다면, 해당 값으로 쭉쭉 진행
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);

            // [][1]: 앞서서 하나를 삭제한 최대값
            // 하나를 삭제했을 때의 값 vs 하나를 이미 삭제했을 경우의 값 + 현재 수(arr[i]) 비교
            // 만약 arr[i]를 더했을 때, 더 값이 작아지게 된다면 굳이 더할 필요가 없음
            // 따라서 [][0] index의 값을 가져간다! (하나의 수를 빼내는 것)
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(answer);
    }
}
