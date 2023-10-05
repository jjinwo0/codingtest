package baekjoon.gold;

import java.util.*;

public class G5_12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int max = 0;

        for (int i=0; i<N; i++){
            int W = sc.nextInt();
            int V = sc.nextInt();
            map.put(W, V);
        }
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);


        for (int i=0; i< keys.size(); i++){
            int keySum = keys.get(i);
            int sum = map.get(keys.get(i));

            while(K - keySum >= 0){
                if (max < sum)
                    max = sum;

                sum += map.get(keys.get(i+1));
                keySum += keys.get(i+1);
            }
        }

        System.out.println(max);
    }
}
