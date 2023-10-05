package univ;

import java.util.Scanner;

public class Week5_Ex01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String plans = sc.nextLine();
        int x = 1, y = 1;
        int nx = 0, ny = 0;

        // L, R, U, D
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] move_types = {'L', 'R', 'U', 'D'};

        for (int i=0; i<plans.length(); i++){

            char one = plans.charAt(i);

            for (int j=0; j<move_types.length; j++){

                if (one == move_types[j]){
                    nx = x + dx[j];
                    ny = y + dy[j];
                }

                if (nx < 1 || ny < 1 || nx > n || ny > n)
                    continue;

                x = nx;
                y = ny;
            }
        }

        System.out.println(x + " " + y);
    }
}
