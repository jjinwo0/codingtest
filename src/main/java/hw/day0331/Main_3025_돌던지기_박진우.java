package hw.day0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3025_돌던지기_박진우 {

    static int R, C;

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int column = Integer.parseInt(br.readLine()) - 1;
            dropStone(column);
        }

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


    private static void dropStone(int c) {
        int r = 0;
        while (true) {
            if (r == R - 1 || map[r + 1][c] == 'X') {
                map[r][c] = 'O';
                break;
            } else if (map[r + 1][c] == 'O') {
                if (c > 0 && map[r][c - 1] == '.' && map[r + 1][c - 1] == '.') {
                    while (c > 0 && map[r][c - 1] == '.' && map[r + 1][c - 1] == '.') {
                        c--;
                    }
                    continue;
                } else if (c < C - 1 && map[r][c + 1] == '.' && map[r + 1][c + 1] == '.') {
                    while (c < C - 1 && map[r][c + 1] == '.' && map[r + 1][c + 1] == '.') {
                        c++;
                    }
                    continue;
                } else {
                    map[r][c] = 'O';
                    break;
                }
            }
            r++;
        }
    }
}
