package programmers.level2;

public class NewsClustering {

    public int solution(String str1, String str2){
        int answer = 0;
        String s1 = str1.replaceAll("\\s", "").trim();
        s1 = s1.toLowerCase();
        String s2 = str2.replaceAll("\\s", "");
        s2 = s2.toLowerCase();

        System.out.println(s1);
        System.out.println(s2);

        return answer;
    }
}
