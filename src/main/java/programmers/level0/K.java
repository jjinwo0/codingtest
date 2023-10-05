package programmers.level0;

import java.util.Arrays;
import java.util.Optional;

public class K {
    public int solution(int i, int j, int k){
        int answer = 0;
        for (int a=i; a<j; a++){
            String[] arr = String.valueOf(a).split("");
            Optional<String> any = Arrays.stream(arr)
                    .filter(n -> n.equals(String.valueOf(k)))
                    .findAny();
            if (any.isPresent())
                answer++;
        }

        return answer;
    }
}
