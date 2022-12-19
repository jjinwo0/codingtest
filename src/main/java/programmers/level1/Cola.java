package programmers.level1;

public class Cola {
    public int solution(int a, int b, int n){
        int answer = 0;
        int num = n;

        while(num > 0){
            answer += (num/a*b);
            num = num - ((num/a) * a) + (num/a*b);
            if (num/a <= 0)
                break;
        }

        return answer;
    }
}