package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][N];
            int[][] dp = new int[2][N + 1]; // dn = n-1의 최고값 저장

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int n = 0; n < N; n++) {
                    stickers[i][n] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = stickers[0][0];
            dp[1][1]  = stickers[1][0];

            for (int n = 2; n <= N; n++) {
                dp[0][n] = Math.max(dp[1][n - 2], dp[1][n - 1]) + stickers[0][n-1]; // 바로 한 칸 뒤와 두칸 뒤 중 큰 값과  스티커 n-1 을 더함
                dp[1][n] = Math.max(dp[0][n - 2], dp[0][n - 1]) + stickers[1][n-1]; // dn-1 은 스티커 n-2 의 최댓값을 들고있음.
            }
            int max = Math.max(dp[0][N], dp[1][N]);
            sb.append(max).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
