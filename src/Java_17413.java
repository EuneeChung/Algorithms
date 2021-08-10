package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder flipWord = new StringBuilder();
        boolean isTag =false;
        int startWordIdx=-1;

        for(int i =0;i<input.length();i++){
            if(!isTag){
                if(startWordIdx==-1) startWordIdx=i;
                if(input.charAt(i)==' ' || i==input.length()-1 ||input.charAt(i)=='<'){
                    if(i==input.length()-1) flipWord.append(input.charAt(i));
                    for(int j=i-1; j>=startWordIdx;j--){
                        flipWord.append(input.charAt(j));
                    }
                    if(input.charAt(i)==' ') flipWord.append(' ');
                    startWordIdx=-1;
                }
            }
            if(input.charAt(i)=='<') isTag=true;
            if(isTag) flipWord.append(input.charAt(i));
            if(input.charAt(i)=='>') isTag=false;

        }

        System.out.println(flipWord);
        br.close();
    }
}
