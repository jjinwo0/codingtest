package programmers.level2;

import java.util.Stack;

public class CorrectBracket {
    public boolean solution(String s){
        boolean answer = true;
        Stack<Character> bracket = new Stack<>();

        if (s.charAt(0) == ')' || s.charAt(s.length()-1) == '(')
            return false;

        bracket.add('(');

        for (int i=1; i<s.length(); i++){
            if (s.charAt(i) == '(')
                bracket.push(s.charAt(i));
            else{
                if (bracket.size() == 0)
                    return false;
                else
                    bracket.pop();
            }
        }
        if (bracket.size() != 0)
            answer = false;

        return answer;
    }
}
