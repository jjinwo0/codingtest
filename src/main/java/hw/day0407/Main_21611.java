package hw.day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_21611 {

    static int N, M, answer;

    static int[][] map;

    static int[] direction, len;

    static int[] dx = {0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int[] next = {0, 3, 4, 1, 2};

    static int[][] location;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        direction = new int[M];
        len = new int[M];
        location = new int[N+M][2];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            direction[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
        }

        setMarble();

        start();

        System.out.println(answer);
    }

    private static void setMarble() {

        int r = N / 2;
        int c = N / 2;
        int cur = 3, dist = 1, n = 1;

        while(true) {
            for (int k=0; k<2; k++){
                for (int i = 0; i < dist; i++) {

                    if (r == 0 && c == 0)
                        return;

                    int nr = r + dy[cur];
                    int nc = c + dx[cur];

                    location[n][0] = nr;
                    location[n][1] = nc;

                    n += 1;

                    r = nr; c = nc;
                }

                cur = next[cur];
            }

            dist += 1;
        }
    }

    private static void start() {

        for (int i = 0; i < M; i++) {

            popMarble(direction[i], len[i]);

            moveMarvle();
            
            while(true){
                
                if (!isBomb())
                    break;
                
                else 
                    moveMarvle();
            }
        }
        
        splitMap();
    }

    private static void splitMap() {

        int newMap[][] = new int[N][N];

        int cnt = 1;
        int num = 1;
        int nr=0; int nc=0;
        for (int i = 1; i < N * N; i++) {
            int nrc = location[i][0];
            int ncc = location[i][1];
            if(map[nrc][ncc]==0)
                break;
            if(i!=N*N-1) {
                nr = location[i + 1][0];
                nc = location[i + 1][1];
            }
            if (i!=N*N-1 && map[nrc][ncc] == map[nr][nc]) {
                cnt++;
            } else {
                if(num>=N*N)
                    break;
                int newx = location[num][0];
                int newy = location[num][1];
                num++;
                if(num>=N*N)
                    break;
                int newx2 = location[num][0];
                int newy2 = location[num][1];
                num++;
                newMap[newx][newy] = cnt;
                newMap[newx2][newy2] = map[nrc][ncc];
                cnt = 1;

            }
        }
        map = copy(newMap);
    }

    private static int[][] copy(int[][] map) {

        int data[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                data[i][j] = map[i][j];
        }
        return data;
    }

    private static boolean isBomb() {
        int r = N / 2;
        int c = N / 2;

        int cur = 3;
        int dist = 1;
        int count = 0;

        ArrayList<int[]> same = new ArrayList<>();
        boolean flag = false; // 폭발 여부

        while(true){

            if (r == 0 && c == 0)
                break;

            for (int k = 0; k < 2; k++) {

                for (int i = 0; i < dist; i++) {

                    if (r == 0 && c == 0)
                        return flag;

                    int nr = r + dy[cur];
                    int nc = c + dx[cur];

                    if (count == 0 && map[r][c] != 0 && map[r][c] == map[nr][nc]){

                        count += 2;

                        same.add(new int[]{r, c});
                        same.add(new int[]{nr, nc});
                    } else if (count != 0 && map[r][c] != 0 && map[r][c] == map[nr][nc]){
                        count += 1;

                        same.add(new int[]{nr, nc});
                    }

                    if (map[r][c] != map[nr][nc]) {

                        if (count >= 4) {

                            flag = true;

                            for (int j=0; j<same.size(); j++){

                                int[] current = same.get(j);

                                int ncr = current[0];
                                int ncc = current[1];

                                answer += map[ncr][ncc];
                                map[ncr][ncc] = 0;
                            }
                        }

                        count = 0;
                        same.clear();
                    }

                    r = nr;
                    c = nc;
                }

                cur = next[cur];
            }

            dist++;
        }

        return flag;
    }

    private static void moveMarvle() {

        for (int i = 1; i < N * N; i++) {
            int nr = location[i][0];
            int nc = location[i][1];
            if (map[nr][nc] == 0) {
                int[] nextLocation = find(i);
                if (nextLocation != null) { // find 함수가 null을 반환할 수 있는 경우를 대비
                    int r = nextLocation[0];
                    int c = nextLocation[1];
                    map[nr][nc] = map[r][c]; // 이전 위치를 새 위치의 값으로 설정
                    map[r][c] = 0; // 새 위치를 0으로 설정
                }
            }
        }
    }
        private static int[] find(int num) { // 칸 번호에 해당하는 X, Y 좌표 반환
        int loc[] = new int[2];
        
        for (int i = num + 1; i < N * N; i++) {
            int nr = location[i][0];
            int nc = location[i][1];
            
            if (map[nr][nc] != 0) {
                
                loc[0] = nr;
                loc[1] = nc;
                break;
            }
        }
        return loc;
    }

    private static void popMarble(int dir, int len) {

        int nr = N / 2;
        int nc = N / 2;

        for (int i=0; i<len; i++){
            nr += dy[dir];
            nc += dx[dir];

            if (nr >= 0 && nc >= 0 && nr < N && nc < N)
                map[nr][nc] = 0;
        }
    }

}
