package programmers.level2;

public class JadenCase {
    public String solution(String s){
        String answer = s.toLowerCase();

        if (!Character.isDigit(answer.charAt(0))){
            answer = answer.substring(0,0) + Character.toUpperCase(answer.charAt(0)) + answer.substring(1);
        }

        for (int i=1; i<answer.length(); i++){
            if (i == answer.length()-1 && answer.charAt(i) == ' ')
                return answer;
            if (answer.charAt(i) == ' '){
                answer = answer.substring(0, i+1) + Character.toUpperCase(answer.charAt(i+1)) + answer.substring(i+2);
            }
        }
        return answer;
    }
}