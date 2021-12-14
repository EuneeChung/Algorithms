package src;

import java.util.Scanner;

public class Java_15684 {
    static int[][] map;
    static int L, N, H, min = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1}; //좌 우 아래
    static int[] dy = {-1, 1, 0};
    static final int LINE = 1;
    static final int BRIDGE = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt(); // 입력값으로 주어지는 N
        N = 2 * L - 1; // 세로 - 열
        int M = sc.nextInt();
        H = sc.nextInt() + 1; // 가로 - 행
        map = new int[H][N];

        makeLine();

        for (int i = 0; i < M; i++) {
            buildBridge(sc.nextInt()-1, 2 * sc.nextInt() - 1);
        }
        // line의 좌표 => 2(line-1)
        // bridge의 좌표 => 2*line -1
        // line+1의 좌표 => 2*line

        dfs(1, 0, 0, 0);
        if (min > 3) min = -1;
        System.out.print(min);
    }

    static void makeLine() {
        for (int j = 0; j < N; j += 2) {
            for (int i = 0; i < H; i++) {
                map[i][j] = LINE;
            }
        }
    }

    static boolean buildBridge(int ax, int by) {

        if (isValidate(ax, by + 2) && map[ax][by + 2]==BRIDGE) return false;
        // 가로선이 연속되서 있을 수 없어서
        if (isValidate(ax, by - 2) && map[ax][by - 2]==BRIDGE) return false;
        map[ax][by] = BRIDGE;
        return true;
    }

    static void removeBridge(int ax, int by) {

        if (map[ax][by] == BRIDGE) {
            map[ax][by] = 0;
        }
    }

    static boolean isValidate(int x, int y) {
        return (x >= 0 && x < H && y >= 0 && y < N);
    }

    static void dfs(int line, int x, int y, int cnt) {
        // line 1, 2, 3, 4
        // y는 map의 열의 위치
        // x는 행의 위치
        // cnt 추가한 다리 수
        if (cnt > 3) return;
        if (line == L + 1) {
            min = Math.min(min, cnt);
            return;
        }
        if (x == H - 1) {
            if ((line - 1) * 2 == y) {
                dfs(line + 1, 0, 2 * line, cnt);
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (!isValidate(tx, ty)) continue; // 범위를 벗어났거나
            if (map[tx][ty] == BRIDGE ) {
                dfs(line, tx + 1, ty + dy[i], cnt); // x 행 // y 열
                break;
            }

            if (map[tx][ty] == LINE) { // 아래
                dfs(line, tx, ty, cnt);
            } else { // 좌우에 브릿즈를 넣을 수 있을때
                if(buildBridge(tx, ty)){
                    dfs(line, tx + 1, ty + dy[i], cnt + 1);
                    removeBridge(tx, ty);
                }
            }
        }
    }
}
