package hw.day0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕_박진우 {

    static int R, T, C;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] > 0)
                    queue.offer(new int[]{i, j});
            }
        }

        for (int i=0; i<C; i++){

            wideDust();

//            refresh();
        }
    }

    private static void wideDust() {

        int size = queue.size();

        for (int i=0; i<size; i++){
            int[] poll = queue.poll();

            if (map[poll[0]][poll[1]] >= 5){

                int value = map[poll[0]][poll[1]] / 5;

                for (int k=0; k<4; k++){
                    int ny = poll[0] + dy[k];
                    int nx = poll[1] + dx[k];
                }
            }
        }
    }
}
