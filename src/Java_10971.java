package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_10971 {
    static int[][] adjMatrix;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        adjMatrix = new int[N][N];
        boolean[] add = new boolean[N];
        StringTokenizer st = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(add, false);
            dfs(i, i, 0, 0, add);
        }
        System.out.print(result);
    }

    static void dfs(int start, int current, int cnt, int sum, boolean[] add) {
        if (cnt >= add.length) {
            result = Math.min(result, sum);
            return;
        }

        if (cnt == add.length - 1) {
            if ( adjMatrix[current][start] != 0 && !add[start]) {
                dfs(start, current, cnt + 1, sum + adjMatrix[current][start], add);
            }
        } else {
            for (int i = 0; i < add.length; i++) {
                if (adjMatrix[current][i] != 0 && !add[i] && i != start) {
                    add[i] = true;
                    dfs(start, i, cnt + 1, sum +  adjMatrix[current][i], add);
                    add[i] = false;
                }
            }
        }
    }
}
