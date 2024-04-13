package hw.day0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 결과 : 정답
 * 메모리 : 18,584 kb
 * 실행시간 : 104 ms
 *
 * @author 박진우
 */
public class D4_1218_괄호짝짓기_박진우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case=1; test_case<=10; test_case++){
            int length = Integer.parseInt(br.readLine());
            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Character> stack = new Stack<>();

            char[] str = br.readLine().toCharArray();

            for (int i=0; i<length; i++){

                char temp = str[i];

                // 열린 괄호가 들어오면 무조건 push
                if (temp == '(' || temp == '[' || temp == '{' || temp == '<') {
                    stack.push(temp);
                    continue;
                }

                // 열린 괄호가 아닌데 stack이 비어있으면 뒤를 확인하지 않아도 됨
                // 이후는 앞서 stack에 담긴 괄호와 입력한 괄호 모양이 일치하지 않을 때의 조건
                if (stack.isEmpty() ||
                        (temp == ']' && stack.peek() != '[') ||
                        (temp == '}' && stack.peek() != '{') ||
                        (temp == ')' && stack.peek() != '(') ||
                        (temp == '>' && stack.peek() != '<')){
                    break;
                }

                if (temp == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }

                if (temp == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                }

                if (temp == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }

                if (temp == '>' && stack.peek() == '<') {
                    stack.pop();
                }
            }

            if (stack.isEmpty())
                answer = 1;

            System.out.println("#"+test_case+" "+answer);
        }
    }
}
