package programmers.level2;

import java.util.Stack;

public class RemovePair {

    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++){
            if (!stack.isEmpty() && stack.peek() == s.charAt(i))
                stack.pop();
            else{
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty())
            answer = 1;

        return answer;
    }
}