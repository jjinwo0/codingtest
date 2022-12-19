package programmers.level1;

public class Weapon {
    public int solution(int number, int limit, int power){
        int answer = 0;
        int[] arr = new int[number];
        for (int i=1; i<=number; i++){
            arr[i-1] = 0;
            for (int j=1; j<=i; j++){
                if (i%j==0)
                    arr[i-1]++;
            }
            if (arr[i-1] > limit)
                arr[i-1] = power;
            answer += arr[i-1];
        }

        return answer;
    }
}
