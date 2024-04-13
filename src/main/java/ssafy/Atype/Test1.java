package ssafy.Atype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test1 {
    static int N, M, P, C, D;
    static int[][] map;
    static int[][] dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1} };
    static Rudolph rudolph;
    static Santa[] santas;

    static class Position {
        int r, c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Rudolph extends Position {
        Rudolph(int r, int c) {
            super(r, c);
        }

        void move() {
            int minDist = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < P; i++) {
                Santa santa = santas[i];
                if (santa.out || santa.stun) continue;

                int dist = getDist(this, santa);
                if (dist < minDist || (dist == minDist && (santa.r > santas[minIndex].r
                        || (santa.r == santas[minIndex].r && santa.c > santas[minIndex].c)))) {
                    minDist = dist;
                    minIndex = i;
                }
            }

            if (minIndex == -1) return;

            int minR = -1, minC = -1;
            minDist = Integer.MAX_VALUE;
            for (int i = 0; i < 8; i++) {
                int nr = this.r + dir[i][0];
                int nc = this.c + dir[i][1];

                if (nr < 1 || nr > N || nc < 1 || nc > N) continue;

                int dist = getDist(nr, nc, santas[minIndex]);
                if (dist < minDist) {
                    minDist = dist;
                    minR = nr;
                    minC = nc;
                }
            }

            this.r = minR;
            this.c = minC;

            if (map[this.r][this.c] != 0) {
                int idx = map[this.r][this.c] - 1;
                santas[idx].score += C;
                santas[idx].stun = true;
                push(santas[idx], this, C);
            }
        }
    }

    static class Santa extends Position {
        boolean out, stun;
        int score;

        Santa(int r, int c) {
            super(r, c);
            this.score = 1;
        }

        void move() {
            if (this.out || this.stun) return;

            int minR = -1, minC = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                int nr = this.r + dir[i][0];
                int nc = this.c + dir[i][1];

                if (nr < 1 || nr > N || nc < 1 || nc > N || map[nr][nc] != 0) continue;

                int dist = getDist(nr, nc, rudolph);
                if (dist < minDist) {
                    minDist = dist;
                    minR = nr;
                    minC = nc;
                }
            }

            if (minR == -1 || minC == -1) return;

            map[this.r][this.c] = 0;
            this.r = minR;
            this.c = minC;
            map[this.r][this.c] = map[0][0];

            if (this.r == rudolph.r && this.c == rudolph.c) {
                this.score += D;
                push(this, rudolph, D);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        santas = new Santa[P];

        st = new StringTokenizer(br.readLine());
        rudolph = new Rudolph(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            santas[idx] = new Santa(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            map[santas[idx].r][santas[idx].c] = idx + 1;
        }

        play();
    }

    static void play() {
        for (int i = 0; i < M; i++) {
            map[0][0] = 0;
            rudolph.move();

            for (int j = 0; j < P; j++) {
                map[0][0] = j + 1;
                santas[j].move();
            }

            for (Santa santa : santas) {
                if (!santa.out && !santa.stun) santa.score++;
                santa.stun = false;
            }

            boolean flag = true;
            for (Santa santa : santas) {
                if (!santa.out) {
                    flag = false;
                    break;
                }
            }

            if (flag) break;
        }

        for (Santa santa : santas) System.out.print(santa.score + " ");
    }

    static int getDist(Position p1, Position p2) {
        return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
    }

    static int getDist(int r, int c, Position p) {
        return Math.abs(r - p.r) + Math.abs(c - p.c);
    }

    static void push(Santa santa, Position p, int dist) {
        for (int i = 0; i < 8; i++) {
            if (santa.r - p.r == dir[i][0] && santa.c - p.c == dir[i][1]) {
                for (int j = 1; j <= dist; j++) {
                    int nr = santa.r + dir[i][0] * j;
                    int nc = santa.c + dir[i][1] * j;

                    if (nr < 1 || nr > N || nc < 1 || nc > N) {
                        santa.out = true;
                        break;
                    }

                    if (map[nr][nc] != 0) {
                        if (j == dist) {
                            push(santas[map[nr][nc] - 1], new Position(nr - dir[i][0], nc - dir[i][1]), 1);
                        }

                        break;
                    }

                    if (j == dist) {
                        map[santa.r][santa.c] = 0;
                        santa.r = nr;
                        santa.c = nc;
                        map[santa.r][santa.c] = map[0][0];
                    }
                }

                break;
            }
        }
    }
}