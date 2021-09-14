package src;

import java.io.*;
import java.util.StringTokenizer;

public class Java_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] price = new int[N+1][3];
        int[][] dp = new int[N+1][3]; // dp[i][0] - i 번쨰 R를 색칠한 최소 비용 /1- G /2-B

        for (int i = 1; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<3;j++){
                price[i][j] = Integer.parseInt(st.nextToken());
                if(i==1) dp[i][j]=price[i][j];
            }
        }

        for(int i=2;i<=N;i++){
            for(int current =0; current<3;current++){
                for (int previous = 0; previous <3 ; previous++) {
                    if(current != previous){
                        if(dp[i][current]==0) dp[i][current]=dp[i-1][previous]+price[i][current];
                        else dp[i][current] = Math.min(dp[i-1][previous]+price[i][current], dp[i][current]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(dp[N][i],min);
        }
        bw.append(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }
}
