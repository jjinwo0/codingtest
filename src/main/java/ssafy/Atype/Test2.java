package ssafy.Atype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test2 {

    static class Sushi{

        int t;
        String name;

        public Sushi(int t, String name) {
            this.t = t;
            this.name = name;
        }
    }

    static class Person {
        int x;
        String name;
        int n;

        public Person(int x, String name, int n) {
            this.x = x;
            this.name = name;
            this.n = n;
        }
    }

    static int L, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        ArrayList<Sushi>[] rotating = new ArrayList[L];

        for (int i=0; i<L; i++){
            rotating[i] = new ArrayList<>();
        }

        ArrayList<Person> person = new ArrayList<>();

        for (int tc=0; tc<Q; tc++){

            st = new StringTokenizer(br.readLine());

            int input = Integer.parseInt(st.nextToken());

            int t = Integer.parseInt(st.nextToken()); // 동작의 시간

            for (int i=0; i<rotating.length; i++){
                ArrayList<Sushi> spot = new ArrayList<>(rotating[i]);

                for (Sushi s : spot){
                    // 다음 초밥의 위치 = 현재 위치 + (현재 시간 - 놓였던 시간)

                    for (int time=s.t; time<=t; time++) {
                        int nextIndex = i + (t - s.t);

                        // 만약 다음 칸이 끝을 넘는다면, 0부터 다시 세줘야 함
                        if (nextIndex >= L) {
                            nextIndex %= L;
                        }

                        rotating[nextIndex].add(s); // 다음 자리에 안착
                        rotating[i].remove(s); // 기존에 있었던 자리에는 지워야 함
                        s.t = t; // 초밥의 놓인 시간을 현재 시간으로 업데이트

                        // 대기중인 사람이 있다면,
                        if (!person.isEmpty()){
                            ArrayList<Person> finish = new ArrayList<>();

                            for (Person p : person){
                                ArrayList<Sushi> sushis = new ArrayList<>(rotating[p.x]);

                                for (Sushi sushi : sushis) {
                                    if (sushi.name.equals(p.name) && p.n > 0) {
                                        p.n -= 1;
                                        rotating[p.x].remove(sushi);

                                        if (p.n == 0)
                                            finish.add(p);

                                        break;
                                    }
                                }
                            }

                            person.removeAll(finish);
                        }
                    }
                }
            }

            if (input == 100){
                int x = Integer.parseInt(st.nextToken()); // 초밥의 위치
                String name = st.nextToken(); // 사람이름

                rotating[x].add(new Sushi(t, name));
            }

            if (input == 200){
                int x = Integer.parseInt(st.nextToken()); // 초밥의 위치
                String name = st.nextToken(); // 사람이름

                Person newPerson = new Person(x, name, Integer.parseInt(st.nextToken()));

                ArrayList<Sushi> spot = rotating[x];

                for (Sushi s : spot){
                    if (s.name.equals(newPerson.name)){
                        spot.remove(s);
                        newPerson.n -= 1;

                        if (newPerson.n == 0)
                            break;
                    }
                }

                if (newPerson.n != 0)
                    person.add(newPerson);
            }

            if (input == 300) {

                int size = 0;

                for (ArrayList<Sushi> list : rotating)
                    size += list.size();

                System.out.println(person.size() + " " + size);
            }
        }
    }
}
