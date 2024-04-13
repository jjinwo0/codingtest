package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_2178 {

    static int[][] map;
    static int N, M;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        check = new boolean[N][M];

        for (int i=0; i<N; i++){
            String str = br.readLine();
            for (int j=0; j<M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        check[0][0] = true;
        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nX = now[0];
            int nY = now[1];

            for (int i=0; i<4; i++){
                int nextX = nX + dx[i];
                int nextY = nX + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                if (check[nextX][nextY] || map[nextX][nextY] == 0)
                    continue;

                queue.add(new int[]{nextX, nextY});
                map[nextX][nextY] = map[nextX][nextY] + 1;
                check[nextX][nextY] = true;
            }
        }
    }
}
