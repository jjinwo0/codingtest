package programmers.level1;

public class Test1 {

    public boolean solution(String s){
        int p = 0;
        int y = 0;
        for (int i=0; i<s.length(); i++){

            if (s.charAt(i) == 'p' || s.charAt(i) == 'P')
                p++;
            else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y')
                y++;
        }
        if (p == y)
            return true;
        else return false;
    }
}
