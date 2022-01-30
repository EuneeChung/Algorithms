import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_17822 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] orders = new int[T][3];
        map = new int[N][M];
        int totalSum = 0;
        // 원판 정보 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                totalSum += map[i][j];
            }
        }
        //order 저장
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                orders[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 0; t < T; t++) {
            for (int line = 0; line < N; line++) {
                if ((line + 1) % orders[t][0] == 0) {
                    for (int k = 0; k < orders[t][2]; k++) {
                        roll(orders[t][1], line);
                    }
                }
            }
            int[] sumInfo = checkSame(totalSum);
            if (totalSum == sumInfo[0]) totalSum = changeByAvg(totalSum,(float) sumInfo[0] / sumInfo[1]);
            else totalSum = sumInfo[0];
        }
        System.out.println(totalSum);
    }

    static void roll(int type, int lineNum) {
        int[] dx = {1, -1};
        int[] originLine = Arrays.copyOf(map[lineNum], M);
        for (int i = 0; i < M; i++) {
            if (i + dx[type] >= 0 && i + dx[type] < M) map[lineNum][i + dx[type]] = originLine[i];
        }
        if (type == 0) map[lineNum][0] = originLine[M - 1];
        if (type == 1) map[lineNum][M - 1] = originLine[0];
    }

    static int[] checkSame(int sum) {
        int cnt = 0;
        int[][] originMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            originMap[i] = Arrays.copyOf(map[i], M);
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int currentNum = map[i][j];
                if (currentNum == 0) continue;
                boolean atLeast = false;
                for (int d = 0; d < 4; d++) {
                    int tx = i + dx[d];
                    int ty = j + dy[d];
                    if (ty == -1) ty = M - 1;
                    if (ty == M) ty = 0;
                    if (tx < 0 || tx >= N || ty < 0 || ty >= M) continue;
                    if (currentNum == originMap[tx][ty]) {
                        atLeast = true;
                        if (map[tx][ty] == 0) continue;
                        map[tx][ty] = 0;
                        sum -= currentNum;
                    }
                }
                if (atLeast) {
                    map[i][j] = 0;
                    sum -= currentNum;
                }
                if (map[i][j] != 0) cnt++;
            }
        }
        return new int[]{sum, cnt};
    }

    static int changeByAvg(int sum, float avg) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0) continue;
                if (map[i][j] > avg) {
                    map[i][j]--;
                    sum--;
                }
                else if (map[i][j] < avg) {
                    map[i][j]++;
                    sum++;
                }
            }
        }
        return sum;
    }
}
