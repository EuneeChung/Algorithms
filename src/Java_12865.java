package src;

import java.util.Scanner;

public class Java_12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt(); // 준서가 버틸 수 있는 무게

        int[] weights= new int[N+1];
        int[] values= new int[N+1];
        for (int i = 1; i <= N; i++) {
            weights[i]= sc.nextInt(); // 무게 W
            values[i]= sc.nextInt(); // 가치 V
        }
        int[] dp = new int[K+1];
        for (int i = 1; i <= N ; i++) {
            for (int w = K; w >= weights[i]; w--) { // 거꾸로 부터 해당 무게에 대한 dp 값 채우기
                dp[w] = Math.max(dp[w], values[i]+dp[w-weights[i]]); // 기존과 i 번째 물건을 들었을때와 비교
            }
        }
        System.out.print(dp[K]);
    }
}
