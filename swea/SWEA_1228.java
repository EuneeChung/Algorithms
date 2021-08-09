package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1228 {
    static int N,insertCount, startIdx, commandCount;
    static List<String> cryptos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t=1;t<=10;t++){
            N=Integer.parseInt(br.readLine());
            cryptos= new ArrayList<String>();
            StringTokenizer stLength = new StringTokenizer(br.readLine());

            for(int i=0; i<N;i++){
                cryptos.add( stLength.nextToken());
            }

            insertCount =Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<insertCount;i++){
                st.nextToken();
                startIdx=Integer.parseInt(st.nextToken());
                commandCount=Integer.parseInt(st.nextToken());
                if(startIdx<=10) {
                    List<String> inserts = new ArrayList<String>();
                    for (int j = 0; j < commandCount; j++) {
                        inserts.add(st.nextToken());
                    }
                    cryptos.addAll(startIdx , inserts);
                }else{
                    for (int j = 0; j < commandCount; j++) {
                        st.nextToken();
                    }
                }
                cryptos=cryptos.subList(0,10);
            }

            sb.append("#"+t+" ");
            for(int a=0;a<10;a++){
                sb.append(cryptos.get(a)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
