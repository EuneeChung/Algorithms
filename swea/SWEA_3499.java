package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_3499 {
    static int N,Length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            StringBuilder sb = new StringBuilder();
            N =Integer.parseInt(br.readLine());
            String[] cards = new String[N];
            cards = br.readLine().split(" ");
            Length=cards.length;


            sb.append("#"+t);
            int half = Length/2;
            if(Length%2==1) half++;
            for(int i=0;i<half;i++){
                sb.append(" "+cards[i]);
                if(half+i<Length) sb.append(" "+cards[half+i]);
            }

            System.out.println(sb);
        }
    }
}
