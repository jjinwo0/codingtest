package hw.day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 결과 : 정답입니다!!
 * 메모리 : 14972KB
 * 실행시간 : 144ms
 *
 * 접근방법
 * -- 고슴도치가 비버의 굴을 찾아가는 최단 경로를 구하는 문제이므로 BFS로 풀이하는 것이 적절하다 판단하였음.
 * -- 물과 고슴도치는 동일하게 한 턴에 상,하,좌,우 한 칸씩 이동할 수 있음
 * -- 고슴도치는 물("*")이 있는 곳으로 이동하지 못함.
 * -- 따라서, 다음 턴에 물이 차는 곳은 고슴도치가 이동할 수 없음.
 * -- 이에 따르면 먼저 물이 이동하게 될 경로에 * 문자를 찍어두고, 이후 고슴도치가 이동하면서 해당 좌표 값이 .인지 *인지 확인하면 될 것 같다고 판단함.
 * -- 만약 비버의 굴에 도착하게 되면 answer의 값을 바꾸게 되고, 도착하지 못하면 answer이 변하지 않으므로 KAKTUS를 출력하게 됨.
 *
 * @author 박진우
 */
public class Main_3055_탈출_박진우 {

    static int R, C, answer;
    static String[][] map;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    static boolean[][] check;
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Node> rain = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        check = new boolean[R][C];
        answer = -1;

        for (int i=0; i<R; i++){
            String[] put = br.readLine().split("");

            for (int j=0; j<C; j++){
                map[i][j] = put[j];

                if (map[i][j].equals("S")) {
                    queue.add(new Node(i, j, 0));
                }

                if (map[i][j].equals("*")){
                    rain.add(new Node(i, j, 0));
                }
            }
        }

        bfs();

        System.out.println(answer == -1 ? "KAKTUS" : answer);
    }

    private static void bfs() {

        while(!queue.isEmpty()){

            wideRain();

            int size = queue.size();
            for (int n=0; n<size; n++) {
                Node node = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nY = node.y + dY[i];
                    int nX = node.x + dX[i];

                    if (nY >= 0 && nX >= 0 && nY < R && nX < C) {

                        if (map[nY][nX].equals("D")) {
                            answer = node.move + 1;
                            return;
                        }

                        if (map[nY][nX].equals(".")) {
                            map[nY][nX] = "S";
                            queue.add(new Node(nY, nX, node.move + 1));
                        }
                    }
                }
            }
        }
    }

    private static void wideRain() {

        int length = rain.size();

        for (int r=0; r<length; r++) {

            Node rainNode = rain.poll();

            for (int i = 0; i < 4; i++) {
                int nY = rainNode.y + dY[i];
                int nX = rainNode.x + dX[i];

                if (nY >= 0 && nX >= 0 && nY < R && nX < C && map[nY][nX].equals(".")) {
                    map[nY][nX] = "*";
                    rain.add(new Node(nY, nX, rainNode.move + 1));
                }
            }
        }
    }
}

class Node {
    int y;
    int x;
    int move;

    public Node(int y, int x, int move) {
        this.y = y;
        this.x = x;
        this.move = move;
    }
}
