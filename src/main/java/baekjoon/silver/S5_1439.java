package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st1 = new StringTokenizer(str, "0");
        StringTokenizer st2 = new StringTokenizer(str, "1");

        int min = Math.min(st1.countTokens(), st2.countTokens());

        System.out.println(min);
    }
}
