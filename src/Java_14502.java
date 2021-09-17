package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java_14502 {
    static char[][] map;
    static ArrayList<Integer> virus = new ArrayList<>();
    static ArrayList<Integer> zeros = new ArrayList<>();
    static int[] walls = new int[3];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == '0') zeros.add(i * M + j);
                if (map[i][j] == '2') virus.add(i * M + j);
            }
        }
        buildWall(0, 0);
        System.out.print(max);
    }

    private static void buildWall(int start, int cnt) {
        if (cnt == 3) {
            // 2 바이러스 퍼진 후
            max = Math.max(max,spreadVirus());
            if(max==30) System.out.println(Arrays.toString(walls));
            // 0의 갯수 새기
            return;
        }
        for (int j = start; j < zeros.size(); j++) {
            walls[cnt] = zeros.get(j);
            buildWall(j + 1, cnt + 1);
        }
    }

    private static int spreadVirus() {
        int n = map.length;
        int m = map[0].length;
        int spreadCount = 0;

        char[][] tmpMap = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmpMap[i][j] = map[i][j];
            }
        }

        for (int wall : walls) {
            tmpMap[wall / m][wall % m] = '1';
        }

        Queue<Integer> que = new LinkedList<>();
        for (Integer v : virus) {
            que.add(v);
        }
        while (!que.isEmpty()) {
            int virus = que.poll();
            int vx = virus / m;
            int vy = virus % m;

            for (int i = 0; i < 4; i++) {
                int tx = vx + dx[i];
                int ty = vy + dy[i];
                int idx = tx * m + ty;
                if (tx < 0 || tx >= n || ty < 0 || ty >= m) continue;
                if (tmpMap[tx][ty] == '0') {
                    tmpMap[tx][ty] = '2';
                    spreadCount++;
                    que.add(idx);
                }
            }
        }

        return zeros.size() - spreadCount-3;
    }


}
