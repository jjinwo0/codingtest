package swacademy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution1240 {

    static String[] keys = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};

    static int[] toNum(String code){
        int[] num = new int[8];
        int index = 0;

        for (int i=0; i< num.length; i++){
            String temp = code.substring(i, i+7);
            for (int j=0; j< keys.length; j++){
                if (temp.equals(keys[i])){
                    num[index++] = j;
                    break;
                }
            }
        }

        return num;
    }

    static int valid(String code){
        int[] num = toNum(code);
        int sum = 0;
        int total = 0;

        for (int i=0; i< num.length; i++){
            sum += num[i];
            if (i % 2 == 0) total += num[i]*3;
            else total += num[i];
        }

        if (total % 10 == 0)
            return sum;

        return 0;
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            String code = "";
            for (int i = 0; i < n; i++) {
                String s = sc.next();

                if (code.isEmpty()) {
                    for (int j = m - 1; j >= 0; j--) {
                        if (s.charAt(j) == '1') {
                            code = s.substring(j - 55, j + 1);
                            break;
                        }
                    }
                }
            }
            System.out.println("#" + test_case + " " + valid(code));
        }
    }
}
