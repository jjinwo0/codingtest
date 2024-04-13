package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2468 {
    static int N;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int maxHeight = 0;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > maxHeight) {
                    maxHeight =map[i][j];
                }
            }
        }

        int max = 0;

        for(int height=0; height<maxHeight+1; height++) {
            check = new boolean[N][N];
            int cnt=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    // 2. 안전 영역 탐지
                    if(!check[i][j] && map[i][j] > height){
                        cnt+=dfs(i,j,height); // 해당 안전영역 탐색 시작
                    }

                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    static int dfs(int x, int y, int height) {

        check[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x +dx[i];
            int ny = y +dy[i];

            if(nx<0 || ny<0 || nx>N-1 || ny >N-1) continue;
            if(check[nx][ny]) continue;
            if(map[nx][ny]> height) {
                dfs(nx,ny, height);
            }
        }
        return 1;
    }
}
