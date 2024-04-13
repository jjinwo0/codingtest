package ssafy.Atype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100 {

    static int N, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;

        map = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        play(0);
        System.out.println(answer);
    }

    private static void play(int count) {
        if (count == 5) {
            findAnswer();
            return;
        }

        int[][] copyMap = new int[N][N];

        for (int i = 0; i < N; i++)
            copyMap[i] = map[i].clone();

        for (int i = 0; i < 4; i++) {
            move(i);
            play(count + 1);

            for (int k = 0; k < N; k++)
                map[k] = copyMap[k].clone();
        }
    }

    private static void move(int dir) {

        boolean[][] combined = new boolean[N][N]; // 이미 합쳐진 타일을 추적하기 위한 배열

        switch (dir) {
            case 0:
                for (int j = 0; j < N; j++) {
                    int idx = 0; // 합쳐지거나 이동할 위치
                    for (int i = 1; i < N; i++) {
                        if (map[i][j] == 0) continue; // 0은 무시
                        int temp = map[i][j];
                        map[i][j] = 0;
                        if (map[idx][j] == 0) { // 이동할 위치가 비어있으면 이동
                            map[idx][j] = temp;
                        } else if (map[idx][j] == temp && !combined[idx][j]) { // 같은 숫자이고 아직 합쳐지지 않았으면 합치기
                            map[idx][j] *= 2;
                            combined[idx][j] = true; // 합쳐짐 표시
                        } else { // 다른 숫자이거나 이미 합쳐진 경우
                            map[++idx][j] = temp;
                        }
                    }
                }
                break;
            case 1:
                for (int j = 0; j < N; j++) {
                    int[] line = new int[N];
                    int idx = N-1;
                    for (int i = N-1; i >= 0; i--) {
                        if (map[i][j] == 0) continue;
                        if (line[idx] == 0 || line[idx] != map[i][j]) {
                            line[idx] = map[i][j];
                        } else {
                            line[idx--] *= 2;
                            line[idx] = 0;
                        }

                        int next = i - 1;
                        while (next >= 0 && map[next][j] == 0) next--;
                        if (next >= 0 && map[next][j] != map[i][j]) idx--;
                        i = next + 1;
                    }
                    for (int i = 0; i < N; i++) map[i][j] = line[i];
                }
                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    int[] line = new int[N];
                    int idx = N-1;
                    for (int j = N-1; j >= 0; j--) {
                        if (map[i][j] == 0) continue;
                        if (map[i][j] == 0) continue;
                        if (line[idx] == 0 || line[idx] != map[i][j]) {
                            line[idx] = map[i][j];
                        } else {
                            line[idx--] *= 2;
                            line[idx] = 0;
                        }

                        int next = j - 1;
                        while (next >= 0 && map[i][next] == 0) next--;
                        if (next >= 0 && map[i][next] != map[i][j]) idx--;
                        j = next + 1;
                    }
                    for (int j = 0; j < N; j++) map[i][j] = line[j];
                }
                break;
            case 3:
                for (int i = 0; i < N; i++) {
                    int[] line = new int[N];
                    int idx = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == 0) continue;
                        if (line[idx] == 0 || line[idx] != map[i][j]) {
                            line[idx] = map[i][j];
                        } else {
                            line[idx++] *= 2;
                            line[idx] = 0;
                        }

                        int next = j + 1;
                        while (next < N && map[i][next] == 0) next++;
                        if (next < N && map[i][next] != map[i][j]) idx++;
                        j = next - 1;
                    }
                    for (int j = 0; j < N; j++) map[i][j] = line[j];
                }
                break;
        }
    }

    private static void findAnswer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }
    }
}
