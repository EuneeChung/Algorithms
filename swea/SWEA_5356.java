package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String[] strings = new String[5];
        int lengthMax;

        for(int t=1; t<=T;t++){
            lengthMax=0;
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < 5; i++) {
                strings[i] = br.readLine();
                lengthMax = Math.max(lengthMax, strings[i].length());
            }

            for (int i = 0; i < lengthMax ; i++) {
                for (int j = 0; j <5 ; j++) {
                    if(strings[j].length()>i) sb.append(strings[j].charAt(i));
                }
            }

            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}
