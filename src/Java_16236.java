package src;

import java.util.*;

public class Java_16236 {
    static int N, eatFishCnt;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static Queue<Shark> sharkQueue = new LinkedList<>(); // 상어의 이동 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        int time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    sharkQueue.add(new Shark(i, j, 2));
                }
            }
        }

        while (!sharkQueue.isEmpty()) {
            Shark current = sharkQueue.poll();
            time += bfs(current);
        }
        System.out.print(time);
    }

    static int bfs(Shark current) {
        int time = 0;
        int tx = 0;
        int ty = 0;
        int queSize = 0;
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Shark> pq = new PriorityQueue<>(); // 우선순위 순위 큐
        Queue<Shark> enabledMoveQue = new LinkedList<>();
        // 갈 수 있는 상어 위치르 한번에 모아서 우선순위 큐로 넘겨줄것이다.
        // 기존 BFS 방식에서는 queue.add 로 순서대로 진행하였는데,
        // priority queue 는 add 하는 순간 정렬이 되기때문에
        // 기존의 갔던 위치들을 다 꺼낸 후에 add 해야 하기 떄문에
        // Queue 인 enabledMoveQue 선언

        pq.add(current);
        visited[current.x][current.y] = true;

        while (!pq.isEmpty()) {
            queSize = pq.size();
            for (int i = 0; i < queSize; i++) {
                Shark tmp = pq.poll();

                //먹을 수 있는 물고기가 있는지 확인 --> 있다면 시간 반환
                int fishSize = map[tmp.x][tmp.y];
                if (fishSize > 0 && fishSize < tmp.size) {
                    eatFishCnt++;
                    if (eatFishCnt == tmp.size) {
                        sharkQueue.add(new Shark(tmp.x, tmp.y, tmp.size + 1));
                        eatFishCnt=0; //자신의 사이즈만큼 먹은 후, 먹은 물고기 수 초기화
                    } else sharkQueue.add(new Shark(tmp.x, tmp.y, tmp.size));
                    map[tmp.x][tmp.y] = 0;
                    return time;
                }

                for (int d = 0; d < dx.length; d++) {
                    tx = tmp.x + dx[d];
                    ty = tmp.y + dy[d];

                    if (tx < 0 || tx >= N || ty < 0 || ty >= N || visited[tx][ty]) continue;
                    if (map[tx][ty] > tmp.size) continue; //자신보다 크기가 큰 물고기가 있을 경우는 지나가지 못함.
                    visited[tx][ty] = true;
                    enabledMoveQue.add(new Shark(tx, ty, tmp.size)); // queue에 등록
                }
            }
            pq.addAll(enabledMoveQue);
            // 이전에 가능성 있는 상어의 위치들을 다 검증한 후에, 새로 갈 수 있는 위치들을 추가
            enabledMoveQue.clear();
            // 다음번 갈 수 있는 위치들을 추가하기 위해 초기화

            time++;
        }
        return 0;
    }

    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int size;

        Shark(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.x > o.x) return 1;
            else if (this.x < o.x) return -1;
            return this.y - o.y;
        }
    }
}
