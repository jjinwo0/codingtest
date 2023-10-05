package baekjoon.silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class S5_1181 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String arr[]  = new String[N];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
        }

        // 1.길이순으로, 2.사전순으로
        Arrays.sort(arr,new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                } else {
                    return s1.length() - s2.length();
                }
            }
        });

        // 중복제거
        System.out.println(arr[0]);
        for (int i = 1; i < N; i++) {
            if (arr[i].equals(arr[i-1])) continue;
            System.out.println(arr[i]);
        }
    }
}
