package programmers.toss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public int solution(String s, int N) {
        int answer = -1;

        int len = s.length();
        for (int i = len; i >= N; i--) {
            List<Integer> digits = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int num = Character.getNumericValue(s.charAt(j));
                if (num > i || digits.contains(num)) {
                    break;
                }
                digits.add(num);
            }
            if (digits.size() == i && !digits.contains(0)) {
                Collections.sort(digits, Collections.reverseOrder());
                int pandigital = 0;
                for (int digit : digits) {
                    pandigital = pandigital * 10 + digit;
                }
                answer = Math.max(answer, pandigital);
            }
        }

        return answer;
    }
}
