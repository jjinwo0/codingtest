package programmers.kit.hash;

import java.util.*;

public class PhoneNumberList {
    public boolean solution(String[] phone_book){
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : phone_book){
            map.put(str, str.length());
        }

        for (String str : phone_book){
            for (int i=1; i<str.length(); i++){
                if (map.containsKey(str.substring(0, i)))
                    return false;
            }
        }

        return true;
    }
}
