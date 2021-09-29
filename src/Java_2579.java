package src;

import java.util.Scanner;

public class Java_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] stairs = new int[T+1];
        int[] dp = new int[T+1]; // 각 칸에 최고로 도달할 수 있는 점수
        for (int i = 1; i <= T; i++) {
            stairs[i] = sc.nextInt();
        }

        dp[1] = stairs[1]; // 첫번쨰 칸 기록
        for (int i = 2; i <= T; i++) {
            dp[i]=Math.max(stairs[i-1]+dp[i-3>0 ?i-3:0],dp[i-2])+stairs[i]; // 도착점에는 2-1 칸, 2칸 으로 온 계단 점수중에 큰 점수 기록
        }
        System.out.print(dp[T]);
    }
}
