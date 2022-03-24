import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = map[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int sum = getSum(map, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }

    public static int getSum(int[][] prefixSum, int sx, int sy, int ex, int ey) {
        int sum = 0;
        for (int i = sx; i <= ex; i++) {
            sum += prefixSum[i][ey] - prefixSum[i][sy - 1];
        }
        return sum;
    }
}
