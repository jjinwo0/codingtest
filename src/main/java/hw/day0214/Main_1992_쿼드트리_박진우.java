package hw.day0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 14208KB
 * 시간 : 124ms
 *
 * 접근 방법
 * -- 주어진 사각형 배열을 계속해서 4분할하는 재귀를 구성합니다.
 * -- 만약 사분면 안에 모든 문자가 동일하다면, 해당 문자를 괄호 안에 담아줍니다.
 *
 * @author 박진우
 */
public class Main_1992_쿼드트리_박진우 {

    static char[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for (int i=0; i<N; i++){

            char[] chars = br.readLine().toCharArray();
            for (int j=0; j<N; j++){
                map[i][j] = chars[j];
            }
        }

        quadTree(0, 0, N);

        System.out.println(sb);
    }

    private static void quadTree(int y, int x, int size) {

        if (isPossible(y, x, size)){
            sb.append(map[y][x]);
            return;
        }

        int divide = size/2;

        sb.append("(");
        quadTree(y, x, divide);
        quadTree(y, x + divide, divide);
        quadTree(y + divide, x, divide);
        quadTree(y + divide, x + divide, divide);
        sb.append(")");
    }

    private static boolean isPossible(int y, int x, int size) {

        char c = map[y][x];

        for (int i=y; i<y+size; i++){
            for (int j=x; j<x+size; j++){
                if (c != map[i][j])
                    return false;
            }
        }

        return true;
    }
}
