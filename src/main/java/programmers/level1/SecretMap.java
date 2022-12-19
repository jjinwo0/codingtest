package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class SecretMap {
    public ArrayList<String> solution(int n, int[] arr1, int[] arr2){
        ArrayList<String> answer = new ArrayList<>();
        String[] temp = new String[n];

        for (int i=0; i< arr1.length; i++){
            String tmp1 = Integer.toBinaryString(arr1[i]);
            String tmp2 = Integer.toBinaryString(arr2[i]);
            if (tmp1.length() < n){
                int loop = n-tmp1.length();
                for (int j=0; j<loop; j++){
                    tmp1 = "0"+tmp1;
                }
            }
            if (tmp2.length() < n){
                int loop = n-tmp2.length();
                for (int k=0; k<loop; k++){
                    tmp2 = "0"+tmp2;
                }
            }
            String num = "";
            for (int b=0; b<tmp1.length(); b++){
                if (tmp1.charAt(b) == '0' && tmp2.charAt(b) == '0')
                    num += '0';
                else num += '1';
            }
            temp[i] = num;
        }
        for (int i=0; i< temp.length; i++){
            String str = "";
            for (int j=0; j<temp[i].length(); j++){
                if (temp[i].charAt(j) == '1')
                    str += "#";
                else str += " ";
            }
            answer.add(str);
        }


        return answer;
    }
}
