package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S5_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        List<Character> list = new ArrayList<>();

        for (int i=0; i<n; i++){
            int flag = 1;
            String temp = br.readLine();
            for (int j=0; j<temp.length(); j++){
                if (!list.isEmpty() && (list.get(list.size()-1) != temp.charAt(j) && list.contains(temp.charAt(j)))) {
                    flag = 0;
                    break;
                }
                else list.add(temp.charAt(j));
            }
            if (flag == 1)
                answer++;
        }
        System.out.println(answer);
    }
}
