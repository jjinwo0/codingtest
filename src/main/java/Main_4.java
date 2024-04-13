import java.util.Scanner;

public class Main_4 {

    static int m;
    static int[] maxValues;
    static int[] curValues;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();

        if (m < 1 || m > 8){
            System.out.println(-1);
            return;
        }

        maxValues = new int[m];
        curValues = new int[m];

        for (int i=0; i<m; i++){
            maxValues[i] = sc.nextInt();
        }

        for (int i=0; i<m; i++){
            curValues[i] = sc.nextInt();

            if (curValues[i] < 0 || curValues[i] > maxValues[i]){
                System.out.println(-1);
                return;
            }
        }

        int clicks = sc.nextInt();

        for (int i=0; i<clicks; i++){
            click();
        }

        for (int i=0; i<m; i++){
            System.out.print(curValues[i]);
        }
        System.out.println();
    }

    static void click() {

        for (int i=m-1; i >= 0; i--){
            if (curValues[i] < maxValues[i]){
                curValues[i]++;
                break;
            }else {
                curValues[i] = 0;
                if (i == 0) break;
            }
        }
    }
}
