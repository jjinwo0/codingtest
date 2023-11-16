package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 단어뒤집기 {

    public static ArrayList<String> solution(int n, String[] str){

        ArrayList<String> answer = new ArrayList<>();

        for (String s : str){
            // StringBuilder.reverse() 활용
//            String tmp = new StringBuilder(s).reverse().toString();
//            answer.add(tmp);

            // 직접 뒤집기
            char[] c = s.toCharArray();
            int lt = 0, rt = s.length()-1;

            while(lt < rt){
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }

            String tmp = String.valueOf(c);
            answer.add(tmp);
        }

        return answer;
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        for(int i=0; i<n; i++){
            str[i] = br.readLine();
        }
        for(String s : 단어뒤집기.solution(n, str)){
            System.out.println(s);
        }
    }
}
