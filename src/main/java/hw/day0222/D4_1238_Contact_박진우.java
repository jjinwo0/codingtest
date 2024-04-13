package hw.day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 결과 : 정답
 * 메모리 : 20,624 kb
 * 실행시간 : 119 ms
 *
 * 접근 방법
 * -- 그래프를 연결한 후, 시작 노드부터 bfs탐색을 시작합니다.
 * -- 탐색을 하면서, 현재 노드가 마지막 노드인지, depth가 최대인지 검증합니다.
 * -- 마지막 노드라면, 최댓값을 비교하여 갱신합니다.
 *
 * @author 박진우
 */
public class D4_1238_Contact_박진우 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case=1; test_case<=10; test_case++) {

            graph = new ArrayList<>();

            for (int i=0; i<=100; i++)
                graph.add(new ArrayList<>());

            visited = new boolean[101];
            answer = -1;

            st = new StringTokenizer(br.readLine());

            int len = Integer.parseInt(st.nextToken());
            int startNode = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<len/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
            }

            bfs(startNode);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }



    private static void bfs(int start){

        Queue<Integer[]> queue = new LinkedList<>();

        int maxDepth = -1;

        visited[start] = true;
        queue.add(new Integer[]{start, 0});

        while(!queue.isEmpty()){

            Integer[] poll = queue.poll();

            Integer node = poll[0];
            Integer depth = poll[1];

            boolean flag = true;
            for (int nextNode : graph.get(node))
                if (!visited[nextNode]) flag = false;

            if (flag){

                if (maxDepth < depth) {
                    maxDepth = depth;
                    answer = node;
                }
                else if (maxDepth == depth)
                    answer = Math.max(answer, node);
            }

            for (int nextNode : graph.get(node)){
                if (!visited[nextNode]){
                    visited[nextNode] = true;
                    queue.add(new Integer[]{nextNode, depth+1});
                }
            }
        }
    }
}
