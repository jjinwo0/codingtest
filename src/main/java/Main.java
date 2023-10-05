import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("");
        int answer = 0;

        for (int i=0; i<arr.length; i++){
            answer += Integer.parseInt(String.valueOf(arr[i]));
        }

        System.out.println(answer);
    }
}
