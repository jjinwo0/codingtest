package ssafy.Atype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_무선충전 {

    static int M, A;

    static PriorityQueue<Integer>[][] map;

    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};

    static int[] moveA;
    static int[] moveB;

    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case=1; test_case<=T; test_case++){
            sb.append("#").append(test_case).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            map = new PriorityQueue[11][11];

            for (int i = 0; i <= 10; i++) {
                for (int j=0; j<=10; j++){
                    map[i][j] = new PriorityQueue<>(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2 - o1;
                        }
                    });
                }
            }
            moveA = new int[M+1];
            moveB = new int[M+1];
            score = new int[M+1];

            st = new StringTokenizer(br.readLine());

            for (int i=1; i<=M; i++){
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i=1; i<=M; i++){
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            for (int i=0; i<A; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                makeCharger(x, y, c, p);
            }

            move();
        }
    }

    private static void move() {

        int[] pA = new int[]{1, 1};
        int[] pB = new int[]{10, 10};

        PriorityQueue<Integer> nowA = map[pA[0]][pA[1]];
        PriorityQueue<Integer> nowB = map[pB[0]][pB[1]];

        if (!nowA.isEmpty())
            score[0] += nowA.poll();

        if (!nowB.isEmpty())
            score[0] += nowB.poll();


        for (int i=1; i<=M; i++){

            pA[0] += dx[moveA[i]];
            pA[1] += dy[moveA[i]];

            pB[0] += dx[moveB[i]];
            pB[1] += dy[moveB[i]];
        }
    }

    private static void makeCharger(int x, int y, int c, int p) {

        for (int i=x-c; i<=x+c; i++){
            for (int j=y-c; j<=y+c; j++){
                if (i >= 1 && i <= 10 && j >= 1 && j <= 10 && Math.abs(i-x) + Math.abs(j-y) <= c)
                    map[i][j].offer(p);
            }
        }
    }
}
