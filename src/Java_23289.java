import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_23289 {
    static int R, C, K;
    static int[][] map;
    static final int WALL = -1;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] spreadD = {-2, 0, 2};
    static int[][] wallSpreadDx = {{-1, -2}, {0}, {1, 2}};
    static int[][] wallSpreadDy = {{0, 1}, {1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) * 2 - 1;
        C = Integer.parseInt(st.nextToken()) * 2 - 1;
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        ArrayList<Heater> heaterList = new ArrayList<>();
        ArrayList<int[]> checkList = new ArrayList<>();
        for (int i = 0; i < R; i += 2) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j += 2) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 0) continue;
                if (type < 5) heaterList.add(new Heater(i, j, type-1));
                else checkList.add(new int[]{i, j});
            }
        }
        int wallCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < wallCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = (Integer.parseInt(st.nextToken()) - 1) * 2;
            int y = (Integer.parseInt(st.nextToken()) - 1) * 2;
            int type = Integer.parseInt(st.nextToken());
            if (type == 0) x -= 1;
            else y += 1;
            map[x][y] = WALL;
        }

        int chocolate = 0;

        while (!isHigherThanK(checkList)) {
            if (chocolate > 100) {
                chocolate = 101;
                break;
            }
            for (Heater h : heaterList) {
                turnOnHeater(h);
            }
            adjust();
            reduceEdge();
            chocolate++;
        }
        System.out.println(chocolate);
    }

    static void turnOnHeater(Heater heater) {
        Queue<Room> que = new LinkedList<>();
        boolean[][] isVisited = new boolean[R][C];
        int dir = heater.dir;
        int k = 5;
        int startX = heater.x + dx[dir] * 2;
        int startY = heater.y + dy[dir] * 2;
        que.add(new Room(startX, startY));
        isVisited[startX][startY] = true;
        map[startX][startY] += k;

        while (!que.isEmpty()) {
            int size = que.size();
            if (k == 0) break;
            k--;
            for (int i = 0; i < size; i++) {
                Room r = que.poll();
                spreadRoom:
                for (int d = 0; d < 3; d++) {
                    int tx = r.x, ty = r.y;
                    if (dir < 2) {
                        tx += spreadD[d];
                        ty += (dir == 1 ? -2 : 2);
                    } else {
                        tx += (dir == 2 ? -2 : 2);
                        ty += spreadD[d];
                    }
                    if (isValidate(tx, ty) && !isVisited[tx][ty]) {
                        for (int w = 0; w < wallSpreadDx[d].length; w++) {
                            int wx, wy;
                            if (dir < 2) {
                                wx = r.x + wallSpreadDx[d][w];
                                wy = r.y + wallSpreadDy[d][w] * (dir == 1 ? -1 : 1);
                            } else {
                                wx = r.x + wallSpreadDy[d][w] * (dir == 2 ? -1 : 1);
                                wy = r.y + wallSpreadDx[d][w];
                            }
                            if (map[wx][wy] == WALL) continue spreadRoom;
                        }
                        que.add(new Room(tx, ty));
                        map[tx][ty] += k;
                        isVisited[tx][ty] = true;
                    }
                }
            }
        }
    }
    static void adjust() {
        int[][] originMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            System.arraycopy(map[i], 0, originMap[i], 0, C);
        }

        for (int i = 0; i < R; i += 2) {
            for (int j = 0; j < C; j += 2) {
                for (int d = 0; d < 4; d++) {
                    int tx = i + dx[d];
                    int ty = j + dy[d];
                    if (isValidate(tx, ty) && map[tx][ty] != WALL) {
                        tx += dx[d];
                        ty += dy[d];
                        if (originMap[i][j] > originMap[tx][ty]) {
                            int dif = (originMap[i][j] - originMap[tx][ty]) / 4;
                            map[i][j] -= dif;
                            map[tx][ty] += dif;
                        }
                    }
                }
            }
        }

    }

    static void reduceEdge() {
        for (int i = 0; i < R; i += R - 1) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) map[i][j] -= 1;
            }
        }
        for (int j = 0; j < C; j += C - 1) {
            for (int i = 1; i < R-1; i++) {
                if (map[i][j] > 0) map[i][j] -= 1;
            }
        }
    }

    static boolean isHigherThanK(ArrayList<int[]> list) {
        for (int[] room : list) {
            if (map[room[0]][room[1]] < K) return false;
        }
        return true;
    }

    static boolean isValidate(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    static class Heater {
        int x, y, dir;

        public Heater(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static class Room {
        int x, y;

        public Room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
