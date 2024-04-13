package ssafy.exam;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 10000;

        System.out.print("소비 금액 입력 : ");
        int input = sc.nextInt();

        if (input % 10 != 0){
            System.out.println("1의 자릿수는 사용할 수 없는 금액입니다.");
            return;
        }

        int left = money - input;

        int[] arr = new int[5];

        while(left > 0){

            if (left >= 1000){
                arr[0] = left / 1000;
                left %= 1000;
            }

            if (left >= 500){
                arr[1] = left / 500;
                left %= 500;
            }

            if (left >= 100){
                arr[2] = left / 100;
                left %= 100;
            }

            if (left >= 50){
                arr[3] = left / 50;
                left %= 50;
            }

            if (left >= 10){
                arr[4] = left / 10;
                left %= 10;
            }
        }


        System.out.println("[출력]");
        System.out.println("투입 금액 : 10000원");
        System.out.println("상품 금액 : "+input);
        System.out.println("거스름돈 : "+left);
        System.out.println("---------------------");
        System.out.println("1000원 : " + arr[0] + "개");
        System.out.println("500원 : " + arr[1] + "개");
        System.out.println("100원 : " + arr[2] + "개");
        System.out.println("50원 : " + arr[3] + "개");
        System.out.println("10원 : " + arr[4] + "개");
    }
}
