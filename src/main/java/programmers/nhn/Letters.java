package programmers.nhn;

import java.util.ArrayList;
import java.util.List;

public class Letters {
    public String[] solution(String letters) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[letters.length()];
        backtracking(letters.toCharArray(), visited, "", result);

        return result.stream().sorted().toArray(String[]::new);
    }

    private void backtracking(char[] letters, boolean[] visited, String current, List<String> result) {
        if (current.length() == letters.length && !result.contains(current)) {
            result.add(current);
            return;
        }

        for (int i = 0; i < letters.length; i++) {
            if (!visited[i] && (current.length() == 0 || current.charAt(current.length() - 1) != letters[i])) {
                visited[i] = true;
                backtracking(letters, visited, current + letters[i], result);
                visited[i] = false;
            }
        }
    }
}
