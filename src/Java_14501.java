package src;

import java.util.Scanner;

public class Java_14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] Ti = new int[N+1];
        int[] Pi = new int[N+1];
        int[] dp = new int[N+1];

        for (int i = 1; i <=N ; i++) {
            Ti[i]=sc.nextInt();
            Pi[i]=sc.nextInt();
        }

        for(int i=1; i<=N;i++){
            int day = Ti[i]+i-1;
            dp[i]= Math.max(dp[i],dp[i-1] );
            if(day>N) continue;
            dp[day]= Math.max(dp[day],dp[i-1]+Pi[i] );
        }
        System.out.print(dp[N]);
    }
}
