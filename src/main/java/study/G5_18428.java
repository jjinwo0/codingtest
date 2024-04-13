package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 15936KB
 * 시간 : 148ms
 *
 * 접근방법
 * -- 선생님의 위치를 체크합니다.
 * -- 3개의 칸에 벽을 세웠다고 가정하고, 해당 벽이 세워졌을 때, 선생님에게 학생이 안들킬 수 있는지 확인합니다.
 * -- 만약 들키지 않는 벽이 완성됐다면, YES를 출력하고 마칩니다.
 *
 * @author 박진우
 */
public class G5_18428 {
    static String[][] map;
    static ArrayList<int[]> teachers;
    static String answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        teachers = new ArrayList<>();
        map = new String[N][N];
        answer = "NO";

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++){
                map[i][j] = st.nextToken();

                if (map[i][j].equals("T"))
                    teachers.add(new int[]{i, j});
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int path) {

        if (path == 3){
            if (check())
                answer = "YES";
            return;
        }

        for (int i=0; i<map.length; i++){
            for (int j=0; j<map[i].length; j++){
                if (map[i][j].equals("X")) {
                    map[i][j] = "O";
                    dfs(path+1);
                    map[i][j] = "X";
                }
            }
        }
    }

    private static boolean check() {

        for (int i=0; i< teachers.size(); i++){

            int[] loc = teachers.get(i);

            for (int n = loc[0]-1; n >= 0; n--) {
                if (map[n][loc[1]].equals("O"))
                    break;

                if (map[n][loc[1]].equals("S"))
                    return false;
            }

            for (int n=loc[0]+1; n<map.length; n++){
                if (map[n][loc[1]].equals("O"))
                    break;

                if (map[n][loc[1]].equals("S"))
                    return false;
            }

            for (int n = loc[1]-1; n >= 0; n--) {
                if (map[loc[0]][n].equals("O"))
                    break;

                if (map[loc[0]][n].equals("S"))
                    return false;
            }

            for (int n=loc[1]+1; n<map[0].length; n++){
                if (map[loc[0]][n].equals("O"))
                    break;

                if (map[loc[0]][n].equals("S"))
                    return false;
            }
        }

        return true;
    }
}
