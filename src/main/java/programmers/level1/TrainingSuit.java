package programmers.level1;

public class TrainingSuit {
    public int solution(int n, int[] lost, int[] reverse){
        int answer = 0;
        int[] stu = new int[n];
        for (int i=0; i< stu.length; i++){
            stu[i] = 1;
        }
        for (int i=0; i<lost.length; i++){
            stu[lost[i]-1]--;
        }
        for (int i=0; i<reverse.length; i++){
            stu[reverse[i]-1]++;
        }

        if (stu[0] == 0 && stu[1] == 2){
            stu[0]++;
            stu[1]--;
        }

        for (int i=1; i<stu.length-1; i++){
            if (stu[i]==0 && stu[i-1]==2){
                stu[i]++;
                stu[i-1]--;
            }
            else if (stu[i]==0 && stu[i+1]==2){
                stu[i]++;
                stu[i+1]--;
            }
        }

        if (stu[n-1] == 0 && stu[n-2]==2){
            stu[n-1]++;
            stu[n-2]--;
        }

        for (int i=0; i<stu.length; i++){
            if (stu[i] != 0)
                answer++;
        }

        return answer;
    }
    public int otherSolution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }
}
