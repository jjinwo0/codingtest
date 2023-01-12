package programmers.level2;

public class ExpNumber {

    public int solution(int n){
        int answer = 0;
        int num = 1;
        while(num <= n) {
            int temp = 0;
            for (int i = num; i <= n; i++) {
                temp += i;
                if (temp == n){
                    answer++;
                    break;
                }else if(temp > n){
                    break;
                }
            }
            num++;
        }

        return answer;
    }
}
