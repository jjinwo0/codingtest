package programmers.level1;

public class NumbersAndAlphabet {
    public int solution(String s){
        int answer = 0;
        String temp = "";
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i=0; i< num.length; i++){
            s = s.replace(num[i], Integer.toString(i));
        }
        answer = Integer.getInteger(s);

        return answer;
    }
}
