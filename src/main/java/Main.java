
import programmers.level1.NumbersAndAlphabet;
import programmers.level1.SmallerSubString;
import programmers.level1.StringSort;
import programmers.level2.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Carpet c = new Carpet();
        int[] arr = c.solution(10, 2);
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
