package programmers.level1;

import java.util.*;

public class L1_둘만의암호 {
    public static void main(String[] args) {
        String solution = L1_둘만의암호.solution("aukks", "wbqd", 5);

        System.out.println(solution);
    }
    public static String solution(String s, String skip, int index){
        String answer = "";
        List<Character> list = new ArrayList<>();

        for (int i=0; i<='z'-'a'; i++){
            list.add((char)('a'+i));
        }

        for (int i=0; i<skip.length(); i++){
            list.remove(list.indexOf(skip.charAt(i)));
        }

        for (int i=0; i<s.length(); i++){
            int idx = (list.indexOf(s.charAt(i)) + index) % list.size();

            answer += list.get(idx);
        }

        return answer;
    }
}
