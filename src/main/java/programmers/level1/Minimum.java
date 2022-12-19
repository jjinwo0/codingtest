package programmers.level1;

import java.util.ArrayList;

public class Minimum {
    public ArrayList<Integer> solution(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int min = arr[0];
        if (arr.length == 1){
            answer.add(-1);
            return answer;
        }

        for (int i=0; i<arr.length; i++){
            answer.add(arr[i]);
        }
        for (int i=1; i<arr.length; i++){
            if (min>arr[i])
                min = arr[i];
        }
        answer.remove(answer.indexOf(min));

        return answer;
    }
}
