package programmers.toss;


import java.util.LinkedList;
import java.util.Queue;

public class Test4 {
    public String[] solution(int maxSize, String[] actions){
        String[] answer = {};
        Queue<String> queue = new LinkedList<>();
        Queue<String> back = new LinkedList<>();
        Queue<String> forward = new LinkedList<>();
        for (int i=0; i<actions.length; i++){
            if (actions[i]=="B" && (queue.peek() == "1" || queue.isEmpty()))
                continue;
            else if (maxSize == 1 && (actions[i] == "B" || actions[i] == "F"))
                continue;
            if (i == 0 && actions[i] != "B" && actions[i] != "F"){
                queue.add(actions[i]);
                continue;
            }
            else {
                if (i > 0 && (actions[i] != "B" || actions[i] != "F") && (actions[i-1] != "B" || actions[i-1] != "F")) {
                    if (Integer.parseInt(actions[i - 1]) < Integer.parseInt(actions[i]))
                        back.add(actions[i]);
                    else if (Integer.parseInt(actions[i - 1]) > Integer.parseInt(actions[i]))
                        forward.add(actions[i]);
                }
                if (actions[i] == "B" && !(back.isEmpty())){
                    queue.remove(back.peek());
                    queue.add(back.poll());
                    continue;
                }
                if (actions[i] == "F" && !(forward.isEmpty())){
                    queue.remove(forward.peek());
                    queue.add(forward.poll());
                    continue;
                }
            }
        }
        for (int i=0; i< queue.size(); i++){
            answer[i] = queue.poll();;
        }

        return answer;
    }
}
