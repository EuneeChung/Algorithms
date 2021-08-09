package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_9229 {
    static int N,M,max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N= Integer.parseInt(st.nextToken());
            M= Integer.parseInt(st.nextToken());
            max= -1;

            int[] snacks = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int a=0;a<N;a++){
                snacks[a]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(snacks);

            for(int a=0;a<N;a++){
                for(int b=a+1;b<N;b++){
                    int temp =snacks[a]+snacks[b];
                    if(temp>M) break;
                    max = Math.max(max,temp);
                }
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

}
