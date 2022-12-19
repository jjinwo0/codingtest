package programmers.level1;

public class StringHandling {

    public boolean solution(String s){
        char[] arr = s.toCharArray();
        if (s.length() == 4 || s.length() == 6){
            for (int i=0; i<arr.length; i++){
                if (!Character.isDigit(arr[i]))
                    return false;
            }
            return true;
        }
        return false;
    }
}
