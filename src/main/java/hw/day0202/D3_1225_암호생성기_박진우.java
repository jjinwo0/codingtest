package hw.day0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 결과 : 정답
 * 메모리 : 24,912 kb
 * 실행시간 : 137 ms
 * 접근방법
 * -- 맨 앞에 있는 번호에서 순차적으로 1~5 차를 구해 뒤에 다시 담아주는 문제
 *
 * @author 박진우
 */
public class D3_1225_암호생성기_박진우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;

        do{
            Queue<Integer> q = new LinkedList<>();
            T = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                q.add(Integer.parseInt(st.nextToken()));
            }

            for (int i=1; i<=5; i++){
                Integer poll = q.poll()-i;

                if (poll <= 0){
                    q.offer(0);
                    break;
                }

                if (i == 5)
                    i=0;

                q.offer(poll);
            }

            System.out.print("#" + T + " ");
            while(!q.isEmpty()) {
                System.out.print(q.poll() + " ");
            }

            System.out.println();

        }while(T<10);
    }
}
