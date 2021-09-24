package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_17144 {
    static int[][] map1;
    static int[][] map2;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, -0, -1};
    static int airTopPos = -1, airBottomPos = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        map1 = new int[N][M];
        map2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map1[i][j] = Integer.parseInt(st.nextToken());
                if (map1[i][j] == -1) {
                    if (airTopPos == -1) airTopPos = i;
                    else airBottomPos = i;
                }
            }
        }

        for (int t = 1; t <= T; t++) {
            if (t % 2 == 1) rotate(spread(map1, map2));
            else rotate(spread(map2, map1));

            dx[0] = -1;
            dx[2] = 1;

        }
        if (T % 2 == 1) System.out.print(count(map2));
        else System.out.print(count(map1));

    }

    static int[][] spread(int[][] map, int[][] spreadMap) {
        // map 이 오리지널
        // spreadMap 이 확산
        for (int i = 0; i < N; i++) {
            Arrays.fill(spreadMap[i], 0);
        }
        spreadMap[airTopPos][0] = -1;
        spreadMap[airBottomPos][0] = -1;
        int spreadCnt = 0;
        int sAmount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    spreadCnt = 0;
                    sAmount = map[i][j] / 5;
                    for (int d = 0; d < 4; d++) {
                        int tx = i + dx[d];
                        int ty = j + dy[d];

                        if (tx < 0 || tx >= N || ty < 0 || ty >= M || map[tx][ty] == -1) continue;

                        spreadCnt++;
                        spreadMap[tx][ty] += sAmount;
                    }
                    spreadMap[i][j] += (map[i][j] - spreadCnt * sAmount);
                }

            }
        }

        return spreadMap;
    }

    static void rotate(int[][] map) {
        int tx = 0, ty = 0;

        boolean flag;
        for (int a = 0; a < 2; a++) {
            flag = true;
            int ax = (a == 0) ? airTopPos - 1 : airBottomPos + 1;
            int ay = 0;
            int d = 0;
            if (a == 1) {
                dx[0] = 1;
                dx[2] = -1;
            }
            // 대입을 쉽게 하기 위해
            // 순환하는 방향과 반대로 진행
            while (true) {
                tx = ax + dx[d];
                ty = ay + dy[d];
                if (flag && a == 0 && tx == airTopPos) {
                    d++;
                    flag = false;
                }
                if (flag && a == 1 && tx == airBottomPos) {
                    d++;
                    flag = false;
                }


                if (tx < 0 || tx >= N || ty < 0 || ty >= M) {
                    d++;
                    continue;
                }

                if (a == 0 && tx == airTopPos && ty == 0) {
                    map[ax][ay] = 0;
                    break;
                }
                if (a == 1 && tx == airBottomPos && ty == 0) {
                    map[ax][ay] = 0;
                    break;
                }

                map[ax][ay] = map[tx][ty];
                ax = tx;
                ay = ty;
            }

        }

    }

    static int count(int[][] map) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1) sum += map[i][j];
            }
        }
        return sum;
    }
}
