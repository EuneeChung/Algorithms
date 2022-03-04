import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_19237 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] priority;
    static int N, K;
    static Queue<Shark> sharksQueue = new LinkedList<>();
    static Shark[] sharks;
    static Room[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new Room[N][N];
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken())+1;
        sharks = new Shark[M];
        priority = new int[M * 4][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int shark = Integer.parseInt(st.nextToken());
                Room r = new Room(shark, 0);
                if (shark > 0) {
                    sharks[shark - 1] = new Shark(i, j, shark, 0);
                    r.smell = K;
                }
                map[i][j] = r;
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sharks[i].dir = Integer.parseInt(st.nextToken()) - 1;
        }
        for (int i = 0; i < M * 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                priority[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        sharksQueue.addAll(Arrays.asList(sharks));

        int time = 0;
        while (sharksQueue.size() > 1) {
            if (time >= 1000) {
                time = -1;
                break;
            }

            reduceSmell();
            move();
            time++;
//            print(time);
        }
        System.out.println(time);
    }

    static void reduceSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].smell > 0) map[i][j].smell--;
                if (map[i][j].smell == 0) map[i][j].shark = 0;
            }
        }
    }

    static void move() {
        Room[][] origin = new Room[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N ; j++) {
                origin[i][j] = new Room(map[i][j].shark,map[i][j].smell);
            }
        }

        int size = sharksQueue.size();
        for (int i = 0; i < size; i++) {
            Shark s = sharksQueue.poll();

            int priorityIdx = (s.num - 1) * 4 + s.dir;
            int x = s.x, y = s.y;
            int roomType = 0; // 0이 아무것도 해당 x , 1이 빈칸, 2가 자신의 냄새가 남은 자리를 찾은 경우
            for (int d = 0; d < 4; d++) {
                int tx = x + dx[priority[priorityIdx][d]];
                int ty = y + dy[priority[priorityIdx][d]];

                if (tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
                if (origin[tx][ty].smell == 0 || origin[tx][ty].smell == K) {
                    roomType = 1;
                    s.x = tx;
                    s.y = ty;
                    s.dir = priority[priorityIdx][d];
                    break;
                }
                if (roomType != 2 && origin[tx][ty].shark == s.num) {
                    roomType = 2;
                    s.x = tx;
                    s.y = ty;
                    s.dir = priority[priorityIdx][d];
                }
            }
            if (map[s.x][s.y].smell != K) {
                sharksQueue.add(s);
                map[s.x][s.y].shark = s.num;
                map[s.x][s.y].smell = K;
            }
        }
    }

//    static void print(int time) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(time).append("\n");
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                sb.append("[").append(map[i][j].shark).append(map[i][j].smell).append("] ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }

    static class Shark {
        int x, y, num, dir;

        public Shark(int x, int y, int num, int dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }

    static class Room {
        int shark, smell;

        public Room(int shark, int smell) {
            this.smell = smell;
            this.shark = shark;
        }
    }
}
