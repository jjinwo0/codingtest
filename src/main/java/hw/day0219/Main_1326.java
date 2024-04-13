package hw.day0219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1326 {

    static int[] bridge;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        bridge = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        answer = 0;
        if (a < b){
            bfs(a, b);
        } else bfs(b, a);
    }

    private static void bfs(int a, int b) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(bridge[a-1]);

        while(!queue.isEmpty()){

            Integer poll = queue.poll();
            answer++;

            for (int i=poll; i<b; i+=poll){

                if (i == b-1){
                    System.out.println(answer);

                    return;
                }

                if (i + poll > b){

                    if (b - poll < 0){
                        System.out.println(-1);
                        return;
                    }

                    queue.offer(bridge[i]);
                    break;
                }
            }
        }
    }
}
