package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class StringSort {
    public String[] solution(String[] strings, int n){
        String[] answer = new String[strings.length];
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));
        for (int i=0; i<answer.length; i++){
            for (int j=0; j<list.size()-1; j++){
                String temp = "";
                if (list.get(i).charAt(n) > list.get(i+1).charAt(n)){
                    temp = list.get(i+1);
                }
            }
        }
        return answer;
    }
}
