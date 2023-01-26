package programmers.level2;

//incomplete
public class Carpet {
    public int[] solution(int brown, int yellow){
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int i=1; i<=total/2; i++){
            int mkyel = 0;
            if(total%i==0)
                mkyel = total/i;
            else continue;

            if (total % i != 0){
                continue;
            }
            if (total/mkyel >= mkyel){
                answer[0] = i;
                answer[1] = mkyel;
                break;
            }
        }

        return answer;
    }
}
