package src;

import java.io.*;
import java.util.ArrayList;

public class Java_1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String text = br.readLine();
        String pattern = br.readLine();

        // KMP
        int tLength=text.length();
        int pLength=pattern.length();
        int[] pi = new int[pLength];

        for (int i = 1, j=0; i < pLength; i++) { // 접미사 i
            while (j>0&& pattern.charAt(i) != pattern.charAt(j)){
                j=pi[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)) pi[i]=++j;
            else pi[i]=0;
        }

        int cnt =0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0,j=0; i <tLength ; i++) { // 텍스트 포인터
            while (j>0&&text.charAt(i)!=pattern.charAt(j))
                j=pi[j-1]; // j 위치에서 틀린것이므로 바로 앞 j-1으로 이동

            if(text.charAt(i)==pattern.charAt(j)){ // 포인터가 가르치는 글자가 일치
                if(j==pLength-1) { // j가 패턴의 마지막 인덱스라면
                    cnt++;
                    list.add((i+1)-(pLength)+1);
                    j=pi[j];
                } else j++;
            }
        }

        bw.write(cnt+"\n");
        for (Integer idx:list) {
            bw.write(idx+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
