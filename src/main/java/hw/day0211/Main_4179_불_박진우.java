package hw.day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 72116KB
 * 시간 : 588ms
 *
 * 접근방법
 * -- 배열에 Character Type 초기값을 설정해줍니다.
 * -- 지훈이의 첫 위치와 불의 첫 위치를 기억합니다.
 *
 * -- 처음엔 지훈이가 불보다 먼저 이동한다고 판단하여 지훈이를 먼저 이동시켰습니다.
 * -- 하지만 반례가 생겨버렸고, 이에 불이 먼저 이동하는 방법으로 수정하였습니다.
 * -- BFS 방식으로 순회하면서, 지훈이가 가장자리에 도착하면 이동한 거리를 return하여 출력하였습니다.
 * -- 제출 시, 메모리 초과 문제가 발생하였습니다.
 * -- 이전엔 '.'문자로 이동 가능 여부를 판단하였지만, 이것이 바이트 수가 초과하는 것으로 판단하여 boolean type의 check 배열을 활용하여 해결하였습니다.
 *
 * @author 박진우
 */
public class Main_4179_불_박진우 {

    static int R, C, answer;
    static char[][] map;
    static Queue<Node> queue = new LinkedList<>();
    static Queue<Node> fire = new LinkedList<>();
    static boolean[][] check;
    static boolean[][] fireCheck;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = -1;

        map = new char[R][C];

        check = new boolean[R][C];
        fireCheck = new boolean[R][C];

        for (int i=0; i<R; i++){
            String input = br.readLine();

            for (int j=0; j<C; j++){
                map[i][j] = input.charAt(j);

                if (map[i][j] == 'J')
                    queue.add(new Node(i, j, 1));

                if (map[i][j] == 'F')
                    fire.add(new Node(i, j, 0));
            }
        }

        escape();

        System.out.println(answer == -1 ? "IMPOSSIBLE":answer);
    }

    private static void escape() {

        while(!queue.isEmpty()){

            int fireSize = fire.size();

            for (int s=0; s<fireSize; s++){

                Node fireNode = fire.poll();

                for (int i=0; i<4; i++){
                    int nX = fireNode.x + dX[i];
                    int nY = fireNode.y + dY[i];

                    if (nX >= 0 && nY >= 0 && nX < C && nY < R && map[nY][nX] != '#' && !fireCheck[nY][nX]) {
                        fireCheck[nY][nX] = true;
                        map[nY][nX] = 'F';
                        fire.add(new Node(nY, nX, fireNode.move + 1));
                    }
                }
            }

            int size = queue.size();

            for (int s=0; s<size; s++) {

                Node jihoon = queue.poll();

                if (jihoon.x == 0 || jihoon.y == 0 || jihoon.x == C-1 || jihoon.y == R-1) {
                    answer = jihoon.move;
                    return;
                }

                for (int i=0; i<4; i++){
                    int nX = jihoon.x + dX[i];
                    int nY = jihoon.y + dY[i];

                    if (nX >= 0 && nY >= 0 && nX < C && nY < R && map[nY][nX] == '.' && !check[nY][nX]) {

                        if (nX == C - 1 || nY == R - 1 || nX == 0 || nY == 0) {
                            map[nY][nX] = 'J';
                            answer = jihoon.move + 1;
                            return;
                        }

                        check[nY][nX] = true;
                        map[nY][nX] = 'J';
                        queue.add(new Node(nY, nX, jihoon.move + 1));
                    }
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    int move;

    public Node(int y, int x, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
