package programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class Printer {
    public int solution(int[] priorities, int location){
        int answer = 0;
        int cnt = 0;

        Stack<Paper> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<priorities.length; i++){
            Paper paper = new Paper(priorities[i], i);
            stack.add(paper);
            list.add(priorities[i]);
        }

        list.sort(Comparator.reverseOrder());
        int max = list.get(0);

        while(!stack.isEmpty()){
            Paper p = stack.firstElement();
            stack.remove(0);

            if (max == p.prior){
                list.remove(0);
                list.sort(Comparator.reverseOrder());
                if (!stack.isEmpty())
                    max = list.get(0);

                cnt++;

                if (p.loc == location)
                    answer = cnt;
            }else
                stack.add(p);
        }

        return answer;
    }

    class Paper{
        int prior;
        int loc;

        public Paper(int prior, int loc) {
            this.prior = prior;
            this.loc = loc;
        }
    }
}
