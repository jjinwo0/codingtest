package ssafy.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 결과 : 100점
 * 메모리 : 14652KB
 * 시간 : 116ms
 *
 * 접근 방법
 * -- 시작 사각형이 어디인지 입력값을 바탕으로 정하여 모든 반복되는 경우를 직접 구현하였습니다.
 *
 * @author 박진우
 */
public class Main_20187 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        int n = (int)Math.pow(2, k);

        int[][] paper = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] flip = new String[k * 2];

        String lastWidth = "";
        String lastHeight = "";

        for (int i=0; i< flip.length; i++){
            flip[i] = st.nextToken();

            if (flip[i].equals("D") || flip[i].equals("U"))
                lastHeight = flip[i];

            if (flip[i].equals("L") || flip[i].equals("R"))
                lastWidth = flip[i];
        }

        int dot = Integer.parseInt(br.readLine());

        int startX = 0;
        int startY = 0;


        if (lastHeight.equals("U")){
            if (lastWidth.equals("L")){
                startX = 0;
                startY = 0;

                if (dot == 0){
                    for (int i=startY; i<n; i+=2){
                        for (int j=startX; j<n; j+=2){
                            paper[i][j] = dot;
                            paper[i][j+1] = 1;
                            paper[i+1][j] = 2;
                            paper[i+1][j+1] = 3;
                        }
                    }
                }

                if (dot == 1){
                    for (int i=startY; i<n; i+=2){
                        for (int j=startX; j<n; j+=2){
                            paper[i][j] = dot;
                            paper[i][j+1] = 0;
                            paper[i+1][j] = 3;
                            paper[i+1][j+1] = 2;
                        }
                    }
                }

                if (dot == 2){
                    for (int i=startY; i<n; i+=2){
                        for (int j=startX; j<n; j+=2){
                            paper[i][j] = dot;
                            paper[i][j+1] = 3;
                            paper[i+1][j] = 0;
                            paper[i+1][j+1] = 1;
                        }
                    }
                }

                if (dot == 3){
                    for (int i=startY; i<n; i+=2){
                        for (int j=startX; j<n; j+=2){
                            paper[i][j] = dot;
                            paper[i][j+1] = 2;
                            paper[i+1][j] = 1;
                            paper[i+1][j+1] = 0;
                        }
                    }
                }
            }
            if (lastWidth.equals("R")){
                startX = n-1;
                startY = 0;

                if (dot == 0){
                    for (int i=startY; i<n; i+=2){
                        for (int j=startX; j>=0; j-=2){
                            paper[i][j] = dot;
                            paper[i][j-1] = 1;
                            paper[i+1][j] = 2;
                            paper[i+1][j-1] = 3;
                        }
                    }
                }

                if (dot == 1){
                    for (int i=startY; i<n; i+=2){
                        for (int j=startX; j>=0; j-=2){
                            paper[i][j] = dot;
                            paper[i][j-1] = 0;
                            paper[i+1][j] = 3;
                            paper[i+1][j-1] = 2;
                        }
                    }
                }

                if (dot == 2){
                    for (int i=startY; i<n; i+=2){
                        for (int j=startX; j>=0; j-=2){
                            paper[i][j] = dot;
                            paper[i][j-1] = 3;
                            paper[i+1][j] = 0;
                            paper[i+1][j-1] = 1;
                        }
                    }
                }

                if (dot == 3){
                    for (int i=startY; i<n; i+=2){
                        for (int j=startX; j>=0; j-=2){
                            paper[i][j] = dot;
                            paper[i][j-1] = 2;
                            paper[i+1][j] = 1;
                            paper[i+1][j-1] = 0;
                        }
                    }
                }
            }
        }

        if (lastHeight.equals("D")){
            if (lastWidth.equals("L")){
                startX = 0;
                startY = n-1;

                if (dot == 0){
                    for (int i=startY; i>=0; i-=2){
                        for (int j = startX; j < n; j += 2) {
                            paper[i][j] = dot;
                            paper[i-1][j] = 2;
                            paper[i][j+1] = 1;
                            paper[i-1][j+1] = 3;
                        }
                    }
                }

                if (dot == 1){
                    for (int i=startY; i>=0; i-=2){
                        for (int j = startX; j < n; j += 2) {
                            paper[i][j] = dot;
                            paper[i-1][j] = 3;
                            paper[i][j+1] = 0;
                            paper[i-1][j+1] = 2;
                        }
                    }
                }

                if (dot == 2){
                    for (int i=startY; i>=0; i-=2){
                        for (int j = startX; j < n; j += 2) {
                            paper[i][j] = dot;
                            paper[i-1][j] = 0;
                            paper[i][j+1] = 3;
                            paper[i-1][j+1] = 1;
                        }
                    }
                }

                if (dot == 3){
                    for (int i=startY; i>=0; i-=2){
                        for (int j = startX; j < n; j += 2) {
                            paper[i][j] = dot;
                            paper[i-1][j] = 1;
                            paper[i][j+1] = 2;
                            paper[i-1][j+1] = 0;
                        }
                    }
                }
            }
            if (lastWidth.equals("R")){
                startX = n-1;
                startY = n-1;

                if (dot == 0){
                    for (int i=startY; i>=0; i-=2){
                        for (int j=startX; j>=0; j-=2){
                            paper[i][j] = dot;
                            paper[i-1][j] = 2;
                            paper[i][j-1] = 1;
                            paper[i-1][j-1] = 3;
                        }
                    }
                }

                if (dot == 1){
                    for (int i=startY; i>=0; i-=2){
                        for (int j=startX; j>=0; j-=2){
                            paper[i][j] = dot;
                            paper[i-1][j] = 3;
                            paper[i][j-1] = 0;
                            paper[i-1][j-1] = 2;
                        }
                    }
                }

                if (dot == 2){
                    for (int i=startY; i>=0; i-=2){
                        for (int j=startX; j>=0; j-=2){
                            paper[i][j] = dot;
                            paper[i-1][j] = 0;
                            paper[i][j-1] = 3;
                            paper[i-1][j-1] = 1;
                        }
                    }
                }

                if (dot == 3){
                    for (int i=startY; i>=0; i-=2){
                        for (int j=startX; j>=0; j-=2){
                            paper[i][j] = dot;
                            paper[i-1][j] = 1;
                            paper[i][j-1] = 2;
                            paper[i-1][j-1] = 0;
                        }
                    }
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                sb.append(paper[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
