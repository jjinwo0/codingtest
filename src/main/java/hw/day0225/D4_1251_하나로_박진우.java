package hw.day0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class D4_1251_하나로_박진우 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static boolean[] visited;

    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = Integer.parseInt(br.readLine());

            for (int i=0; i<N; i++){
                graph.add(new ArrayList<>());
            }

            visited = new boolean[N];
            D = new int[N];

            Arrays.fill(D, Integer.MAX_VALUE);


        }
    }
}
