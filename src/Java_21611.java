import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Java_21611 {
    static ArrayList<Integer> mapList = new ArrayList<>();
    static int bombBeadCnt = 0, N;
    static int[] dx = {0, 1, 0, -1}; // 벽 회전 방향 왼 아래 오 위
    static int[] dy = {-1, 0, 1, 0};
    static int[][] magicIdxs = new int[4][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[][] blizzards = new int[M][2];
        int[] convertD = {0, 3, 1, 0, 2};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            blizzards[i][0] = convertD[Integer.parseInt(st.nextToken())];
            blizzards[i][1] = Integer.parseInt(st.nextToken());
        }

        convertList(map);

        for (int m = 0; m < M; m++) {
            magicBlizzard(blizzards[m][0], blizzards[m][1]);

            while (true) {
                if (!bomb()) break;
            }
            changeBeads();
        }
        System.out.println(bombBeadCnt);

    }

    static public void convertList(int[][] map) {
        mapList.add(0); // 상어 자리

        int x = N / 2;
        int y = N / 2;

        convert:
        for (int i = 2; i < N; i += 2) {
            for (int d = 1; d <= 4; d++) {
                for (int n = 0; n < i; n++) {
                    if (d == 4 || (d == 1 && n == 0)) {
                        x += dx[0];
                        y += dy[0];
                    } else {
                        x += dx[d];
                        y += dy[d];
                    }
                    if (map[x][y] == 0) break convert;
                    mapList.add(map[x][y]);

                }
            }
        }

    }

    static public void magicBlizzard(int d, int s) {
        // 파괴할 인덱스 구하기
//        if (magicIdxs[d] == null) { // 이 친구가... 문제 였구만.....
            magicIdxs[d] = new int[s];
            for (int si = 0; si < s; si++) {
                magicIdxs[d][si] = (int) Math.pow((2 * si + 1), 2) + si + d * 2 * (si + 1);
            }
//        }

        //블리자드 파괴
        for (int j = s - 1; j >= 0; j--) {
            if (mapList.size() > magicIdxs[d][j]) mapList.remove(magicIdxs[d][j]);
        }

    }

    static public boolean bomb() {

        boolean isBomb=false;
        int size = mapList.size();
        int cnt = 1, num = 0;
        for (int i = size - 1; i >= 0; i--) {
            if(i==size-1) {
                num=mapList.get(size-1);
                continue;
            }
            if (num == mapList.get(i)) cnt++;
            else {
                if (cnt >= 4) {
                    for (int c = 0; c < cnt; c++) {
                        mapList.remove(i + 1);
                    }
                    bombBeadCnt += cnt * num;
                    isBomb=true;
                }
                num = mapList.get(i);
                cnt = 1;
            }
        }
//        System.out.println(mapList);
        return isBomb;
    }

    static public void changeBeads() {
        ArrayList<Integer> changeList = new ArrayList<>();
        changeList.add(0);
        int[] beads = new int[2]; //0 -> A 개수 1-> B 구슬 번호

        change:
        for (int i = 1; i < mapList.size(); i++) {
            int num = mapList.get(i);
            if (i == 1) {
                beads[0] = 1;
                beads[1] = num;
            }
            else if (beads[1] == num) beads[0]++;
            else {
                for (int b = 0; b < 2; b++) {
                    if (changeList.size() >= N * N) break change;
                    else changeList.add(beads[b]);
                }
                beads[0] = 1;
                beads[1] = num;
            }
        }
        for (int b = 0; b < 2; b++) {
            if (changeList.size() < N * N&&beads[1]!=0) changeList.add(beads[b]);
        }
        mapList = changeList;
    }
}
