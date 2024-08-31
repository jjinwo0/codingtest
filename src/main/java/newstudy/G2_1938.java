package newstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G2_1938 {

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Wood {

        int y;
        int x;
        int dir;
        int time;

        public Wood(int y, int x, int dir, int time) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.time = time;
        }
    }

    static int N;

    static char[][] map;

    static Node[] start, end;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        start = new Node[3];
        end = new Node[3];

        int startIndex = 0;
        int endIndex = 0;

        for (int i=0; i<N; i++){
            String str = br.readLine();

            for (int j=0; j<str.length(); j++){
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'B')
                    start[startIndex++] = new Node(i, j);

                if (map[i][j] == 'E')
                    end[endIndex++] = new Node(i, j);
            }
        }

        int answer = bfs();
    }

    private static int bfs() {

        Queue<Wood> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[2][N][N];

        int dir = 0;

        if (start[0].y + 1 != start[1].y)
            dir = 1;

        queue.offer(new Wood(start[0].y, start[0].x, dir, 0));
        visited[dir][start[0].y][start[0].x] = true;

        while(!queue.isEmpty()){

            Wood wood = queue.poll();

            if (wood.y == end[1].y && wood.x == end[1].x){

                if ((wood.dir == 0 && map[wood.y][wood.x - 1] == 'E' && map[wood.y][wood.x + 1] == 'E') ||
                        (wood.dir == 1 && map[wood.y - 1][wood.x] == 'E' && map[wood.y + 1][wood.x] == 'E'))
                    return wood.time;
            }

            for (int i=0; i<4; i++){

                int ny = wood.y + dy[i];
                int nx = wood.x + dx[i];

                if (!canMove(ny, nx, wood.dir, i))
                    continue;

                if (visited[dir][ny][nx])
                    continue;

                visited[dir][ny][nx] = true;
                queue.offer(new Wood(ny, nx, wood.dir, wood.time + 1));
            }

            if (canRotate(wood.y, wood.x)){

                // 통나무가 가로일 때
                if(dir == 0 && !visited[1][wood.y][wood.x]) {
                    visited[1][wood.y][wood.x] = true;
                    queue.add(new Wood(wood.y, wood.x, 1, wood.time + 1));
                }
                // 통나무가 세로일 때
                else if(dir == 1 && !visited[0][wood.y][wood.x]) {
                    visited[0][wood.y][wood.x] = true;
                    queue.add(new Wood(wood.y, wood.x, 0, wood.time + 1)); // 방향 바꿔서 넣어줌
                }
            }
        }
        
        return 0;
    }

    private static boolean canRotate(int y, int x) {

        for (int i=y-1; i<=y+1; i++){

            for (int j=x-1; j<=x+1; j++){

                if (i < 0 || j < 0 || i >= N || j >= N)
                    return false;

                if (map[i][j] == '1')
                    return false;
            }
        }

        return true;
    }

    private static boolean canMove(int y, int x, int dir, int i) {

        if (dir == 0){

            if (i < 2){

                if (y < 0 || y >= N)
                    return false;

                if (map[y][x] == '1' || map[y][x-1] == '1' || map[y][x+1] == '1')
                    return false;
            } else {

                if (x - 1 < 0 || x + 1 >= N)
                    return false;

                if (map[y][x] == '1' || map[y][x-1] == '1' || map[y][x+1] == '1')
                    return false;
            }
        } else {

            if (i < 2){

                if (y - 1 < 0 || y + 1 >= N)
                    return false;

                if (map[y][x] == '1' || map[y-1][x] == '1' || map[y+1][x] == '1')
                    return false;
            } else {

                if (x < 0 || x >= N)
                    return false;

                if (map[y][x] == '1' || map[y-1][x] == '1' || map[y+1][x] == '1')
                    return false;
            }
        }

        return true;
    }
}
