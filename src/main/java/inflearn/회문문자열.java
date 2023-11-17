package inflearn;

import java.util.Scanner;

public class 회문문자열 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str = in.nextLine();
        int lt = 0;
        int rt = str.length()-1;

        while(lt < rt) {
            if(Character.toLowerCase(str.charAt(lt)) == Character.toLowerCase(str.charAt(rt))){
                System.out.println("NO");
                return;
            }
            lt++; rt--;
        }
        System.out.println("YES");
        return ;
    }
}
