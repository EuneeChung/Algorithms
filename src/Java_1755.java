package src;

import java.util.Arrays;
import java.util.Scanner;

public class Java_1755 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // N,M 입력 받기위해 스캐너 사용
        StringBuilder sb = new StringBuilder(); // 모아서 출력받기 위해 스트링 빌더 생성
        int M = sc.nextInt(); // M 입력 받기
        int N = sc.nextInt(); // N 입력 받기

        String[] numbers = new String[N-M+1]; // M 이상 N 이하의 문자열을 받기 위해 문자열 배열 생성

        int index =0; // 배열의 인덱스
        for (int i = M; i <= N; i++) { // M 이상 N 이하의 수들을 스트링 배열속에 저장하기 위하여 범위 지정
            if(i < 10) numbers[index] = changeNumToString(i); // 10 이하라면 그 수 그대로 문자열로 변환힌 값을 배열에 대입
            else  numbers[index]=changeNumToString(i/10)+" "+ changeNumToString(i%10); // 2자리 수 라면 10의 자리 문자열로 변환 + 공백 문자 + 1의 자리 문자열로 젼환 한 값을 배열에 대입
            index++; // 배열의 인덱스 ++
        }
        Arrays.sort(numbers); // 문자열 사전 순으로 정렬

        int count=0; // 10개씩 카운트 하기 위해
        for(String s : numbers) { // 저장한 문자열 배열을 반복문 실행, 숫자로 변환후 스트링 빌더에 append
            String[] words = s.split(" "); // 공백으로 문자열 나누기
            sb.append(changeStringToNum(words[0])); // 첫 문자열 숫자로 변환후 스트링 빌더에 추가
            if(words.length==2) sb.append(changeStringToNum(words[1])); // 2자리 수라면 두번째 문자열 숫자로 변환 후 추가
            if(count%10==9) sb.append("\n"); // 10개씩 끊어서 출력하기 위함
            else sb.append(" "); // 한줄에 10개 아닐 경우 공백 추가

            count++; // count 증가
        }
        sb.deleteCharAt(sb.length()-1); // 마지막 공백 제거
        System.out.print(sb.toString()); // 출력
    }

    static String changeNumToString(int a) { // 숫자를 문자열로 바꾸기
        if(a==0) return "zero" ;      // 0일때 zero 반환
        else if(a==1) return "one";   // 1일때 one 반환
        else if(a==2) return "two";   // 2 일때 two 반환
        else if(a==3) return "three"; // 3일때 three 반환
        else if(a==4) return "four";  // 4일때 four 반환
        else if(a==5) return "five";  // 5일때 five 반환
        else if(a==6) return "six";   // 6일때 six 반환
        else if(a==7) return "seven"; // 7일때 seven 반환
        else if(a==8) return "eight"; // 8 일때 eight 반환
        else if(a==9) return "nine";  // 9 일때 nine 반환
        else return ""; //// 모든 곳에 해당되지 않을 경우 "" 반환
    }

    static int changeStringToNum(String s){ // 문자열을 숫자로 변환
        if(s.equals("zero")) return 0 ;      // 0 반환
        else if(s.equals("one"))return 1;    // 1 반환
        else if(s.equals("two")) return 2;   // 2 반환
        else if(s.equals("three")) return 3; // 3반환
        else if(s.equals("four"))return 4;   // 4반환
        else if(s.equals("five"))return 5;   // 5반환
        else if(s.equals("six")) return 6;   // 6반환
        else if(s.equals("seven")) return 7; // 7 반환
        else if(s.equals("eight")) return 8; // 8 반환
        else if(s.equals("nine"))return 9;   // 9 반환
        else return -1; // 모든 곳에 해당되지 않을 경우 -1 반환
    }
}