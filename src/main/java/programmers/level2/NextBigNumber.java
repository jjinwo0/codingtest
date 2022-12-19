package programmers.level2;

public class NextBigNumber {
    public int solution(int n){
        int answer = 0;
        int temp = n;
        int cnt = 0;
        String bin = Integer.toBinaryString(n);
        for (int i=0; i<bin.length(); i++){
            if (bin.charAt(i) == '1')
                cnt++;
        }
        do{
            temp++;
            int tempcnt = 0;
            String str = Integer.toBinaryString(temp);
            for (int i=0; i<str.length(); i++){
                if (str.charAt(i) == '1')
                    tempcnt++;
            }
            if (tempcnt == cnt){
                answer = temp;
                break;
            }
        }while(temp < 1000000);

        return answer;
    }
}
