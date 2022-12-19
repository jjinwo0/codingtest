package programmers.level2;

import java.util.Arrays;

public class MakeLowNum {
    public int solution(int[] A, int[] B){
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i=0; i<A.length; i++){
            int temp = B.length-i-1;
            answer += A[i] * B[temp];
        }

        return answer;
    }
}
