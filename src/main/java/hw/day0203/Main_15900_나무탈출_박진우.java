package hw.day0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 결과 : 맞았습니다!!
 * 메모리 : 210384KB
 * 실행시간 : 1904ms
 *
 * 접근 방법
 * -- 인덱스로 현재 노드를 표현하고, 해당 인덱스에 담긴 ArrayList에 연결되어있는 노드의 번호를 담는 방식으로 구성
 * -- 탐색하면서 단일 노드를 찾고, 해당 수가 홀수이면 이기는 방식
 * -- 출력 형식때문에 삽질했습니다 ㅠㅠ
 */
public class Main_15900_나무탈출_박진우 {

    static ArrayList<Integer>[] graph;
    static int N, count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        count = 0;

        graph = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());

            // 노드의 각 번호 입력
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            // 노드 간선 연결
            graph[X].add(Y);
            graph[Y].add(X);
        }

        game(1, 0, 0);

        // 짝수면 진다!
        if (count % 2 == 0)
            System.out.println("No");
        else System.out.println("Yes");
    }

    private static void game(int x, int parent, int depth) {

        // 자식 노드의 깊이를 확인
        // 현재 노드의 size가 1이고, 연결된 값이 parent node와 같다면 단일노드
        if (graph[x].size() == 1 && graph[x].get(0) == parent){
            count+=depth;
            return;
        }

        // 자식 노드 확인 순회
        for (int child : graph[x]){

            // 자식 노드로 recursion
            if (child != parent)
                game(child, x, depth + 1);
        }
    }
}
