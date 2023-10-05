package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S4_28278 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int menu = Integer.parseInt(st.nextToken());

            switch (menu){
                case 1:
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if (!stack.isEmpty())
                        sb.append(stack.pop()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if (stack.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case 5:
                    if (!stack.isEmpty()) sb.append(stack.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
