package programmers.toss;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public int solution(int[][] relationships, int target, int limit){
        int answer = 0;
        List<Integer> friends = new ArrayList<>();
        List<Integer> newFriends = new ArrayList<>();
        for (int i=0; i<relationships.length; i++){

            if (relationships[i][0] == target) {
                friends.add(relationships[i][1]);
            } else if (relationships[i][1] == target)
                friends.add(relationships[i][0]);

            if (!friends.isEmpty() && relationships[i][0] != target && relationships[i][1] != target &&
                    (friends.contains(relationships[i][0]) || friends.contains(relationships[i][1]))){
                if (friends.contains(relationships[i][0]) || newFriends.contains(relationships[i][0])){
                    newFriends.add(relationships[i][1]);
                }else if (friends.contains(relationships[i][1]) || newFriends.contains(relationships[i][1])){
                    newFriends.add(relationships[i][0]);
                }
            }
        }
        for (int i=0; i< friends.size(); i++){
            System.out.println("friends["+i+"]: "+friends.get(i));
        }
        for (int i=0; i< newFriends.size(); i++){
            System.out.println("newFriends["+i+"]: "+newFriends.get(i));
        }
        answer += friends.size()*5 + newFriends.size()*10 + newFriends.size();

        return answer;
    }
}
