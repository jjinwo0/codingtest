package programmers.level1;

public class SmallerSubString {
    public int solution(String t, String p){
        int answer = 0;
        for (int i=0; i<t.length()-p.length()+1; i++){
            Long tInt = Long.parseLong(t.substring(i, (i+p.length())));

            if (tInt <= Long.parseLong(p))
                answer++;
        }

        return answer;
    }
}
