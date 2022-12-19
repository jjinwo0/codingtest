package programmers.level1;

import java.util.ArrayList;

public class NotSameNumber {
    public ArrayList<Integer> solution(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i=1; i<arr.length; i++){
            if (arr[i-1] != arr[i])
                list.add(arr[i]);
        }

        return list;
    }
}
