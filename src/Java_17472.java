package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java_17472 {
    static int[][] map;
    static int[][] adjMatrix;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[] minEdge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        List<int[]> start = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int islandCnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    start.add(new int[]{i, j});
                    bfs(i, j, islandCnt);
                    islandCnt++;
                }
            }
        }
        islandCnt--;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
        minEdge = new int[islandCnt];
        adjMatrix = new int[islandCnt][islandCnt];
        for (int i = 0; i < islandCnt; i++) {
            adjMatrix[i] = getBridge(start.get(i)[0], start.get(i)[1], islandCnt);
            minEdge[i] = Integer.MAX_VALUE;
        }

        System.out.print(prim(islandCnt));

    }

    private static void bfs(int i, int j, int islandCnt) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i, j});
        map[i][j] = islandCnt;
        while (!que.isEmpty()) {
            int[] current = que.poll();
            for (int d = 0; d < 4; d++) {
                int tx = current[0] + dx[d];
                int ty = current[1] + dy[d];
                if (tx >= N || tx < 0 || ty >= M || ty < 0) continue;
                if (!visited[tx][ty] && map[tx][ty] > 0) {
                    map[tx][ty] = islandCnt;
                    visited[tx][ty] = true;
                    que.add(new int[]{tx, ty});
                }
            }
        }
    }

    private static int[] getBridge(int i, int j, int islandCnt) {
        int[] connect = new int[islandCnt];
        Arrays.fill(connect, Integer.MAX_VALUE);
        int currentNum = map[i][j];

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i, j});
        while (!que.isEmpty()) {
            int size = que.size();
            for (int k = 0; k < size; k++) {
                int[] current = que.poll();

                // 연결되어있는지 확인
                for (int d1 = 0; d1 < 4; d1++) {
                    int length = 0;
                    int dept = 0;
                    int findX = current[0];
                    int findY = current[1];
                    while (true) {
//                            if(map[findX][findY] != 0) break;
                        findX = findX + dx[d1];
                        findY = findY + dy[d1];
                        if (findX >= N || findX < 0 || findY >= M || findY < 0 || map[findX][findY] == currentNum) {
                            length = -1;
                            break;
                        }
                        if (map[findX][findY] > 0 && map[findX][findY] != currentNum) {
                            dept = map[findX][findY] - 1;
                            break;
                        }
                        length++;
                    }
                    if (length >= 2) {
                        connect[dept] = Math.min(connect[dept], length);
                    }
                }

                for (int d = 0; d < 4; d++) {
                    int tx = current[0] + dx[d];
                    int ty = current[1] + dy[d];
                    if (tx >= N || tx < 0 || ty >= M || ty < 0) continue;
                    if (!visited[tx][ty] && map[tx][ty] == currentNum) {
                        visited[tx][ty] = true;
                        que.add(new int[]{tx, ty});
                    }
                }
            }
        }
        return connect;
    }
    private static int prim(int islandCnt) {
        int result = 0;
        minEdge[0] = 0;
        boolean[] visitedAdj = new boolean[islandCnt];
        for (int i = 0; i < islandCnt; i++) {
            // 1. 신장트리에 포함되지 않은 정점 중 최소 간선 비용의 정점 찾기
            int min = Integer.MAX_VALUE;
            int minVertex = -1; // 최소 간선 비용의 정점 번호

            for (int j = 0; j < islandCnt; j++) {
                if (!visitedAdj[j] && min > minEdge[j]) { // 신장트리에 포함되지 않은 정점
                    min = minEdge[j];
                    minVertex = j;
                }
            }
            if(minVertex==-1) return -1;

            visitedAdj[minVertex] = true; // 신장트리에 포함시킴
            result += min; // 간선비용 누적

            // 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
            for (int j = 0; j < islandCnt; j++) {
                if (!visitedAdj[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
                    // adjMatrix[minVertex][j] != 0 연결되지 않았으면 0임
                    minEdge[j] = adjMatrix[minVertex][j];
                }
            }
        }
        return result;
    }
}
