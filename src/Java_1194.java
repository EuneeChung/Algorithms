package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_1194 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '0') {
                    x = i;
                    y = j;
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(bfs(x, y, map));
    }

    static int bfs(int startX, int startY, char[][] map) {
        boolean[][][] visited = new boolean[N][M][64]; // 2^6=64
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int moveCnt = 0;
        Queue<Move> que = new LinkedList<>();
        que.add(new Move(startX, startY, 0));
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Move current = que.poll();
                if (map[current.x][current.y] == '1') {
                    return moveCnt;
                }
                for (int d = 0; d < 4; d++) {
                    int tx = current.x + dx[d];
                    int ty = current.y + dy[d];
                    if (tx < 0 || tx >= N || ty < 0 || ty >= M || visited[tx][ty][current.key]) continue;

                    if (map[tx][ty] == '#') continue;
                    if (Character.isUpperCase(map[tx][ty])) {
                        if ((current.key & (1 << (map[tx][ty] - 'A'))) <= 0) continue;
                    }
                    if (Character.isLowerCase(map[tx][ty])) {
//                        boolean[] newKeySet = Arrays.copyOf(current.key,6);
//                        newKeySet[map[tx][ty]-'a']=true;
                        int newKey = 1 << (map[tx][ty] - 'a') | current.key;
                        que.add(new Move(tx, ty, newKey));
                        visited[tx][ty][newKey] = true;
                        continue;
                    }
                    visited[tx][ty][current.key] = true;
                    que.add(new Move(tx, ty, current.key));
                }
            }
            moveCnt++;
        }
        return -1;
    }

    static class Move {
        int x, y, key;
        //        boolean[] key=new boolean[6];
        public Move(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }
}
