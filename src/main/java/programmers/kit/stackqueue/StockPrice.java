package programmers.kit.stackqueue;

import java.util.Stack;

// 다시 확인해봐야할 문제
public class StockPrice {

    public int[] solution(int[] prices){
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i< answer.length; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }
}
