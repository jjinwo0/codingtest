package programmers.level1;

public class CloseCharacter {

    public int[] solution(String s){
        int[] answer = new int[s.length()];
        for (int a=0; a< answer.length; a++){
            answer[a] = -1;
        }

        for (int i=1; i< answer.length; i++){
            for (int j=0; j<i; j++){
                if (s.charAt(i) == s.charAt(j))
                    answer[i] = i-j;
            }
        }

        return answer;
    }
}
