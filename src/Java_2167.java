import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2167 {
    static int[][] prefixSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        prefixSum = new int[N][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M + 1; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int result = getSectionSum9(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    static int getSectionSum9(int startX, int startY, int endX, int endY) {
        int sum = 0;
        for (int x = startX; x <= endX; x++)
            sum += prefixSum[x][endY] - prefixSum[x][startY - 1];

        return sum;
    }
}
