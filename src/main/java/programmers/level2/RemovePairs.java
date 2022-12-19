package programmers.level2;

public class RemovePairs {
    public int solution(String s){
        String str = s;
        for (int i=1; i<str.length(); i++){
            if (str.charAt(i) == str.charAt(i-1)){
                str = str.substring(0, i-1) + str.substring(i+1);
                System.out.println("str : " + str);
                i=1;
                if (str.length() == 2 && str.charAt(0) == str.charAt(1))
                    return 1;
            }
        }

        return 0;
    }
}
