package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_20057 {
    static int[][] map;
    static int N;
    static int[][][] sandMoveInfos = {
            {{0, -2, 5}, {-1, -1, 10}, {1, -1, 10}, {-2, 0, 2}, {-1, 0, 7}, {1, 0, 7}, {2, 0, 2}, {-1, 1, 1}, {1, 1, 1}, {0, -1}},
            {{0, -2, 2}, {-1, -1, 1}, {1, -1, 10}, {0, -1, 7}, {2, 0, 5}, {-1, 1, 1}, {1, 1, 10}, {0, 1, 7}, {0, 2, 2}, {1, 0}},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        //토네이도 방향으로 돌리기
        int type = 0, x = N / 2, y = N / 2 ;
        int outAmount = 0;
        for (int n = 1; n <= N; n++) {
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < (n==N?n-1:n); i++) {
                    x += dx[type];
                    y += dy[type];
                    outAmount += wind(x, y, type);
                }
                if(n==N) break;
                type++;
                if (type == 4) type = 0;
            }
        }
        System.out.println(outAmount);
    }

    public static int wind(int x, int y, int type) {

        int remainSand = map[x][y];
        int outAmount = 0;
        int left = type == 0 ? 1 : -1;
        int down = type == 1 ? 1 : -1;
        int amount = 0;
        if(type>1) type-=2;
        for (int i = 0; i < 10; i++) {
            int tx = x + sandMoveInfos[type][i][0] * down;
            int ty = y + sandMoveInfos[type][i][1] * left;

            if (i == 9) amount = remainSand;
            else amount = (int) Math.floor(map[x][y] * sandMoveInfos[type][i][2]*0.01);

            if (tx < 0 || ty < 0 || tx >= N || ty >= N) outAmount += amount;
            else map[tx][ty] += amount;

            remainSand -= amount;
        }
        map[x][y] = 0;
        return outAmount;
    }
}
