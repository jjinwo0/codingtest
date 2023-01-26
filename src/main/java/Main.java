
import programmers.level0.Babbling;
import programmers.level1.NumbersAndAlphabet;
import programmers.level1.SmallerSubString;
import programmers.level1.StringSort;
import programmers.level2.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Babbling b = new Babbling();
        String[] arr = {"aya", "yee", "u", "maa", "wyeoo"};
        System.out.println("answer: "+b.solution(arr));

        String str = "wyeoo";
        System.out.println(str.replace("ye", ""));

    }
}
