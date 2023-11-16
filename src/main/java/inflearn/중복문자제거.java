package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복문자제거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for (int i=0; i<str.length(); i++){

            // str.indexOf(character) : 문자열 str에 들어있는 character의 맨 첫번째 index를 뽑아줌
            if (str.indexOf(str.charAt(i)) == i)
                sb.append(str.charAt(i));
        }

        System.out.println(sb.toString());
    }
}
