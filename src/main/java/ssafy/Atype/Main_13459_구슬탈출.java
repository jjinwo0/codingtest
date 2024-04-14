package ssafy.Atype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13459_구슬탈출 {

    static class Ball {
        int rx;
        int ry;
        int bx;
        int by;
        int count;

        Ball (int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;

            this.bx = bx;
            this.by = by;

            this.count = count;
        }
    }
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    static Ball start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        start = new Ball(rx, ry, bx, by, 0);
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Ball> queue = new LinkedList<>();

        queue.add(start);
        visited[start.rx][start.ry][start.bx][start.by] = true;

        while (!queue.isEmpty()) {
            Ball info = queue.poll();
            if (info.count > 10)
                return 0;

            if (map[info.rx][info.ry] == 'O' && map[info.bx][info.by] != 'O')
                return 1;

            for (int i = 0; i < 4; i++) {
                int[] red = move(info.rx, info.ry, i);
                int[] blue = move(info.bx, info.by, i);

                if (map[blue[0]][blue[1]] == 'O') continue;

                if (red[0] == blue[0] && red[1] == blue[1]) {
                    switch (i) {
                        case 0: // 상
                            if (info.rx > info.bx)
                                red[0]++;

                            else
                                blue[0]++;

                            break;

                        case 1: // 하
                            if (info.rx < info.bx)
                                red[0]--;

                            else
                                blue[0]--;

                            break;

                        case 2: // 좌
                            if (info.ry > info.by)
                                red[1]++;

                            else
                                blue[1]++;

                            break;

                        case 3: // 우
                            if (info.ry < info.by)
                                red[1]--;

                            else
                                blue[1]--;

                            break;
                    }
                }

                if (!visited[red[0]][red[1]][blue[0]][blue[1]]) {

                    visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                    queue.add(new Ball(red[0], red[1], blue[0], blue[1], info.count + 1));
                }
            }
        }

        return 0;
    }

    static int[] move(int x, int y, int dir) {
        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (map[x][y] == '#')
                return new int[]{x - dx[dir], y - dy[dir]};

            else if (map[x][y] == 'O')
                return new int[]{x, y};
        }
    }
}