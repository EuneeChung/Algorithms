package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_1759 {
    static boolean[] isSelected;
    static char[] alphabets;
    static char[] cryptos;
    static int L,C;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        isSelected=new boolean[C];
        alphabets=new char[C];
        cryptos = new char[L];

        String line = br.readLine();
        for (int i = 0; i < C*2; i+=2) {
            alphabets[i/2]=line.charAt(i);
        }
        Arrays.sort(alphabets);

        comb(0,0);

        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
    static void comb(int cnt, int target){
        if(cnt==L){
            int aeiouCount=0;
            int other=0;
            for(char c: cryptos){
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') aeiouCount++;
                else other ++;
            }
            if(aeiouCount>=1 &&other>=2){
                for(char c: cryptos){
                   sb.append(c);
                }
                sb.append("\n");
            }

            return;
        }

        for(int i = target; i<C;i++){
            if(isSelected[i]) continue;
            isSelected[i]=true;
            cryptos[cnt]=alphabets[i];
            comb(cnt+1,i+1);
            isSelected[i]=false;
        }
    }
}
