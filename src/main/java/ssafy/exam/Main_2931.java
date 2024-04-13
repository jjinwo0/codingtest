package ssafy.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2931 {

    static char[][] map;

    static int R, C;

    static ArrayList<int[]> breakPoint = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i=0; i<R; i++){
            char[] chars = br.readLine().toCharArray();
            for (int j=0; j<C; j++){
                map[i][j] = chars[j];
            }
        }

        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                check(map[i][j], i, j);
            }
        }

        if (breakPoint.size() > 2) {
            sb.append(breakPoint.get(0)[0] + 1).append(" ").append(breakPoint.get(0)[1] + 1).append(" ").append("+");
            System.out.println(sb);
            return;
        }

        if (breakPoint.size() == 2){
            int[] nodeA = breakPoint.get(0);
            int[] nodeB = breakPoint.get(1);

            if (Math.abs(nodeA[0] - nodeB[0]) == 2) {
                sb.append(breakPoint.get(0)[0] + 2).append(" ").append(breakPoint.get(0)[1] + 1).append(" ").append("|");
                System.out.println(sb);
                return;
            }

            if (Math.abs(nodeA[1] - nodeB[1]) == 2) {
                sb.append(breakPoint.get(0)[0] + 1).append(" ").append(breakPoint.get(0)[1] + 2).append(" ").append("-");
                System.out.println(sb);
                return;
            }

            if (Math.abs(nodeA[0] - nodeB[0]) == 1){

                if (map[nodeA[0]][nodeA[1]] == '-') {
                    if (map[nodeA[0]][nodeA[1] - 1] == '.') {
                        if (map[nodeB[0]][nodeB[1]] == '1') {
                            sb.append(breakPoint.get(0)[0]).append(" ").append(breakPoint.get(0)[1] + 1).append(" ").append("1");
                            System.out.println(sb);
                            return;
                        }
                    }
                    if (map[nodeA[0]][nodeA[1] + 1] == '.') {
                        if (map[nodeB[0]][nodeB[1]] == '1') {
                            sb.append(breakPoint.get(0)[0] + 2).append(" ").append(breakPoint.get(0)[1] + 1).append(" ").append("4");
                            System.out.println(sb);
                            return;
                        }
                    }
                }

                if (map[nodeA[0]][nodeA[1]] == '|') {
                    if (map[nodeB[0]][nodeB[1]] == '3' || map[nodeB[0]][nodeB[1]] == '4' || map[nodeB[0]][nodeB[1]] == '-'){
                        sb.append(breakPoint.get(0)[0] + 2).append(" ").append(breakPoint.get(0)[1] + 1).append(" ").append("2");
                        System.out.println(sb);
                        return;
                    }

                    if (map[nodeB[0]][nodeB[1]] == '1' || map[nodeB[0]][nodeB[1]] == '2' || map[nodeB[0]][nodeB[1]] == '-'){
                        sb.append(breakPoint.get(0)[0] + 2).append(" ").append(breakPoint.get(0)[1] + 1).append(" ").append("3");
                        System.out.println(sb);
                        return;
                    }
                }

                if (map[nodeA[0]][nodeA[1]] == '1' || map[nodeA[0]][nodeA[1]] == '4'){
                    if (map[nodeB[0]][nodeB[1]] == '1') {
                        sb.append(breakPoint.get(0)[0] + 2).append(" ").append(breakPoint.get(0)[1] + 1).append(" ").append("3");
                        System.out.println(sb);
                        return;
                    }

                    if (map[nodeB[0]][nodeB[1]] == '2') {
                        sb.append(breakPoint.get(0)[0] + 1).append(" ").append(breakPoint.get(0)[1] + 2).append(" ").append("3");
                        System.out.println(sb);
                        return;
                    }

                    if (map[nodeB[0]][nodeB[1]] == '3') {
                        sb.append(breakPoint.get(0)[0] + 1).append(" ").append(breakPoint.get(0)[1] + 2).append(" ").append("2");
                        System.out.println(sb);
                        return;
                    }

                    if (map[nodeB[0]][nodeB[1]] == '4') {
                        sb.append(breakPoint.get(0)[0] + 1).append(" ").append(breakPoint.get(0)[1] + 2).append(" ").append("2");
                        System.out.println(sb);
                        return;
                    }
                }

                if (map[nodeA[0]][nodeA[1]] == '2'){
                    sb.append(breakPoint.get(0)[0] + 1).append(" ").append(breakPoint.get(0)[1] + 2).append(" ").append("4");
                    System.out.println(sb);
                    return;
                }

                if (map[nodeA[0]][nodeA[1]] == '3'){
                    sb.append(breakPoint.get(0)[0] + 1).append(" ").append(breakPoint.get(0)[1] + 2).append(" ").append("1");
                    System.out.println(sb);
                    return;
                }
            }
        }
    }

    private static void check(char ch, int r, int c) {

        if (ch == '-'){
            if (c-1 >= 0 && map[r][c-1] == '.')
                breakPoint.add(new int[]{r, c});

            if (c+1 < C && map[r][c+1] == '.')
                breakPoint.add(new int[]{r, c});
        }

        if (ch == '|'){
            if (r-1 >= 0 && map[r-1][c] == '.')
                breakPoint.add(new int[]{r, c});

            if (r+1 < R && map[r+1][c] == '.')
                breakPoint.add(new int[]{r, c});
        }

        if (ch == '+'){

            if (c-1 >= 0 && map[r][c-1] == '.'){

                breakPoint.add(new int[]{r, c});
            }

            if (c+1 < C && map[r][c+1] == '.'){

                breakPoint.add(new int[]{r, c});
            }

            if (r-1 >= 0 && map[r-1][c] == '.'){

                breakPoint.add(new int[]{r, c});
            }

            if (r+1 < R && map[r+1][c] == '.'){

                breakPoint.add(new int[]{r, c});
            }
        }

        if (ch == '1'){
            if (c+1 < C && map[r][c+1] == '.'){
                breakPoint.add(new int[]{r, c});
            }

            if (r+1 < R && map[r+1][c] == '.'){
                breakPoint.add(new int[]{r, c});
            }
        }

        if (ch == '2'){
            if (c+1 < C && map[r][c+1] == '.'){
                breakPoint.add(new int[]{r, c});
            }

            if (r-1 >= 0 && map[r-1][c] == '.'){
                breakPoint.add(new int[]{r, c});
            }
        }

        if (ch == '3'){
            if (c-1 >= 0 && map[r][c-1] == '.'){
                breakPoint.add(new int[]{r, c});
            }

            if (r-1 >= 0 && map[r-1][c] == '.'){
                breakPoint.add(new int[]{r, c});
            }
        }

        if (ch == '4'){
            if (c-1 >= 0 && map[r][c-1] == '.'){
                breakPoint.add(new int[]{r, c});
            }

            if (r+1 < R && map[r+1][c] == '.'){
                breakPoint.add(new int[]{r, c});
            }
        }
    }
}
