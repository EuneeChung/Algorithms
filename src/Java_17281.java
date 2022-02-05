import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_17281 {
    static int N, max = 0;
    static int[] orders = new int[9];
    static boolean[] isSelected = new boolean[9];
    static int[][] map;
    static int[][] hitResults;
    static boolean[] bases = new boolean[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][9];
        hitResults = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        orders[3] = 0;
        isSelected[0] = true;
        perm(0);
        System.out.println(max);
    }

    static void perm(int idx) {
        if(idx==3) {
            perm(4);
            return;
        }
        if (idx == 9) {
            setHitOrder();
            max = Math.max(max, startGame());

            return;
        }
        for (int i = 1; i < 9; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            orders[idx] = i;
            perm(idx + 1);
            isSelected[i] = false;
        }
    }

    static void setHitOrder() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 9; j++) {
                hitResults[i][j] = map[i][orders[j]];
            }
        }
    }

    static int startGame() {
        int score = 0, outNum = 0, hitter = 0, inning = 0;
        while (true) {
            if (inning == N) break;
            if(hitter == 9) hitter=0;
            if (hitResults[inning][hitter] == 0) outNum++;
            else score += hit(hitResults[inning][hitter]);
            hitter++;
            if (outNum == 3) {
                outNum = 0;
                inning++;
                Arrays.fill(bases, false);
                continue;
            }

        }
        return score;
    }

    static int hit(int hitNum) {
        int cnt = 0;
        for (int i = 0; i < hitNum; i++) {
            for (int j = 2; j >=0 ; j--) {
                bases[j+1] = bases[j];
            }
            if (i == 0) bases[0] = true;
            else bases[0]=false;
            if (bases[3]) cnt++;
        }
        bases[3]=false;
        return cnt;
    }
}
