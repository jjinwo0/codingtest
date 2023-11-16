package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_2644 {

    static int end, answer = -1;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 전체 사람 수
        int n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        // 두 사람의 번호
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        // 관계 개수
        int m = Integer.parseInt(br.readLine());


    }
}
