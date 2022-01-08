package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java_17142 {
    static int[][] virus;
    static int[][] map;
    static ArrayList<int[]> inactiveList = new ArrayList<>();
    static final int wall = 1000;
    static final int inactive = -1000;
    static final int active = 3000;
    static int N, M, min,cntEmpty;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virus = new int[M][2];
        map = new int[N][N];
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) cntEmpty++;
                if (map[i][j] == 1) map[i][j] = wall;
                if (map[i][j] == 2) {
                    inactiveList.add(new int[]{i ,j});
                    map[i][j] = inactive;
                }

            }
        }
        if (cntEmpty==0) min = 0;
        else {
            comb(0, 0);
            if (min == Integer.MAX_VALUE) min = -1;
        }
        System.out.println(min);
    }

    static void comb(int start, int cnt) {
        if (cnt == M) {
            for (int[] a: virus) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println();
            min = Math.min(min, bfs());
            return;
        }
        if (start == inactiveList.size()) return;
        for (int i = start; i < inactiveList.size(); i++) {
            virus[cnt] = inactiveList.get(i);
            comb(i + 1, cnt + 1);
        }
    }

    static int bfs() {
        int time = 1;
        int empty=cntEmpty;
        Queue<int[]> que = new LinkedList<>();
        int[][] visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, visited[i], 0, N);
        }

        for (int[] pos : virus) {
            visited[pos[0]][pos[1]] = active;
            que.add(new int[]{pos[0], pos[1]});
        }
        while (!que.isEmpty() && empty!=0) {
            int size = que.size();
            if(min<=time) return min;
            for (int i = 0; i < size; i++) {
                int[] current = que.poll();
                for (int d = 0; d < 4; d++) {
                    int tx = current[0] + dx[d];
                    int ty = current[1] + dy[d];
                    if (tx < 0 || tx >= N || ty < 0 || ty >= N || visited[tx][ty] > 0) continue;
                    if(visited[tx][ty]==0) empty--;
                    que.add(new int[]{tx, ty});
                    visited[tx][ty] = time;
                }
            }
            time++;
        }
        if (empty!=0) return Integer.MAX_VALUE;
        return --time;
    }

}
