package hw.day0210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 15324KB
 * 실행시간 : 860ms
 *
 * 접근 방법
 * -- 처음엔 DFS를 돌며 지나온 알파벳을 HashSet에 담아 contains로 체크하며 최종 값을 구하려 했습니다.
 * -- 하지만 다음 좌표를 확인하고 재귀를 빠져나올 때, 확인했던 최근 문자를 remove해주어야 했는데, 이를 처리하기 곤란했습니다.
 * -- 따라서, 지나온지 확인하는 check 배열을 알파벳 문자의 아스키 코드로 알아볼 수 있도록 설정하고, 이를 적용하기로 하였습니다.
 * -- map 좌표에 각각 문자를 넣어주고, 해당 문자를 check 배열의 인덱스로 활용하였습니다.
 * -- 이를 순회하며 count를 증가해주고, 최댓 값을 갱신합니다.
 *
 * @author 박진우
 */
public class Main_1987_알파벳_박진우 {

    static int R, C, answer;
    static int[][] map;
    static boolean[] check;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[R][C];
        check = new boolean[26];

        for (int i=0; i<R; i++){
            String temp = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 1);

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int count) {

        check[map[y][x]] = true;
        answer = Math.max(answer, count);

        for (int i=0; i<4; i++){
            int nY = y + dY[i];
            int nX = x + dX[i];

            if (nY >= 0 && nX >= 0 && nY < R && nX < C){
                if (!check[map[nY][nX]]) {

                    dfs(nY, nX, count + 1);
                }
            }
        }
        check[map[y][x]] = false;
    }
}
