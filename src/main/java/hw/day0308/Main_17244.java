package hw.day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17244 {

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;

    static char[][] map;

    static int[] start, end;

    static boolean[][][] visited;

    static ArrayList<Node> target;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        start = new int[2];
        end = new int[2];
        target = new ArrayList<>();

        for (int i=0; i<N; i++){
            char[] chars = br.readLine().toCharArray();

            for (int j=0; j<M; j++){
                map[i][j] = chars[j];

                if (map[i][j] == 'S')
                    start[0] = i; start[1] = j;

                if (map[i][j] == 'E')
                    end[0] = i; end[1] = j;

                if (map[i][j] == 'X')
                    target.add(new Node(i, j));
            }
        }
    }
}
