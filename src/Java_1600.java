package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_1600 {
    static int K;
    static int W; // 가로 - y
    static int H;// 세로 - x

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        W = sc.nextInt(); // 가로 - y
        H = sc.nextInt(); // 세로 - x

        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.print(bfs(map));
    }

    private static int bfs(int[][] map) {
        boolean[][][] visited = new boolean[H][W][K + 1];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[] dx2 = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy2 = {1, 2, 2, 1, -1, -2, -2, -1};

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, 0});
        int time = 0;
        int queSize = 0;
        boolean isCompleted = false;


        arrival: while (!que.isEmpty()) {
            queSize = que.size();
            for (int s = 0; s < queSize; s++) {
                int[] monkey = que.poll();
                if (monkey[0] == H - 1 && monkey[1] == W - 1) {
                    isCompleted=true;
                    break arrival;
                }
                int tx = 0;
                int ty = 0;
                // 1칸씩 움직이는 동작
                for (int d = 0; d < dx.length; d++) {
                    tx = monkey[0] + dx[d];
                    ty = monkey[1] + dy[d];

                    if (!isValidate(tx, ty)) continue;
                    if (visited[tx][ty][monkey[2]]) continue;
                    if (map[tx][ty] == 1) continue;

                    visited[tx][ty][monkey[2]] = true;
                    que.add(new int[]{tx, ty, monkey[2]});
                }

                // 말처럼 2칸씩 뛰어가는 동작- k번 미만 사용했을때 가능
                if (monkey[2] < K) {
                    for (int d = 0; d < dx2.length; d++) {
                        tx = monkey[0] + dx2[d];
                        ty = monkey[1] + dy2[d];

                        if (!isValidate(tx, ty)) continue;
                        if (visited[tx][ty][monkey[2] + 1]) continue;
                        if (map[tx][ty] == 1) continue;

                        visited[tx][ty][monkey[2] + 1] = true;
                        que.add(new int[]{tx, ty, monkey[2] + 1});
                    }
                }
            }
            time++;
        }
        return isCompleted? time : -1;
    }

    private static boolean isValidate(int x, int y) {
        return x < H && x >= 0 && y < W && y >= 0;
    }
}
