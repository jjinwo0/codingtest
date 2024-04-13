package ssafy.exam;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        if (input.equals("A"))
            printAlpha();

        if (input.equals("*"))
            printStar();
    }

    private static void printStar() {

        for (int i=0; i<5; i++){

            for (int l=0; l<i; l++){
                System.out.print("  ");
            }

            for (int out=0; out<5-i; out++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void printAlpha() {
        int num = 0;

        for (int i=0; i<5; i++){

            for (int l=0; l<i; l++){
                System.out.print("  ");
            }

            for (int out=0; out<2*(5-i)-1; out++){
                System.out.print((char)((num%26) + 'A') + " ");
                num++;
            }

            System.out.println();
        }
    }
}
