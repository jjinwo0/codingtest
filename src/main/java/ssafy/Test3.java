package ssafy;

public class Test3 {
	public static void main(String[] args) {
		
		int change = 7470;
		
		int paper = 0;
		int five = 0;
		int one = 0;
		int fif = 0;
		int ten = 0;
		
		while (change != 0) {
			if(change > 1000) {
				paper++;
				change -= 1000;
			}else if (change < 1000 && change > 500) {
				five++;
				change -= 500;
			}else if (change < 500 && change > 100) {
				one++;
				change -= 100;
			}else if (change < 100 && change > 50) {
				fif++;
				change -= 50;
			} else {
				ten++;
				change -= 10;
			}
		}
		
		
		System.out.println("[출력]");
		System.out.println("투입 금액 : 10000원");
		System.out.println("상품 금액 : 2530원");
		System.out.println("거스름돈 : 7470원");
		System.out.println("---------------------");
		System.out.println("1000원 : " + paper + "개");
		System.out.println("500원 : " + five + "개");
		System.out.println("100원 : " + one + "개");
		System.out.println("50원 : " + fif + "개");
		System.out.println("10원 : " + ten + "개");
	}
}