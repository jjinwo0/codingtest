package ssafy.exam;

public class Test2 {
    public static void main(String[] args) {

        int[][] jumsu = {
                { 95, 60, 72, 80 },
                {44, 52, 68, 94 },
                { 65, 67, 57, 72 },
                { 70, 72, 76, 77 }
        };

        double allAvg = getAllAvg(jumsu);
        double avgOne = getOneAvg(jumsu, allAvg);

        System.out.printf("전체 평균 : %.2f", allAvg);
        System.out.printf(", 과목 평균 : %.2f", avgOne);
    }

    private static double getOneAvg(int[][] jumsu, double all) {

        double max = 0;
        double answer = 0;

        for (int j=0; j< jumsu[0].length; j++){

            int sum = 0;

            for (int i=0; i< jumsu.length; i++){
                sum += jumsu[i][j];
            }

            double avg = (1.0*sum)/jumsu[0].length;

            if (max < Math.abs(all-avg)) {
                max = Math.abs(all - avg);
                answer = avg;
            }
        }

        return answer;
    }

    private static double getAllAvg(int[][] jumsu) {

        int sum = 0;

        for (int i=0; i< jumsu.length; i++){
            for (int j=0; j<jumsu[i].length; j++){
                sum += jumsu[i][j];
            }
        }

        return (1.0*sum)/(jumsu.length*jumsu[0].length);
    }
}
