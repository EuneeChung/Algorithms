package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_7576 {
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) queue.add(i * M + j);
            }
        }
        System.out.println(bfs(map));

    }

    static int bfs(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        int days = -1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {

                int current = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int tx = current / m + dx[d];
                    int ty = current % m + dy[d];

                    if (tx < 0 || tx >= n || ty < 0 || ty >= m || map[tx][ty] == 1) continue;
                    if (map[tx][ty] == 0) {
                        map[tx][ty] = 1;
                        queue.add(tx * m + ty);
                    }
                }
            }
            days++;

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) return -1;
            }
        }

        return days;
    }
}
