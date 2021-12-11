package src;

import java.util.Scanner;

public class Java_14500 {
    static int N, M;
    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.print(max);
    }

    static void dfs(int x, int y, int sum, int cnt) {
        if (cnt == 4) {
            max = Math.max(sum, max);
            return;
        }
        if (cnt == 1) { // T 모양
            makeT:
            for (int i = 0; i < 4; i++) {
                int tSum = sum;
                for (int j = 0; j < 4; j++) {
                    int tx = x + dx[j];
                    int ty = y + dy[j];
                    if (i != j) {
                        if (!isValidate(tx, ty) || visited[tx][ty]) continue makeT;
                        tSum += map[tx][ty];
                    }
                }
                max = Math.max(tSum, max);
            }
        }

        for (int j = 0; j < 4; j++) {
            int tx = x + dx[j];
            int ty = y + dy[j];
            if (!isValidate(tx, ty) || visited[tx][ty]) continue;
            visited[tx][ty] = true;
            dfs(tx, ty, sum + map[tx][ty], cnt + 1);
            visited[tx][ty] = false;
        }
    }

    static boolean isValidate(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}
