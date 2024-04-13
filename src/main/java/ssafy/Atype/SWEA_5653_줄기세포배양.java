package ssafy.Atype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653_줄기세포배양 {

    static class Cell {
        int y;
        int x;
        int act; // 활성
        int time;

        public Cell(int y, int x, int act, int time) {
            this.y = y;
            this.x = x;
            this.act = act;
            this.time = time;
        }
    }

    static int[][] map;

    static boolean[][] live;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            map = new int[N+(K*2)+1][M+(K*2)+1];
            live = new boolean[N+(K*2)+1][M+(K*2)+1];

            ArrayList<Cell> cellList = new ArrayList<>();

            for (int i=K; i<K+N; i++){

                st = new StringTokenizer(br.readLine());
                for (int j=K; j<K+M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] != 0){
                        cellList.add(new Cell(i, j, map[i][j] * 2, map[i][j]));
                        live[i][j] = true;
                    }
                }
            }

            bfs(cellList, K);

            int score = check();

            sb.append("#").append(tc).append(" ").append(score).append("\n");
        }

        System.out.println(sb);
    }

    private static int check() {

        int temp = 0;

        for (int i=0; i<live.length; i++){
            for (int j=0; j<live[i].length; j++){
                if (live[i][j])
                    temp += 1;
            }
        }

        return temp;
    }

    private static void bfs(ArrayList<Cell> cellList, int time) {

        Queue<Cell> queue = new LinkedList<>();
        Queue<Cell> active = new LinkedList<>();

        for (Cell cell : cellList) {
            queue.add(cell);
        }

        while(time > 0){

            time--;

            int size = active.size();

            for (int i=0; i<size; i++) {

                Cell activeCell = active.poll();

                if (activeCell.time == activeCell.act) {
                    for (int k = 0; k < 4; k++) {
                        int ny = activeCell.y + dy[k];
                        int nx = activeCell.x + dx[k];

                        if (map[ny][nx] == 0) {
                            map[ny][nx] = activeCell.time;

                            active.offer(new Cell(ny, nx, activeCell.time * 2, activeCell.time));
                            live[ny][nx] = true;
                        }
                    }
                }

                activeCell.act -= 1;

                if (activeCell.act == 0) {
                    live[activeCell.y][activeCell.x] = false;
                    continue;
                }

                active.offer(activeCell);
            }

            int qsize = queue.size();

            for (int i=0; i<qsize; i++) {
                Cell cell = queue.poll();

                cell.act -= 1;

                if (cell.act == cell.time){

                    active.offer(cell);
                    continue;
                }

                queue.offer(cell);
            }
        }
    }
}
