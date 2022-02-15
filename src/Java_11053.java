import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] orders = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            orders[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i]=1;

            for (int j = 0; j < i; j++) {
                if(orders[j]<orders[i]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max =0;
        for (int d : dp){
            max= Math.max(max,d);
        }
        System.out.println(max);
    }
}
