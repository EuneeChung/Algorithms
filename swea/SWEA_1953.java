package swea;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
    static int N, M; // map 의 크기
    static int R, C; // 처음 출발점
    static int L; // 소요시간
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int[][] tunnel = {
            {0, 1, 2, 3}, // 상 하 좌 우
            {0, 1}, // 상 하
            {2, 3}, // 좌 우
            {0, 3}, // 상 우
            {1, 3}, // 하 우
            {1, 2}, // 하 좌
            {0, 2}, // 상 좌
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[][] map;


        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()) - 1;
                }
            }

            if (t != 1) bw.newLine();
            bw.write("#" + t + " " + bfs(map));
        }
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(int[][] map) {
        queue.clear();
        boolean[][] visited = new boolean[N][M];
        int cnt = 1;
        queue.add(new int[]{R, C});
        visited[R][C]=true;
        int l = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            if (l == L) break;
            for (int size = 0; size < queueSize; size++) {
                int[] now = queue.poll();
                int tunnelType = map[now[0]][now[1]];
                for (int d = 0; d < tunnel[tunnelType].length; d++) {
                    int direction = tunnel[tunnelType][d];
                    int tx = now[0] + dx[direction];
                    int ty = now[1] + dy[direction];

                    if (tx < 0 || tx >= N || ty < 0 || ty >= M || map[tx][ty] < 0 || visited[tx][ty]) continue;
                    for (int tempDir : tunnel[map[tx][ty]]) {
                        if ((tempDir == 0 && direction == 1)
                                || (tempDir == 1 && direction == 0)
                                || (tempDir == 2 && direction == 3)
                                || (tempDir == 3 && direction == 2)) {
                            queue.add(new int[]{tx, ty});
                            visited[tx][ty]=true;
                            cnt++;
                        }
                    }
                }
            }
            l++;
        }
        return cnt;
    }
}
