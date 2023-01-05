package programmers.level1;


import java.util.Arrays;

public class StringSort {
    public String[] solution(String[] strings, int n){
        String[] answer = new String[strings.length];
        for (int i=0; i<strings.length; i++){
            String temp = strings[i].substring(n, n+1);
            strings[i] = temp + strings[i];
        }

        Arrays.sort(strings);
        for (int i=0; i< answer.length; i++){
            answer[i] = strings[i].substring(1);
        }

        return answer;
    }
}
