package programmers.level2;

public class BinaryCycle {
    public int[] solution(String s){
        int[] answer = {1, 1};
        String str = s;
        while(str.length() > 1){
            int temp = 0;
            for (int i=0; i<str.length(); i++){
                if (str.charAt(i) == '0')
                    temp++;
            }
            answer[0]++;
            answer[1] += temp;
            str = Integer.toBinaryString(temp);
            System.out.println(str);
        }
        return answer;
    }
}
