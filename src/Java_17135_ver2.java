package src;

import java.util.*;

public class Java_17135_ver2 {
    static int N, M, D;
    static boolean[][] originMap;
    static boolean[][] map;
    static int[] archers = new int[3];
    static Set<Pos> enemySet = new HashSet<>();
    static int maxKillCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        originMap = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sc.nextInt() == 1) originMap[i][j] = true;
                else originMap[i][j] = false;
            }
        }
        comb(0, 0);
        System.out.print(maxKillCnt);
    }

    public static void comb(int start, int cnt) {
        if (cnt >= 3) {
            int killCnt = attackEnemy();
            maxKillCnt = Math.max(maxKillCnt, killCnt);
            return;
        }
        if (start == M) return;
        for (int i = start; i < M; i++) {
            archers[cnt] = i;
            comb(i + 1, cnt + 1);
        }
    }

    public static int attackEnemy() {
        enemySet.clear();
        initMap();

        for (int x = N; x > 0; x--) {
            // 적이 N 칸에 도달하면 잡을 수 없음
            // => 턴이 지날때마다 장벽이 내려간다로 접근
            for (int a = 0; a < 3; a++) { // 궁수 3명
                shoot(x, archers[a]);
            }

            for (Pos enemy : enemySet) {
                map[enemy.x][enemy.y] = false;
            }
        }

        return enemySet.size();
    }

    public static void initMap() {
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = originMap[i][j];
            }
        }
    }

    public static void shoot(int x, int y) {
        for (int d = 1; d <= D; d++) {

            for (int dy = d - 1; dy >= 0; dy--) {
                int tx = x - (d - dy);
                int ty = y - dy;
                if (tx < 0 || ty < 0 || ty >= M || tx>=N) continue;
                if (map[tx][ty]) {
                    enemySet.add(new Pos(tx, ty));
                    return;
                }
            }

            for (int dy = 1; dy < d; dy++) {
                int tx = x - (d - dy);
                int ty = y + dy;
                if (tx < 0 || ty < 0|| ty >= M|| tx>=N) continue;
                if (map[tx][ty]) {
                    enemySet.add(new Pos(tx, ty));
                    return;
                }
            }
        }
    }


static class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pos pos = (Pos) o;
        return x == pos.x && y == pos.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}

    public static void print() {
        System.out.println(Arrays.toString(archers));
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println(enemySet.size());
    }
}
