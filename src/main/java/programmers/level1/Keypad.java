package programmers.level1;

import java.util.ArrayList;

public class Keypad {

    public static void main(String[] args) {

    }

    public String solution(int[] numbers, String hand){
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> center = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        String defHand;
        if (hand.equals("left"))
            defHand = "L";
        else defHand = "R";

        for (int i=1; i<=7; i+=3){
            left.add(i);
            center.add(i+1);
            right.add(i+2);
        }
        center.add(0);

        int leftPointer = 3;
        int rightPointer = 3;
        for (int i=0; i< numbers.length; i++){
            int temp = numbers[i];

            if (temp % 3 == 0){
                if (temp == 0){
                    if (leftPointer == rightPointer) {
                        sb.append(defHand);
                        continue;
                    }
                    if (Math.abs(3-leftPointer) > Math.abs(3-rightPointer)) {
                        sb.append("L");
                        continue;
                    } else{
                        sb.append("R");
                        continue;
                    }
                }
                sb.append("R");

                rightPointer = right.indexOf(temp);
            }
            if (temp % 3 == 1){
                sb.append("L");

                leftPointer = left.indexOf(temp);
            }
            if (temp % 3 == 2){

                int idx = center.indexOf(temp);

                if (leftPointer == rightPointer) {
                    sb.append(defHand);
                    continue;
                }
                if (Math.abs(idx-leftPointer) > Math.abs(idx-rightPointer)) {
                    sb.append("L");
                } else sb.append("R");
            }
        }

        return sb.toString();
    }
}
