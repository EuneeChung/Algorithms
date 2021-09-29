package src;

import java.io.*;
import java.util.StringTokenizer;

public class Java_4485 {
    static int N, minBlackRupees = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0}; // 아래 오른쪽 위 왼쪽
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] rupeeCntMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new int[N][N];
            rupeeCntMap = new int[N][N];
            minBlackRupees = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    rupeeCntMap[i][j] = Integer.MAX_VALUE;
                }
            }

            rupeeCntMap[0][0] = map[0][0];
//            dfs(0);
            dfs2(0, 0);
            if (T != 1) bw.newLine();
            bw.write("Problem " + (T++) + ": " + minBlackRupees);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int position) {
        if (position == N * N - 1) {
            minBlackRupees = Math.min(minBlackRupees, rupeeCntMap[N - 1][N - 1]);
            return;
        }

        int x = position / N;
        int y = position % N;

        if (minBlackRupees < rupeeCntMap[x][y] + map[N - 1][N - 1]) return;

        for (int d = 0; d < 4; d++) {
            int tx = x + dx[d];
            int ty = y + dy[d];
            if (tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
            if (rupeeCntMap[tx][ty] > rupeeCntMap[x][y] + map[tx][ty]) {
                rupeeCntMap[tx][ty] = rupeeCntMap[x][y] + map[tx][ty];
                dfs(tx * N + ty);
            }
        }
    }

    static void dfs2(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            minBlackRupees = Math.min(minBlackRupees, rupeeCntMap[N - 1][N - 1]);
            return;
        }

        if (minBlackRupees < rupeeCntMap[x][y] + map[N - 1][N - 1]) return;

        for (int d = 0; d < 4; d++) {
            int tx = x + dx[d];
            int ty = y + dy[d];
            if (tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
            if (rupeeCntMap[tx][ty] > rupeeCntMap[x][y] + map[tx][ty]) {
                rupeeCntMap[tx][ty] = rupeeCntMap[x][y] + map[tx][ty];
                dfs2(tx, ty);
            }
        }
    }
}
