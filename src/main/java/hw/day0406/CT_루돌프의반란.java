package hw.day0406;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class CT_루돌프의반란 {

        static class Rudolph {
            int r;
            int c;

            public Rudolph(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }

        static class Santa {

            int r;
            int c;
            boolean isAlive;
            int score;
            int time;

            public Santa(int r, int c, boolean isAlive, int score, int time) {
                this.r = r;
                this.c = c;
                this.isAlive = isAlive;
                this.score = score;
                this.time = time;
            }
        }

        static int N, M, P, C, D;

        static Rudolph rudolph;

        static Santa[] santaArr;

        static int[][] map;

        static int[] dc = {0, 1, 0, -1, 1, 1, -1, -1};
        static int[] dr = {-1, 0, 1, 0, 1, -1, 1, -1};

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            santaArr = new Santa[P + 1];

            st = new StringTokenizer(br.readLine());

            rudolph = new Rudolph(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

            for (int i=0; i<P; i++){
                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;

                santaArr[num - 1] = new Santa(r, c, true, 0, -2);
                map[r][c] = num;
            }

            for (int i=0; i<M; i++){
                mvRudolph(i);
                mvSanta(i);

                if (bonusScore() == 0)
                    break;
            }

            for (int i=0; i<P; i++){
                sb.append(santaArr[i].score).append(" ");
            }

            System.out.println(sb);
    }

    private static void mvRudolph(int time) {

        int minDist = Integer.MAX_VALUE;
        int crashSanta = -1;

        // 부딪힐 산타 찾기
        for (int i=0; i<P; i++){
            if (!santaArr[i].isAlive) //이미 죽은 산타는 넘김
                continue;

            int dist = (int) Math.pow(santaArr[i].r - rudolph.r, 2) + (int) Math.pow(santaArr[i].c - rudolph.c, 2);

            if (crashSanta == -1) {
                minDist = dist;
                crashSanta = i;
                continue;
            }

            if (dist > minDist){
                continue;
            }

            if (dist == minDist){

                if (santaArr[i].r < santaArr[crashSanta].r)
                    continue;

                if (santaArr[i].r > santaArr[crashSanta].r) {
                    crashSanta = i;
                    continue;
                }

                if (santaArr[i].r == santaArr[crashSanta].r && santaArr[i].c > santaArr[crashSanta].c)
                    crashSanta = i;

                continue;
            }

            minDist = dist;
            crashSanta = i;
        }


        int nr = santaArr[crashSanta].r - rudolph.r;
        int nc = santaArr[crashSanta].c - rudolph.c;
        int direction = 0;

        if(nr == 0 || nc == 0) {
            for (int k = 0; k < 4; k++) {
                if (nr * dr[k] > 0 && nc * dc[k] > 0) {
                    direction = k;
                    break;
                }
            }
        } else {
            for (int k = 4; k < 8; k++) {
                if (nr * dr[k] > 0 && nc * dc[k] > 0) {
                    direction = k;
                    break;
                }
            }
        }

        rudolph.r += dr[direction];
        rudolph.c += dc[direction];

        // 산타를 만났을 때
        if (map[rudolph.r][rudolph.c] > 0)
            crash(map[rudolph.r][rudolph.c] - 1, direction, C, time);
    }

    private static void crash(int santa, int direction, int score, int time) {

        map[santaArr[santa].r][santaArr[santa].c] = 0;

        santaArr[santa].score += score;
        santaArr[santa].time = time;

        int nr = santaArr[santa].r + score * dr[direction];
        int nc = santaArr[santa].c + score * dc[direction];

        if (nr >= 0 && nc >= 0 && nr < N && nc < N){

            santaArr[santa].r = nr;
            santaArr[santa].c = nc;

            if (map[nr][nc] == 0){
                map[nr][nc] = santa + 1;
                return;
            }

            // TODO 상호작용하는 산타 확인
            interact(santa, nr, nc, direction);
        }

        else
            santaArr[santa].isAlive = false;
    }

    private static void mvSanta(int time){

        for (int i=0; i<P; i++){
            if (!santaArr[i].isAlive)
                continue;

            // 기절 산타 제외
            if (santaArr[i].time + 2 > time)
                continue;

            int minDist = (int) Math.pow(santaArr[i].r - rudolph.r, 2) + (int) Math.pow(santaArr[i].c - rudolph.c, 2);
            int direction = -1;

            for (int k=0; k<4; k++){
                int nr = santaArr[i].r + dr[k];
                int nc = santaArr[i].c + dc[k];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] == 0){
                    int distance = (int) Math.pow(nr - rudolph.r, 2) + (int) Math.pow(nc - rudolph.c, 2);

                    if (minDist > distance){
                        minDist = distance;
                        direction = k;
                    }
                }
            }

            if (direction == -1)
                continue;

            int nextRow = santaArr[i].r + dr[direction];
            int nextCol = santaArr[i].c + dc[direction];

            map[santaArr[i].r][santaArr[i].c] = 0;

            santaArr[i].r = nextRow;
            santaArr[i].c = nextCol;

            map[nextRow][nextCol] = i + 1;

            if (nextRow == rudolph.r && nextCol == rudolph.c)
                crash(i, (direction + 2) % 4, D, time);
        }
    }

    private static void interact(int santa, int r, int c, int direction) {

        int lastSantaNum = map[r][c] - 1;
        map[r][c] = santa + 1;

        r += dr[direction];
        c += dc[direction];

        if (r >= 0 && c >= 0 && r < N && c < N){

            santaArr[lastSantaNum].r = r;
            santaArr[lastSantaNum].c = c;

            if (map[r][c] == 0){
                map[r][c] = lastSantaNum + 1;
                return;
            }

            interact(santa, r, c, direction);
        }

        else
            santaArr[lastSantaNum].isAlive = false;
    }

    // 탈락하지 않은 산타들 추가점수
    static int bonusScore() {
        int count = 0;

        for (int i = 0; i < P; i++) {
            if (santaArr[i].isAlive) {
                santaArr[i].score++;
                count++;
            }
        }

        return count;
    }
}

/*
5 7 4 2 2
3 2
1 1 3
2 3 5
3 5 1
4 4 4
 */