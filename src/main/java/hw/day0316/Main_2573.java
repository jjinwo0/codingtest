package hw.day0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573 {

    static int N, M, answer;

    static int[][] map;

    static Queue<int[]> queue;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new int[N][M];
        queue = new LinkedList<>();
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {

            String[] arr = br.readLine().split(" ");
            for (int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(arr[j]);

                if (map[i][j] != 0)
                    queue.offer(new int[]{i, j});
            }
        }

        if (queue.size() == 0 || queue.size() == 1) {
            System.out.println(0);
            return;
        }

        bfs();



        System.out.println(answer);
    }

    private static void bfs() {
        while(check()){
            int size = queue.size();
            visited = new boolean[N][M];
            ArrayList<int[]> temp = new ArrayList<>();

            for (int i=0; i<size; i++){
                int[] poll = queue.poll();
                int melt = 0; // 녹는 양을 계산합니다.

                for (int k=0; k<4; k++){
                    int ny = poll[0] + dy[k];
                    int nx = poll[1] + dx[k];

                    if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 0)
                        melt++;
                }

                if (map[poll[0]][poll[1]] > melt) {
                    // 빙산이 완전히 녹지 않았다면, 임시 리스트에 추가합니다.
                    temp.add(new int[]{poll[0], poll[1], map[poll[0]][poll[1]] - melt});
                }
            }

            // 임시 리스트를 사용하여 map을 업데이트하고, 녹지 않은 빙산을 큐에 다시 추가합니다.
            for (int[] p : temp) {
                map[p[0]][p[1]] = p[2];
                queue.offer(new int[]{p[0], p[1]});
            }

            if (temp.isEmpty()) break; // 모든 빙산이 녹았다면 반복을 종료합니다.

            answer++;
        }
    }

    private static boolean check() {

        int time = 0;

        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j);
                    time += 1;
                }
            }
        }

        if (time > 1 || time == 0)
            return false;

        return true;
    }

    private static void dfs(int i, int j) {

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {

            int ny = i + dy[k];
            int nx = j + dx[k];

            if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] != 0 && !visited[ny][nx]) {
                dfs(ny, nx);
            }
        }
    }
}
