package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_17825 {

    static int[] start = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0};
    static int[] ten = {0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40, 0};
    static int[] twenty = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40, 0};
    static int[] thirty = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40, 0};
    static int[] dice = new int[11];
    static int diceCount, sum, m, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dice[1] = Integer.parseInt(st.nextToken());
        dice[2] = Integer.parseInt(st.nextToken());
        dice[3] = Integer.parseInt(st.nextToken());
        dice[4] = Integer.parseInt(st.nextToken());
        dice[5] = Integer.parseInt(st.nextToken());
        dice[6] = Integer.parseInt(st.nextToken());
        dice[7] = Integer.parseInt(st.nextToken());
        dice[8] = Integer.parseInt(st.nextToken());
        dice[9] = Integer.parseInt(st.nextToken());
        dice[10] = Integer.parseInt(st.nextToken());

        sum = 0;
        diceCount = 0;
        m = 0;

        for (count = 1; count < dice.length; count++) {

            if (m >= 4)
                break;

            diceCount += dice[count];
            System.out.println("diceCount : " + diceCount);

            if (diceCount == 5) {
                count++;
                tenCount();
                diceCount=0;
                m++;
                continue;
            }

            if (diceCount == 10) {
                count++;
                twentyCount();
                diceCount=0;
                m++;
                continue;
            }
            if (diceCount == 15) {
                count++;
                thirtyCount();
                diceCount=0;
                m++;
                continue;
            }

            if (diceCount != 5 || diceCount != 10 || diceCount != 15) {
                sum += start[diceCount % (start.length)];
            }
        }

        System.out.println(sum);
    }

    private static void thirtyCount() {

        for (int i=diceCount; i<=thirty.length; i+=dice[count]){
            sum += thirty[i];
            diceCount += dice[count];
            count++;
            System.out.println("diceCount : " + diceCount);

            if (count > 10 || diceCount > thirty.length)
                return;
        }
    }

    private static void twentyCount() {

        for (int i=diceCount; i<=twenty.length; i+=dice[count]){
            sum += twenty[i];
            diceCount += dice[count];
            System.out.println("diceCount : " + diceCount);
            count++;

            if (count > 10 || diceCount > twenty.length)
                return;
        }
    }

    private static void tenCount() {

        for (int i=diceCount; i<=ten.length; i+=dice[count]){
            sum += ten[i];
            diceCount += dice[count];
            System.out.println("diceCount : " + diceCount);
            count++;

            if (count > 10 || diceCount > ten.length)
                return;
        }
    }
}
