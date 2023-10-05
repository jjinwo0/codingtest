package baekjoon.silver;

import java.util.*;

public class S4_1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력될 book의 갯수 선언
        HashMap<String, Integer> map = new HashMap<>(N); // HashMap의 크기를 미리 지정

        for (int i=0; i<N; i++){
            String book = sc.next(); // book의 이름을 입력받음

            // map에 book을 key값으로 넣고 해당 book의 입력 횟수를 value값으로 넣는 방식
            // map.getOrDefault(key, defaultValue) 메소드를 사용
            // book이라는 key값에 해당하는 value값이 없으면 0을, 있다면 기존 value값에 1을 더하는 방식
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        // entrySet : Map의 전체 key와 value값을 갖고 있는 Set
        // map의 entrySet을 LinkedList 형식으로 생성
        LinkedList<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());

        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue(); // 후행 변수 - 선행 변수 == 양수값 출력 -> 내림차순
            }
        });

        List<String> keyList = new ArrayList<>(); // key값을 담을 List 선언

        // keyList에 value의 내림차순으로 정렬된 entrySet의 맨 첫번째 key를 add
        // 내림차순 정렬의 맨 첫번째 key는 최고값 value의 key값임을 의미
        keyList.add(entries.getFirst().getKey());

        // 첫 번째 값은 이미 담았으므로, value 비교를 위한 반복문 선언
        for (int i=1; i< entries.size(); i++){

            // value를 기준으로 내림차순 정렬된 entrySet의 첫 번째 value == 최고값 의미
            // 최고값과 entrySet의 다음 value값을 순차적으로 순회하며 같은 값인지 비교
            // 같은 값이라면 keyList에 해당 key값을 담음
            if (entries.getFirst().getValue() == entries.get(i).getValue())
                keyList.add(entries.get(i).getKey());
        }

        // key값을 알파벳 순 내림차순으로 정렬
        // keyList.sort((o1, o2) -> { return o1.compareTo(o2); };
        keyList.sort(String::compareTo);

        // 맨 첫번째에 있는 값이 사전순으로도 가장 앞서있음
        System.out.println(keyList.get(0));
    }
}
