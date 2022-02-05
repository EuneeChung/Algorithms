import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_21610 {
    static int N;
    static int[][] map;
    static boolean[][] cloudMap;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static Queue<Cloud> que = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        cloudMap = new boolean[N][N];
        int[][] moves = new int[M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            moves[i][0] = Integer.parseInt(st.nextToken()) - 1;
            moves[i][1] = Integer.parseInt(st.nextToken());
        }

        que.add(new Cloud(N - 1, 0));
        que.add(new Cloud(N - 1, 1));
        que.add(new Cloud(N - 2, 0));
        que.add(new Cloud(N - 2, 1));

        for (int i = 0; i < M; i++) {
            move(moves[i][0], moves[i][1]);
            magic();
            makeCloud();
        }
        System.out.println(countWater());
    }

    static void move(int d, int s) {
        int size = que.size();
        for (int i = 0; i < size; i++) {
            Cloud cloud = que.poll();
            int tx = (cloud.x + s * dx[d] + 50 * N) % N;
            int ty = (cloud.y + s * dy[d] + 50 * N) % N;
            map[tx][ty]++;
            que.add(new Cloud(tx, ty));
            cloudMap[tx][ty] = true;
        }
    }

    static void magic() {
        int size = que.size();
        for (int i = 0; i < size; i++) {
            Cloud cloud = que.poll();
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int tx = cloud.x + dx[2 * d + 1];
                int ty = cloud.y + dy[2 * d + 1];
                if (tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
                if (map[tx][ty] > 0) cnt++;
            }
            map[cloud.x][cloud.y] += cnt;
        }
    }

    static void makeCloud() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!cloudMap[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    que.add(new Cloud(i, j));
                }
            }
        }
        for (boolean[] c : cloudMap) {
            Arrays.fill(c, false);

        }
    }

    static int countWater() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += map[i][j];
            }
        }
        return cnt;
    }

    static class Cloud {
        int x, y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
