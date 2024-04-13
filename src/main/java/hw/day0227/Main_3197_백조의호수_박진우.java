package hw.day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 213212KB
 * 시간 : 844ms
 *
 * 접근 방법
 * -- 백조의 위치를 배열에 저장합니다.
 * -- 백조가 현재 움직일 수 있는 위치를 location 큐에 담습니다.
 * -- 다음 날 물이 녹을 부분을 체크하기 위해 물이 아닌 부분을 melt 큐에 담아줍니다.
 * -- bfs 순회를 돌면서, 현재 백조가 움직일 수 있는 구간을 탐색합니다.
 * -- 만약 다음 움직일 위치가 X(얼음)라면, 다음 턴데 녹았을 때 백조가 이동할 수 있도록 저장합니다.
 * -- 만약 다음 움직일 위치가 얼음이 아니라면, 현재 이동 가능한 위치이므로 location 큐에 저장합니다.
 * -- 만약 지금 상태에서 백조가 서로 만나지 못한다면, 방금 전 저장한 얼음 위치 큐를 location 큐에 넣어줍니다.
 * -- 얼음을 녹이면서 반복하고, 만났을 때의 day를 출력합니다.
 *
 * @author 박진우
 */
public class Main_3197_백조의호수_박진우 {

    static char[][] map;

    static int R, C;

    static boolean[][] visited;

    static int[] dX = {1, 0, -1, 0};

    static int[] dY = {0, 1, 0, -1};

    static int[][] swan = new int[2][2];

    static Queue<int[]> location = new LinkedList<>();

    static Queue<int[]> melt = new LinkedList();

    static int day;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        day = 0;

        map = new char[R][C];
        visited = new boolean[R][C];

        int index = 0;

        for(int i=0; i<R; i++) {

            map[i] = br.readLine().toCharArray();

            for(int j=0; j<C; j++) {
                if(map[i][j] == 'L') {

                    swan[index][0] = i; swan[index][1] = j;
                    index++;
                }

                if (map[i][j] == '.' || map[i][j] == 'L') // 수정된 부분
                    melt.offer(new int[]{i, j});
            }
        }

        location.offer(new int[]{swan[0][0], swan[0][1]});
        visited[swan[0][0]][swan[0][1]] = true;

        while(!bfs()){

            nextDay();

            day++;
        }

        System.out.println(day);
    }


    private static boolean bfs() {

        Queue<int[]> queue = new LinkedList<>();

        while(!location.isEmpty()){

            int[] poll = location.poll();

            int y = poll[0];
            int x = poll[1];

            for (int i=0; i<4; i++){
                int nY = y + dY[i];
                int nX = x + dX[i];

                if (nY >= 0 && nX >= 0 && nY < R && nX < C && !visited[nY][nX]){

                    visited[nY][nX] = true;

                    if (nY == swan[1][0] && nX == swan[1][1])
                        return true;

                    if (map[nY][nX] == 'X')
                        queue.add(new int[]{nY, nX});

                    else location.add(new int[]{nY, nX});
                }
            }
        }

        location = queue;
        return false;
    }

    // 얼음을 녹이는 동작
    private static void nextDay() {

        int size = melt.size();

        for (int i=0; i<size; i++){

            int[] poll = melt.poll();

            int y = poll[0];
            int x = poll[1];

            for (int k=0; k<4; k++){
                int nY = y + dY[k];
                int nX = x + dX[k];

                // 물에 인접한 얼음이라면,
                if (nY >= 0 && nX >= 0 && nY < R && nX < C && map[nY][nX] == 'X'){
                    map[nY][nX] = '.';
                    melt.add(new int[]{nY, nX});
                }
            }
        }
    }
}
