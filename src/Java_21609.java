import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Java_21609 {
    static int N;
    static final int EMPTY = -3;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static PriorityQueue<BlockGroup> bgPq = new PriorityQueue<BlockGroup>();
    static ArrayList<int[]> rainbows = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) rainbows.add(new int[]{i, j});
            }
        }
        int cnt = 0;
        while (true) {
            bgPq.clear();
            findBlockGroup();
            if (bgPq.size() == 0) break;
            BlockGroup bg = bgPq.poll();
            cnt += (int) Math.pow(bg.cnt, 2);
            removeBlockGroup(bg.x, bg.y);
            workGravity();
            rotate();
            workGravity();
            findRainbow();
        }
        System.out.println(cnt);
    }

    public static void findRainbow() {
        rainbows.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) rainbows.add(new int[]{i, j});
            }
        }
    }

    public static void findBlockGroup() {
        boolean[][] isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j]) continue;
                if (map[i][j] == 0 || map[i][j] == -1 || map[i][j] == EMPTY) continue;

                int color = map[i][j];
                int cnt = 1;
                int rainbow = 0;
                Queue<int[]> que = new LinkedList<>();
                que.add(new int[]{i, j});
                isVisited[i][j] = true;

                while (!que.isEmpty()) {
                    int[] current = que.poll();

                    for (int d = 0; d < 4; d++) {
                        int tx = current[0] + dx[d];
                        int ty = current[1] + dy[d];

                        if (isValidate(tx, ty) && !isVisited[tx][ty]) {
                            if (map[tx][ty] == color || map[tx][ty] == 0) {
                                if (map[tx][ty] == 0) rainbow++;
                                isVisited[tx][ty] = true;
                                que.add(new int[]{tx, ty});
                                cnt++;
                            }
                        }
                    }
                }
                if (cnt > 1) bgPq.add(new BlockGroup(i, j, cnt, rainbow));

                for (int[] r : rainbows) {
                    isVisited[r[0]][r[1]] = false;
                }
            }
        }
    }

    public static void removeBlockGroup(int x, int y) {
        int color = map[x][y];
        Queue<int[]> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][N];
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        while (!que.isEmpty()) {
            int[] current = que.poll();
            map[current[0]][current[1]] = EMPTY;
            for (int d = 0; d < 4; d++) {
                int tx = current[0] + dx[d];
                int ty = current[1] + dy[d];
                if (isValidate(tx, ty) && !isVisited[tx][ty]) {
                    if (map[tx][ty] == color || map[tx][ty] == 0) {
                        isVisited[tx][ty] = true;
                        que.add(new int[]{tx, ty});
                    }
                }
            }
        }

    }

    public static boolean isValidate(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    public static void workGravity() {
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (map[i][j] == -1) continue;
                int gRow = i;
                for (int g = i + 1; g < N; g++) {
                    if (map[g][j] != EMPTY) break;
                    gRow = g;
                }
                if (gRow != i) {
                    map[gRow][j] = map[i][j];
                    map[i][j] = EMPTY;
                }
            }
        }

    }

    public static void rotate() {
        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                map[N - 1 - j][i] = copyMap[i][j];
            }
        }
    }

    static class BlockGroup implements Comparable<BlockGroup> {
        int cnt, x, y, rainbow;

        public BlockGroup(int x, int y, int cnt, int rainbow) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.rainbow = rainbow;
        }

        @Override
        public int compareTo(BlockGroup o) {
            if (o.cnt == this.cnt) {
                if (o.rainbow == this.rainbow) {
                    if (o.x == this.x) return o.y - this.y;
                    else return o.x - this.x;
                } else return o.rainbow - this.rainbow;
            }
            return o.cnt - this.cnt;
        }
    }
}
