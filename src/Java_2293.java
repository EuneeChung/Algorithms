import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        int[] dp = new int[K+1];
        for (int i = 0; i <N ; i++) {
            coins[i]=Integer.parseInt(br.readLine());

        }

        dp[0]=1;
        for(int c : coins){
            for (int i = c; i <=K ; i++) {
                dp[i]+=dp[i-c];
            }
        }
        System.out.println(dp[K]);
    }
}
