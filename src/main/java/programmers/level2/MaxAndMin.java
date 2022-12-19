package programmers.level2;

import java.util.Arrays;

public class MaxAndMin {
    public String solution(String s){
        String answer = "";
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        for (int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        answer += String.valueOf(arr[0])+" "+String.valueOf(arr[arr.length-1]);

        return answer;
    }
}
