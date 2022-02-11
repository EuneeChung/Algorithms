import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Java_20058 {
    static int N;
    static int[][] map;
    static int[] dx = {-1,0, 1, 0};
    static int[] dy = { 0,1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        N = (int) Math.pow(2, N);
        map = new int[N][N];
        int[] ls = new int[Q];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            ls[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < Q; i++) {
            fireStorm((int)Math.pow(2,ls[i]));
            melt();
        }
        System.out.println(countIce());
        System.out.println(countMass());
    }

    public static void fireStorm(int length) {
        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                copyMap[i][j]=map[i][j];
            }
        }

        for (int i = 0; i < N; i += length) {
            for (int j = 0; j < N; j += length) {
                //rotate
                for (int a = 0; a < length; a ++) {
                    for (int b = 0; b < length; b ++) {
                        int ta = b;
                        int tb = (length-1)-a;
                        map[i+ta][j+tb]=copyMap[i+a][j+b];
                    }
                }
            }
        }
    }

    public static void melt() {
        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                copyMap[i][j]=map[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                if(map[i][j]==0) continue;
                for (int d = 0; d < 4; d++) {
                    int tx = i + dx[d];
                    int ty = j + dy[d];
                    if (isValidate(tx, ty) && copyMap[tx][ty] > 0) {
                        cnt++;
                    }
                }
                if (cnt < 3) map[i][j]--;
            }
        }
    }

    public static int countIce() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += map[i][j];
            }
        }
        return cnt;
    }

    public static int countMass() {
        ArrayList<Integer> massList = new ArrayList<>();
        massList.add(0);
        boolean[][] isVisited = new boolean[N][N];
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isVisited[i][j]) continue;
                isVisited[i][j] = true;
                if (map[i][j] <= 0) continue;

                int cnt = 1;
                que.add(new int[]{i, j});
                while (!que.isEmpty()) {
                    int[] current = que.poll();
                    for (int d = 0; d < 4; d++) {
                        int tx = current[0] + dx[d];
                        int ty = current[1] + dy[d];
                        if (isValidate(tx, ty) && !isVisited[tx][ty] && map[tx][ty] > 0) {
                            que.add(new int[]{tx, ty});
                            cnt++;
                            isVisited[tx][ty]=true;
                        }
                    }
                }
                massList.add(cnt);
            }
        }

        return Collections.max(massList);
    }

    static boolean isValidate(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}
