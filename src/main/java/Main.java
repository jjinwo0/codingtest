
import programmers.level1.NumbersAndAlphabet;
import programmers.level1.SmallerSubString;
import programmers.level1.StringSort;
import programmers.level2.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        BinaryCycle bc = new BinaryCycle();
        String s = 	"110010101001";
        for (int i=0; i<bc.solution(s).length; i++){
            System.out.println(bc.solution(s)[i]);
        }
    }
}
