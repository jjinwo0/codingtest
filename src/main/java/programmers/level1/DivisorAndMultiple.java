package programmers.level1;

import java.util.ArrayList;

public class DivisorAndMultiple {
    public int[] solution(int n, int m){
        int[] answer = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        int num, max;
        if (n<m) num = m;
        else num = n;

        for (int i=1; i<=num; i++){
            if (n%i == 0 && m%i==0)
                list.add(i);
        }
        answer[0] = list.get(list.size()-1);
        answer[1] = n * m / answer[0];

        return answer;
    }
}
