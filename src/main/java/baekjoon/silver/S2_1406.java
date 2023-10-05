package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        String str = br.readLine();

        for (int i=str.length()-1; i>=0; i--){
            stack.push(String.valueOf(str.charAt(i)));
        }

        int cursor = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            // new StringTokenizer(문자열, 구분자, true/false); -> true: 구분자도 토큰으로 포함 / false : 구분자는 미포함 (default)
            StringTokenizer st = new StringTokenizer(br.readLine(), " ", false);

            String s1 = st.nextToken();
            if (s1.equals("P")){
                String s2 = st.nextToken();

                stack.add(cursor, s2);
            }
            if (s1.equals("L") && cursor < stack.size())
                cursor++;
            if (s1.equals("D") && cursor > 0)
                cursor--;
            if (s1.equals("B") && cursor < stack.size())
                stack.remove(cursor);
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
