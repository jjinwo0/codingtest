package hw.day0220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5373 {
    /**
     * [0] : U 윗면
     * [1] : D 아랫면
     * [2] : F 앞면
     * [3] : B 뒷면
     * [4] : L 왼쪽면
     * [5] : R 오른쪽면
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int tc=0; tc<n; tc++){
            char[][][] cube = {
                    {
                            {'w', 'w', 'w'},
                            {'w', 'w', 'w'},
                            {'w', 'w', 'w'}
                    },
                    {
                            {'y', 'y', 'y'},
                            {'y', 'y', 'y'},
                            {'y', 'y', 'y'}
                    },
                    {
                            {'r', 'r', 'r'},
                            {'r', 'r', 'r'},
                            {'r', 'r', 'r'}
                    },
                    {
                            {'o', 'o', 'o'},
                            {'o', 'o', 'o'},
                            {'o', 'o', 'o'}
                    },
                    {
                            {'g', 'g', 'g'},
                            {'g', 'g', 'g'},
                            {'g', 'g', 'g'}
                    },
                    {
                            {'b', 'b', 'b'},
                            {'b', 'b', 'b'},
                            {'b', 'b', 'b'}
                    }
            };

            int cnt = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i=0; i<cnt; i++){

                String[] input = st.nextToken().split("");

                changeCube(cube, input[0], input[1]);
            }

            for (int i=0; i<cube[0].length; i++){
                for (int j=0; j<cube[0][i].length; j++){
                    sb.append(cube[0][i][j]);
                }
                sb.append("\n");
            }

        }
        System.out.println(sb);
    }

    private static void changeCube(char[][][] cube, String location, String direction) {

        char temp, temp2;
        char[] tempArr = new char[3];
        char[] tempArr2 = new char[3];

        // 윗면
        if (location.equals("U")){

            // 윗면 시계방향
            if (direction.equals("+")){
                temp = cube[0][0][0];
                cube[0][0][0] = cube[0][2][0];

                temp2 = cube[0][0][2];
                cube[0][0][2] = temp;

                temp = cube[0][2][2];
                cube[0][2][2] = temp2;

                cube[0][2][0] = temp;

                //====================//

                temp = cube[0][0][1];
                cube[0][0][1] = cube[0][1][0];

                temp2 = cube[0][1][2];
                cube[0][1][2] = temp;

                temp = cube[0][2][1];
                cube[0][2][1] = temp2;

                cube[0][1][0] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[5][0][i];
                    cube[5][0][i] = cube[3][0][i];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[2][0][i];
                    cube[2][0][i] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[4][0][i];
                    cube[4][0][i] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[3][0][i] = tempArr[i];
                }
            }

            // 윗면 시계반대방향
            if (direction.equals("-")){
                temp = cube[0][0][0];
                cube[0][0][0] = cube[0][0][2];

                temp2 = cube[0][2][0];
                cube[0][2][0] = temp;

                temp = cube[0][2][2];
                cube[0][2][2] = temp2;

                cube[0][0][2] = temp;

                //====================//

                temp = cube[0][0][1];
                cube[0][0][1] = cube[0][1][2];

                temp2 = cube[0][1][0];
                cube[0][1][0] = temp;

                temp = cube[0][2][1];
                cube[0][2][1] = temp2;

                cube[0][1][2] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[5][0][i];
                    cube[5][0][i] = cube[2][0][i];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[3][0][i];
                    cube[3][0][i] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[4][0][i];
                    cube[4][0][i] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[2][0][i] = tempArr[i];
                }

            }
        }

        // 아래
        if (location.equals("D")){
            // 아래 시계방향
            if (direction.equals("+")){
                temp = cube[1][0][0];
                cube[1][0][0] = cube[1][2][0];

                temp2 = cube[1][0][2];
                cube[1][0][2] = temp;

                temp = cube[1][2][2];
                cube[1][2][2] = temp2;

                cube[1][2][0] = temp;

                //====================//

                temp = cube[1][0][1];
                cube[1][0][1] = cube[1][1][0];

                temp2 = cube[1][1][2];
                cube[1][1][2] = temp;

                temp = cube[1][2][1];
                cube[1][2][1] = temp2;

                cube[1][1][0] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[5][2][i];
                    cube[5][2][i] = cube[2][2][i];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[3][2][i];
                    cube[3][2][i] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[4][2][i];
                    cube[4][2][i] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[2][2][i] = tempArr[i];
                }

            }

            // 아래 시계 반대방향
            if (direction.equals("-")){
                temp = cube[1][0][0];
                cube[1][0][0] = cube[1][0][2];

                temp2 = cube[1][2][0];
                cube[1][2][0] = temp;

                temp = cube[1][2][2];
                cube[1][2][2] = temp2;

                cube[1][0][2] = temp;

                //====================//

                temp = cube[1][0][1];
                cube[1][0][1] = cube[1][1][2];

                temp2 = cube[1][1][0];
                cube[1][1][0] = temp;

                temp = cube[1][2][1];
                cube[1][2][1] = temp2;

                cube[1][1][2] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[5][2][i];
                    cube[5][2][i] = cube[3][2][i];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[2][2][i];
                    cube[2][2][i] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[4][2][i];
                    cube[4][2][i] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[3][2][i] = tempArr[i];
                }

            }

        }

        // 앞면
        if (location.equals("F")){

            // 앞면 시계방향
            if (direction.equals("+")){
                temp = cube[2][0][0];
                cube[2][0][0] = cube[2][2][0];

                temp2 = cube[2][0][2];
                cube[2][0][2] = temp;

                temp = cube[2][2][2];
                cube[2][2][2] = temp2;

                cube[2][2][0] = temp;

                //====================//

                temp = cube[2][0][1];
                cube[2][0][1] = cube[2][1][0];

                temp2 = cube[2][1][2];
                cube[2][1][2] = temp;

                temp = cube[2][2][1];
                cube[2][2][1] = temp2;

                cube[2][1][0] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[0][2][i];
                    cube[0][2][i] = cube[4][2-i][2];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[5][i][0];
                    cube[5][i][0] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[1][0][2-i];
                    cube[1][0][2-i] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[4][i][2] = tempArr[i];
                }

            }

            // 앞면 반시계방향
            if (direction.equals("-")){
                temp = cube[2][0][0];
                cube[2][0][0] = cube[2][0][2];

                temp2 = cube[2][2][0];
                cube[2][2][0] = temp;

                temp = cube[2][2][2];
                cube[2][2][2] = temp2;

                cube[2][0][2] = temp;

                //====================//

                temp = cube[2][0][1];
                cube[2][0][1] = cube[2][1][2];

                temp2 = cube[2][1][0];
                cube[2][1][0] = temp;

                temp = cube[2][2][1];
                cube[2][2][1] = temp2;

                cube[2][1][2] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[0][2][i];
                    cube[0][2][i] = cube[5][i][0];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[4][2-i][2];
                    cube[4][2-i][2] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[1][0][i];
                    cube[1][0][i] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[5][2-i][0] = tempArr[i];
                }

            }
        }

        // 뒷면
        if (location.equals("B")){
            // 뒷면 시계방향
            if (direction.equals("+")){
                temp = cube[3][0][0];
                cube[3][0][0] = cube[3][2][0];

                temp2 = cube[3][0][2];
                cube[3][0][2] = temp;

                temp = cube[3][2][2];
                cube[3][2][2] = temp2;

                cube[3][2][0] = temp;

                //====================//

                temp = cube[3][0][1];
                cube[3][0][1] = cube[3][1][0];

                temp2 = cube[3][1][2];
                cube[3][1][2] = temp;

                temp = cube[3][2][1];
                cube[3][2][1] = temp2;

                cube[3][1][0] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[0][0][i];
                    cube[0][0][i] = cube[5][i][2];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[4][2-i][0];
                    cube[4][2-i][0] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[1][2][i];
                    cube[1][2][i] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[5][2-i][2] = tempArr[i];
                }
            }

            // 뒷면 반시계방향
            if (direction.equals("-")){
                temp = cube[3][0][0];
                cube[3][0][0] = cube[3][0][2];

                temp2 = cube[3][2][0];
                cube[3][2][0] = temp;

                temp = cube[3][2][2];
                cube[3][2][2] = temp2;

                cube[3][0][2] = temp;

                //====================//

                temp = cube[3][0][1];
                cube[3][0][1] = cube[3][1][2];

                temp2 = cube[3][1][0];
                cube[3][1][0] = temp;

                temp = cube[3][2][1];
                cube[3][2][1] = temp2;

                cube[3][1][2] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[0][0][i];
                    cube[0][0][i] = cube[4][2-i][0];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[5][i][2];
                    cube[5][i][2] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[1][2][2-i];
                    cube[1][2][2-i] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[4][i][0] = tempArr[i];
                }

            }
        }

        // 왼쪽
        if (location.equals("L")){

            // 왼쪽 시계방향
            if (direction.equals("+")){
                temp = cube[4][0][0];
                cube[4][0][0] = cube[4][2][0];

                temp2 = cube[4][0][2];
                cube[4][0][2] = temp;

                temp = cube[4][2][2];
                cube[4][2][2] = temp2;

                cube[4][2][0] = temp;

                //====================//

                temp = cube[4][0][1];
                cube[4][0][1] = cube[4][1][0];

                temp2 = cube[4][1][2];
                cube[4][1][2] = temp;

                temp = cube[4][2][1];
                cube[4][2][1] = temp2;

                cube[4][1][0] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[0][i][0];
                    cube[0][i][0] = cube[3][2-i][2];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[2][i][0];
                    cube[2][i][0] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[1][i][0];
                    cube[1][i][0] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[3][2-i][2] = tempArr[i];
                }

            }

            // 왼쪽 반시계방향
            if (direction.equals("-")){
                temp = cube[4][0][0];
                cube[4][0][0] = cube[4][0][2];

                temp2 = cube[4][2][0];
                cube[4][2][0] = temp;

                temp = cube[4][2][2];
                cube[4][2][2] = temp2;

                cube[4][0][2] = temp;

                //====================//

                temp = cube[4][0][1];
                cube[4][0][1] = cube[4][1][2];

                temp2 = cube[4][1][0];
                cube[4][1][0] = temp;

                temp = cube[4][2][1];
                cube[4][2][1] = temp2;

                cube[4][1][2] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[0][i][0];
                    cube[0][i][0] = cube[2][i][0];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[3][2-i][2];
                    cube[3][2-i][2] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[1][2-i][0];
                    cube[1][2-i][0] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[2][i][0] = tempArr[i];
                }

            }

        }

        // 오른쪽 면
        if (location.equals("R")){

            // 오른쪽면 시계방향
            if (direction.equals("+")){
                temp = cube[5][0][0];
                cube[5][0][0] = cube[5][2][0];

                temp2 = cube[5][0][2];
                cube[5][0][2] = temp;

                temp = cube[5][2][2];
                cube[5][2][2] = temp2;

                cube[5][2][0] = temp;

                //====================//

                temp = cube[5][0][1];
                cube[5][0][1] = cube[5][1][0];

                temp2 = cube[5][1][2];
                cube[5][1][2] = temp;

                temp = cube[5][2][1];
                cube[5][2][1] = temp2;

                cube[5][1][0] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[0][i][2];
                    cube[0][i][2] = cube[2][i][2];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[3][2-i][0];
                    cube[3][2-i][0] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[1][2-i][2];
                    cube[1][2-i][2] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[2][i][2] = tempArr[i];
                }

            }

            if (direction.equals("-")){
                temp = cube[5][0][0];
                cube[5][0][0] = cube[5][0][2];

                temp2 = cube[5][2][0];
                cube[5][2][0] = temp;

                temp = cube[5][2][2];
                cube[5][2][2] = temp2;

                cube[5][0][2] = temp;

                //====================//

                temp = cube[5][0][1];
                cube[5][0][1] = cube[5][1][2];

                temp2 = cube[5][1][0];
                cube[5][1][0] = temp;

                temp = cube[5][2][1];
                cube[5][2][1] = temp2;

                cube[5][1][2] = temp;

                //====================//

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[0][i][2];
                    cube[0][i][2] = cube[3][2-i][0];
                }

                for (int i=0; i<3; i++){
                    tempArr2[i] = cube[2][i][2];
                    cube[2][i][2] = tempArr[i];
                }

                for (int i=0; i<3; i++){
                    tempArr[i] = cube[1][i][2];
                    cube[1][i][2] = tempArr2[i];
                }

                for (int i=0; i<3; i++){
                    cube[3][2-i][0] = tempArr[i];
                }

            }

        }
    }
}