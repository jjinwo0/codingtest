import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_6 {

    static int[][] matrix;
    static boolean[][] visited;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++){
            String[] split = br.readLine().split("");
            for (int j=0; j<n; j++){
                matrix[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (matrix[i][j] == 1 && !visited[i][j]){
                    list.add(dfs(i, j));
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());

        for (int i : list)
            System.out.print(i + " ");
    }

    static Integer dfs(int x, int y) {
        visited[x][y] = true;

        int area = 1;

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                if (matrix[nx][ny] == 1 && !visited[nx][ny])
                    area += dfs(nx, ny);
            }
        }

        return area;
    }
}
