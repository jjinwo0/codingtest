package programmers.level1;

public class SimpleKeyboard {
    public int[] solution(String[] keymap, String[] targets){
        int[] answer = new int[targets.length];

        for (int i=0; i<targets.length; i++){

            String temp = targets[i];
            int count = 0;

            for (int n=0; n<temp.length(); n++){

                String alpha = temp.substring(i - 1, i);


            }
        }

        return answer;
    }
}
