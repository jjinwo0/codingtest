package programmers.level1;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Solution.solution("abracadabra"));
    }

    public static int solution(String s) {
    int answer = 0;
    char c, tmp;
    int eq = 1, ne = 0;

    for (int i = 1; i < s.length(); i++) {
        c = s.charAt(0);
        tmp = s.charAt(i);
        if (c == tmp)
            eq++;
        else
            ne++;

        if (eq == ne) {
            s = s.substring(eq + ne);
            eq = 1;
            ne = 0;
            answer++;
            i = 0;

            if (s.length() < 2)
                break;
        }
    }

    return s.length() > 0 ? answer + 1 : answer;
}
}
