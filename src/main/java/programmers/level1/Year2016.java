package programmers.level1;

public class Year2016 {
    public String solution(int a, int b){
        String answer = "";
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int before = 0;
        for (int i=0; i<a-1; i++){
            before += month[i];
        }
        before += b-1;
        answer = day[before % 7];

        return answer;
    }
}
