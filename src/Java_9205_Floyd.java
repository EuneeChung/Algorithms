package src;

import java.util.Scanner;

public class Java_9205_Floyd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        final int INF =99999999; // 20*101
        int T = sc.nextInt();
        for (int t = 0; t <T ; t++) {
            int N = sc.nextInt();
            int[][] map = new int[N+2][2];
            int[][] dp = new int[N+2][N+2];
            for (int i = 0; i < N+2; i++) {
                map[i][0]=sc.nextInt(); // x 좌표
                map[i][1]=sc.nextInt(); // y 좌표
            }

            // D k=0 구하기
            for (int i = 0; i < N+2; i++) {
                for (int j = i+1; j < N+2; j++) {
                    dp[i][j]=dp[j][i]=INF;
                    int dif = Math.abs(map[i][0]-map[j][0])+Math.abs(map[i][1]-map[j][1]);
                    dp[i][j]=dif>50*20? INF : 1;
                    dp[j][i]=dp[i][j];
                }
            }

            for (int k = 0; k <N+2 ; k++) {
                for (int i = 0; i < N + 2; i++) {
                    for (int j = 0; j < N + 2; j++) {
                        dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                    }
                }
            }
//            System.out.println(dp[0][N+1]);
            if(dp[0][N+1]>0&&dp[0][N+1]<INF) sb.append("happy").append("\n");
            else sb.append("sad").append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}
