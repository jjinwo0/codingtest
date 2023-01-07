package programmers.level2;

public class BinaryCycle {
    public int[] solution(String s){
        int[] answer = {0, 0};
        String str = s;
        while(str.length() > 1){
            int temp = 0;
            for (int i=0; i<s.length(); i++){
                if (s.charAt(i) == '0')
                    temp++;
            }
            str = Integer.toBinaryString(s.length()-temp);
            answer[0]++;
            answer[1] += temp;
        }
        return answer;
    }
}