package hw.day0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573 {

    static class Ice {
        int y;
        int x;
        int value;

        public Ice(int y, int x, int value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
    }

    static int N, M, answer;

    static int[][] map;

    static boolean[][] visited;

    static Queue<Ice> queue = new LinkedList<>();

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[N][M];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0)
                    queue.offer(new Ice(i, j, map[i][j]));
            }

        }
        bfs();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            Queue<Ice> tempQueue = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Ice ice = queue.poll();
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int ny = ice.y + dy[k];
                    int nx = ice.x + dx[k];

                    if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] == 0) {
                        count++;
                    }
                }

                ice.value -= count;
                if (ice.value > 0) {
                    tempQueue.offer(new Ice(ice.y, ice.x, ice.value));
                    map[ice.y][ice.x] = ice.value;
                } else {
                    map[ice.y][ice.x] = 0;
                }
            }

            if (tempQueue.isEmpty()) {
                System.out.println(0);
                return;
            }

            queue = tempQueue;

            if (check()) {
                System.out.println(answer + 1);
                return;
            }

            answer += 1;
        }
    }


    private static boolean check() {

        int count = 0;
        visited = new boolean[N][M];

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (map[i][j] != 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        if (count >= 2)
            return true;

        return false;
    }

    private static void dfs(int y, int x) {

        visited[y][x] = true;

        for (int k=0; k<4; k++){

            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M && map[ny][nx] != 0 && !visited[ny][nx]){
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }
    }
}
