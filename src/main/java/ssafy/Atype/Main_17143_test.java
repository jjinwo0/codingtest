package ssafy.Atype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17143_test {

    public static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, -1, 1, 0, 0};

    static Shark[][] map;

    static ArrayList<Shark> sharks;

    static int R, C, M, answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R + 1][C + 1];
        sharks = new ArrayList<>();
        answer = 0;

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r, c, s, d, z);
            sharks.add(map[r][c]);
        }

        move();

        System.out.println(answer);
    }

    private static void move() {

        for (int c=1; c<=C; c++){

            for (int r=1; r<=R; r++){
                if (map[r][c] != null){
                    answer += map[r][c].z;
                    sharks.remove(map[r][c]);
                    map[r][c] = null;
                    break;
                }
            }

            if (c == C)
                return;

            Shark[][] moveMap = new Shark[R + 1][C + 1];
            ArrayList<Shark> liveShark = new ArrayList<>();

            for (Shark shark : sharks){

                int dir = shark.d;
                int speed = shark.s;
                int ny = shark.r;
                int nx = shark.c;

                if (dir == 1 || dir == 2){

                    speed %= (R - 1) * 2;

                    for (int s=0; s<speed; s++) {

                        if (ny == 1)
                            dir = 2;

                        if (ny == R)
                            dir = 1;

                        ny += dy[dir];
                    }
                }

                if (dir == 3 || dir == 4){

                    speed %= (C - 1) * 2;

                    for (int s=0; s<speed; s++){

                        if (nx == 1)
                            dir = 3;

                        if (nx == C)
                            dir = 4;

                        nx += dx[dir];
                    }
                }

                shark.r = ny;
                shark.c = nx;
                shark.d = dir;

                if (moveMap[shark.r][shark.c] != null){
                    Shark in = moveMap[shark.r][shark.c];

                    if (in.z < shark.z){
                        moveMap[shark.r][shark.c] = shark;
                        liveShark.add(shark);
                        liveShark.remove(in);
                    }
                } else {
                    moveMap[shark.r][shark.c] = shark;
                    liveShark.add(shark);
                }
            }

            map = moveMap;
            sharks = liveShark;
        }
    }
}
