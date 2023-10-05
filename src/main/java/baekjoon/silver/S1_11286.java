package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S1_11286 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) > Math.abs(o2))
                    return Math.abs(o1) - Math.abs(o2);
                else if (Math.abs(o1) == Math.abs(o2))
                    return o1 - o2;
                else return -1;
            }
        });

        for (int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }else {
                queue.offer(x);
            }
        }
    }
}
