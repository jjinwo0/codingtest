package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 143940KB
 * 시간 : 864ms
 *
 * 접근 방법
 * -- 주어진 선의 숫자를 Stack 배열의 index로 잡습니다.
 * -- 해당 선에 추가적인 동작이 발생할 때 마다 push/pop 동작을 하고, counting합니다.
 *
 * @author 박진우
 */
public class S1_2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] guitar = new Stack[N];

        for (int i=0; i<N; i++){
            guitar[i] = new Stack<>();
        }

        int count = 0;
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken())-1;
            int value = Integer.parseInt(st.nextToken());

            if (guitar[index].isEmpty()){
                count++;
                guitar[index].push(value);
                continue;
            }

            while(guitar[index].peek() > value){
                guitar[index].pop();
                count++;

                if (guitar[index].size()==0)
                    break;
            }

            if (guitar[index].isEmpty() || guitar[index].peek() != value) {
                guitar[index].push(value);
                count++;
            }
        }

        System.out.println(count);
    }
}
