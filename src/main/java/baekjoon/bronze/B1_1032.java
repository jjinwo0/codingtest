package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 입력 횟수 정의
        String[] commands = new String[n];
        for (int i=0; i<n; i++) {
            commands[i] = String.valueOf(br.readLine()); // 입력값 삽입
        }
        int cnt=1; // 비교 대상을 미리 꺼내놓으므로, 탐색 횟수 1회 미리 추가
        String temp = commands[0]; // 첫 값을 비교 대상으로 지정

        while(cnt<n){ // 끝까지 확인
            if (temp.length()<2){ // 입력 문자 길이가 1인 경우는 예외 처리 (시간 효율을 위해)
                if (!temp.equals(commands[cnt])) { // 길이가 1이므로 일치 여부만 확인
                    temp = "?"; // 불일치 한다면 ?로 변환
                    break;
                }
            }
            for (int i=1; i<=temp.length(); i++){ // 한 문자씩 확인하는 반복문
                if (!(temp.substring(i-1, i).equals(commands[cnt].substring(i-1, i)))){ // i 번째 문자가 불일치할 경우,
                    temp = temp.substring(0, i - 1) + "?" + temp.substring(i); // i 번째 문자를 ? 로 변환
                }
            }
            cnt++; // 횟수 추가
        }
        System.out.println(temp); // 결과 출력
    }
}
