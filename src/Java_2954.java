package src;

import java.util.Scanner;

public class Java_2954 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in); // 스캐너 생성, 입력받을 준비
		String line = sc.nextLine(); // 문자열 입력받음
		
		String aeiou = "aeiou"; //모음들 
		StringBuilder sb = new StringBuilder(); //반환값의 스트링빌더 생성
		
		int i=0;
		while(i<line.length()) {
			sb.append(line.charAt(i));
			if(aeiou.contains(line.charAt(i)+"")) i+=3;
			else i++;
			
		}
		System.out.print(sb); // sb 프린트	
	}
}
