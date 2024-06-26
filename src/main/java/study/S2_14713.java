package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 33420KB
 * 시간 : 360ms
 *
 * 접근방법
 * -- 앵무새가 입력받은 값을 Queue타입의 ArrayList에 각각 담습니다.
 * -- 주어진 문자열과 비교하여 일치하면 poll, 아니라면 Impossible을 출력하고 끝냅니다.
 *
 * @author 박진우
 */
public class S2_14713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<String> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Queue<String>> list = new ArrayList<>();

        for (int i=0; i<N; i++){
            Queue<String> temp = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                temp.offer(st.nextToken());
            }

            list.add(temp);
        }

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens())
            queue.offer(st.nextToken());

        for (int n=0; n<N; n++){

            int size = queue.size();

            for (int i=0; i<size; i++){
                if (queue.peek().equals(list.get(n).peek())) {
                    list.get(n).poll();
                    queue.poll();
                } else {
                    queue.offer(queue.poll());
                }
            }

            if (!list.get(n).isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }

        if (!queue.isEmpty()) {
            System.out.println("Impossible");
            return;
        }

        System.out.println("Possible");
    }
}
