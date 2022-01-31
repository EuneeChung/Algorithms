import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_20056 {
    static int N;
    static Queue<FireBall>[][] queMap;
    static Queue<FireBall> fireBallList = new LinkedList<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        queMap = new LinkedList[N][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            fireBallList.add(new FireBall(x, y, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));

        }
        for (int k = 0; k < K; k++) {
            move();
            mergeSplit();
        }
        System.out.println(getMass());
    }
    static void move() {
        queMap = new LinkedList[N][N];
        int size = fireBallList.size();
        for (int s = 0; s < size; s++) {
            FireBall fireBall = fireBallList.poll();
            int tx = (fireBall.x + dx[fireBall.dir] * fireBall.speed+N*1000) % N;
            int ty = (fireBall.y + dy[fireBall.dir] * fireBall.speed+N*1000) % N;
            if (queMap[tx][ty] == null) {
                Queue<FireBall> que = new LinkedList<>();
                queMap[tx][ty] = que;
            }
            fireBall.x =tx;
            fireBall.y=ty;
            queMap[tx][ty].add(fireBall);
            fireBallList.add(fireBall);
        }
    }

    static void mergeSplit() {
        fireBallList.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queMap[i][j] != null){
                    if(queMap[i][j].size() >= 2) {
                        int cnt = queMap[i][j].size();
                        FireBall first = queMap[i][j].poll();
                        int mass = first.mass, speed = first.speed;
                        int isAllOddOrEven = 0;
                        int firstType = first.dir % 2;

                        while (!queMap[i][j].isEmpty()) {
                            FireBall fireBall = queMap[i][j].poll();
                            if (firstType != fireBall.dir % 2) isAllOddOrEven = 1;
                            mass += fireBall.mass;
                            speed += fireBall.speed;
                        }
                        if (mass / 5 > 0) {
                            mass /= 5;
                            speed /= cnt;
                            for (int d = 0; d < 4; d++) {
                                FireBall div = new FireBall(i, j, mass, speed, d * 2 + isAllOddOrEven);
                                queMap[i][j].add(div);
                                fireBallList.add(div);
                            }
                        }
                    }
                    else fireBallList.add(queMap[i][j].peek());
                }
            }
        }
    }

    static int getMass() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queMap[i][j] != null) {
                    while (!queMap[i][j].isEmpty()) {
                        FireBall fireBall = queMap[i][j].poll();
                        sum += fireBall.mass;
                    }
                }
            }
        }
        return sum;
    }

    static class FireBall {
        int x, y, mass, speed, dir;

        public FireBall(int x, int y, int mass, int speed, int dir) {
            this.x = x;
            this.y = y;
            this.mass = mass;
            this.speed = speed;
            this.dir = dir;
        }
    }
}
