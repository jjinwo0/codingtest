package programmers.level2;

import java.util.Arrays;
import java.util.List;

public class FollowUp {
    public int[] solution(int n, String[] words){
        int[] answer = {0, 0};

        List<String> list = Arrays.asList(words);

        for (int i=0; i<list.size()-1; i++){
            if (list.get(i).equals(list.get(list.size()-1)))
                break;
            if (i == list.size()-1)
                return answer;
        }
        answer[0] = (words.length%n)+1;
        answer[1] = words.length/n;
        return answer;
    }
}
