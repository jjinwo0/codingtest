package programmers.kit.heap;

import java.util.PriorityQueue;

public class MoreHot {
    public int solution(int[] scoville, int K){
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : scoville)
            pq.offer(n);

        while(pq.peek() <= K){
            int a = pq.poll();
            int b = pq.poll();
            int temp = a + b*2;
            pq.offer(temp);
            answer++;
        }

        if (K > pq.peek())
            return -1;

        return answer;
    }
}
