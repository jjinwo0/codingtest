package hw.day0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 결과 : 정답입니다!!
 * 메모리 : 14124KB
 * 시간 : 124ms
 *
 * 접근 방법
 * -- 입력값이 1, 2, 3이라면 해당 값은 moo로 고정이므로 가지치기합니다.
 * -- 3보다 큰 값이라면, 입력받은 값을 토대로 수열의 길이를 구합니다.
 * -- 수열의 길이에서, 앞전 수열이 반복되는 길이 만큼을 자릅니다.
 * -- 해당 길이의 바로 앞 순번과 입력된 수가 일치하다면, 해당 글자는 m이므로 m을 리턴해줍니다.
 * -- 만약 입력된 숫자가 이보다 클 때 재귀에 들어가게 되며, 아니라면 o를 리턴합니다.
 *
 * @author 박진우
 */
public class Main_5904_Moo게임_박진우 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(game(N));
    }

    private static String game(int num) {

        int len = 3;
        int k = 0;

        if (num == 1){
            return "m";
        } else if (num < 3){
            return "o";
        } else {
            while(len <= num){
                len = len * 2 + k + 4;
                k++;
            }

            int repeatSize = (len - (k + 3)) / 2;

            if (num > repeatSize && num <= repeatSize + k + 3) {
                return num == repeatSize + 1 ? "m" : "o";
            } else if (num <= repeatSize) {
                return game(num);
            } else {
                return game(num - repeatSize - k - 3);
            }
        }
    }
}
