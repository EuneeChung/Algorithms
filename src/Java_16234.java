package src;

import java.util.*;

public class Java_16234 {
    static int N, L, R;
    static int[][] map;
    static int[] parent;
    static Map<Integer, ArrayList> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        System.out.print(movePopulation());
    }
// 1. union set 알고리즘을 활용
// 2. 인접해있고, 같은 무리라면 `union` 으로 합치면서 한바퀴 돌기
// 3. 다시 한 바퀴 돌면서 `HashMap` 자료구조를 이용하여 key : 부모의 인덱스 value : key를 부모로 가지는 자식인덱스들을 줄줄이 추가
// 4. `while (hashMap.size() < N * N)`  연합이 한개라도 없다면 `HashMap` 의 부모의 크기가 N*N 일거다.
// 5. `HashMap`을 key 중심으로 한바퀴 돌면서 (value인 부모가 같은 자식들의 어레이리스트)의 사이즈가 1 (본인) 이상일 경우에 sum 과 각 국가들이 가질 수 있는 인구 이동
// 6. 다시 탐색하면서 연합이 없을때까지 2-5 반복

    private static int movePopulation() {
        int dayCnt = 0;

        bfs();

        // 6. 다시 탐색하면서 연합이 없을때까지 2-5 반복
        while (hashMap.size() < N * N) { //4. `while (hashMap.size() < N * N)`  연합이 한개라도 없다면 `HashMap` 의 부모의 크기가 N*N 일거다.
            dayCnt++;
            // 5. `HashMap`을 key 중심으로 한바퀴 돌면서 (value인 부모가 같은 자식들의 어레이리스트)의 사이즈가 1 (본인) 이상일 경우에 sum 과 각 국가들이 가질 수 있는 인구 이동
            for (Integer key : hashMap.keySet()) {
                ArrayList<Integer> que = hashMap.get(key); // 키값을 부모로 가진 자식들의 어레이
                int queSize = que.size();
                if (queSize <= 1) continue;
                int sum = 0;
                // 연합의 인구 합 구하기
                for (int i = 0; i < queSize; i++) {
                    int tmp = que.get(i);
                    sum += map[tmp / N][tmp % N];
                }

                int people = sum / queSize;
                // 연합에 인구 할당
                for (int i = 0; i < queSize; i++) {
                    int tmp = que.get(i);
                    map[tmp / N][tmp % N] = people;
                }
            }
            bfs();
        }
        return dayCnt;
    }

    private static int find(int a) {
        if (a == parent[a])
            return a; // 자신이 대표자
        return parent[a] = find(parent[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 변경한다.
    }

    private static void make() {
        parent = new int[N * N];
        // 모든 원소를 자신을 대표로 만듦.
        for (int i = 0; i < N * N; i++) {
            parent[i] = i;
        }
    }

    // 두 원소를 하나의 집합으로 합치기
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return false; // 이미 같은 집합으로 합치지 않는다.
        parent[bRoot] = aRoot;
        return true;
    }

    static void bfs() {
        hashMap.clear();
        make();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int tx = i + dx[k];
                    int ty = j + dy[k];

                    if (tx < 0 || tx >= N || ty < 0 || ty >= N) continue;
                    int dif = Math.abs(map[i][j] - map[tx][ty]);
                    if (dif >= L && dif <= R) {
                        // 2. 인접해있고, 같은 무리라면 `union` 으로 합치면서 한바퀴 돌기
                        // 인접한 국가와 인구의 차이가 L 이상 R 이하면 union
                        union(i * N + j, tx * N + ty);
                    }
                }
            }
        }
        // 3. 다시 한 바퀴 돌면서 `HashMap` 자료구조를 이용하여 key : 부모의 인덱스 value : key를 부모로 가지는 자식인덱스들을 줄줄이 추가
        int p = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                p = find(i * N + j);
                if (!hashMap.containsKey(p)) hashMap.put(p, new ArrayList<>());
                hashMap.get(p).add(i * N + j); //  부모의 인덱스를 키 값, value 로 자식들의 어레이에 추가
            }
        }
    }
}