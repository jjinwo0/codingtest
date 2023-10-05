package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class S3_12789 {

    static int start = 1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> line = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            line.offer(Integer.parseInt(st.nextToken()));
        }

        while (!line.isEmpty()){

            if (line.peek() == start){
                line.poll();
                start++;
            }
            if (!stack.isEmpty() && stack.peek() == start){
                stack.pop();
                start++;
            }
            else
                stack.push(line.poll());
        }

        while (!stack.isEmpty()){

            if (stack.peek() == start){
                stack.pop();
                start++;
            }else {
                System.out.println("Sad");
                return ;
            }
        }

        System.out.println("Nice");
    }
}
