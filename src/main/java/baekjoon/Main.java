package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        int temp = 0;

        for (int i=0; i<n; i++){
            int val = sc.nextInt();

            if (val > temp){
                for (int j=temp+1; j<=val; j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                temp = val;
            }else if(stack.peek() != val){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}
