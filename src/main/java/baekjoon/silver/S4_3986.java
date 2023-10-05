package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int n = Integer.parseInt(br.readLine()); // 입력 횟수 정의
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<n; i++){
            String temp = String.valueOf(br.readLine()); // 문자열 입력
            stack.push(temp.charAt(0)); // 문자열의 첫 문자를 스택에 push
            for (int j=1; j<temp.length(); j++){ // 문자열의 두 번째 문자부터 확인하는 반복
                if (stack.size() == 0 || stack.peek() != temp.charAt(j))
                    // 1. 스택에 아무것도 담기지 않았을 때 || 2. stack의 최상위값과 문자열의 다음 문자가 다를 때,
                    stack.push(temp.charAt(j)); // stack에 push
                else stack.pop(); // stack의 최상위 값과 문자열의 다음 문자가 동일할 때 -> stack pop
            }
            if (stack.isEmpty()) // stack이 비어있을 때 -> 좋은 문자열
                answer++;
            stack.clear(); // 스택 초기화
        }
        System.out.println(answer);
    }
}
