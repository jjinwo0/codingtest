package programmers.level1;

public class Dart {
    public int solution(String dartResult){
        int answer = 0;
        int temp = 0;
        String[] arr = dartResult.split("");

        for (int i=0; i<arr.length; i++){
            if (Integer.parseInt(arr[i]) >= 1 && Integer.parseInt(arr[i]) <= 9 ) {
                if (i+1 < arr.length && Integer.parseInt(arr[i+1]) == 0) {
                    temp = 10;
                    i++; continue;
                }
                temp = Integer.parseInt(arr[i]);
            }
            if (arr[i].equals("S")) {
                answer += temp;
            }
            if (arr[i].equals("D")) {
                temp = temp * temp;
                answer += temp;
            }
            if (arr[i].equals("T")) {
                temp = temp * temp * temp;
                answer += temp;
            }
            if (arr[i].equals("*"))
                answer *= 2;
            if (arr[i].equals("#"))
                answer -= temp * 2;
        }

        return answer;
    }
}
