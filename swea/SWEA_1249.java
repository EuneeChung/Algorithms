package swea;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SWEA_1249 {
    static PriorityQueue<Point> pq = new PriorityQueue<>();
    static int[][] totalMap;
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[][] map;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            if (t != 1) bw.newLine();
            map = new int[N][N];
            totalMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
                Arrays.fill(totalMap[i], Integer.MAX_VALUE);
            }

            bw.write("#" + t + " " + bfs(map));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int[][] map) {
        pq.clear();
        totalMap[0][0] = map[0][0];
        pq.add(new Point(0, 0));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            for (int d = 0; d < 4; d++) {
                int tx = p.i + dx[d];
                int ty = p.j + dy[d];

                if (tx < 0 || tx >= N || ty < 0 || ty >= N || totalMap[tx][ty] <= totalMap[p.i][p.j] + map[tx][ty])
                    continue;

                totalMap[tx][ty] = totalMap[p.i][p.j] + map[tx][ty];
                pq.add(new Point(tx, ty));
            }
        }
        return totalMap[N - 1][N - 1];

    }

    static class Point implements Comparable<Point> {
        int i, j;
        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public int compareTo(Point o) {
            return totalMap[this.i][this.j] - totalMap[o.i][o.j];
        }
    }
}
