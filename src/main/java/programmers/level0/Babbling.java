package programmers.level0;

public class Babbling {

    public int solution(String[] babbling){
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        for (int i=0; i< babbling.length; i++){
            for (String str : arr){
                if (babbling[i].contains(str)){
                    babbling[i] = babbling[i].replace(str, "0");
                }
            }
            babbling[i] = babbling[i].replace("0", "");
            if (babbling[i].length() == 0){
                answer++;
            }
        }
        return answer;
    }
}
