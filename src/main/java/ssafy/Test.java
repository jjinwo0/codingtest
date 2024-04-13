package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
    static int n;
    static String[][] graph;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new String[n][n];
        int count = 0;

        for (int i = 0; i < n; i++)
            graph[i] = br.readLine().split("");

        checked = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                checked[i][j] = false;
                if (graph[i][j].equals("R"))
                    graph[i][j] = "G";
            }
        }

        System.out.print(count + " ");
        count = 0;
        checked = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!checked[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.print(count);

    }

    public static void bfs(int cx, int cy) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        String c = graph[cx][cy];
        queue.offer(new int[]{cx, cy});
        int x, y;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            checked[cx][cy] = true;

            for (int i = 0; i < 4; i++) {
                x = dx[i] + poll[0];
                y = dy[i] + poll[1];

                if (x >= 0 && x < n && y >= 0 && y < n && !checked[x][y]) {
                    checked[x][y] = true;
                    if (!graph[cx][cy].equals(c))
                        break;
                }
            }
        }
    }
}
