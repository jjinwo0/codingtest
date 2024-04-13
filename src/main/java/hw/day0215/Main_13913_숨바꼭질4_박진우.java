package hw.day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4_박진우 {

    static int N, K;
    static int[] parent = new int[100001];
    static int[] current = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        Stack<Integer> stack = new Stack<>();

        int index = K;
        stack.push(index);

        while(index != N){
            stack.push(parent[index]);
            index = parent[index];
        }

        sb.append(stack.size()).append("\n");
        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");

        System.out.println(sb);
    }

    private static void bfs() {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        current[N] = 1;

        while(!queue.isEmpty()){
            Integer cur = queue.poll();

            if (cur == K)
                return;

            int[] next = {cur + 1, cur - 1, cur * 2};

            for (int i=0; i<3; i++){

                if (next[i] < 0 || next[i] > 100000)
                    continue;

                if (current[next[i]] == 0){
                    queue.add(next[i]);
                    current[next[i]] = current[cur] + 1;
                    parent[next[i]] = cur;
                }
            }
        }
    }
}
