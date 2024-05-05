package hw.day0505;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main_1013 {
    private static final Pattern P = Pattern.compile("(100+1+|01)+");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            if (P.matcher(br.readLine()).matches()) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb);

    }
}
