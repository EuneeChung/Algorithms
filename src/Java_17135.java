package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_17135 {
    static int[] archers = new int[3];
    static int max = Integer.MIN_VALUE, cntKill;
    static int N, M, D;
    static boolean[][] originMap;
    static boolean[][] map; // true 는 적의 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        originMap = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                originMap[n][m] = sc.nextInt() != 0;
            }
        }

        combArcherPosition(0, 0);
        System.out.print(max);
    }

    static void combArcherPosition(int cnt, int start) {
        if (cnt == 3) {
            startGame(archers);
            return;
        }
        for (int i = start; i < M; i++) {
            archers[cnt] = i;
            combArcherPosition(cnt + 1, i + 1);
        }
    }

    static void startGame(int[] archersPos) {
        ArrayList<int[]> candidateKill = new ArrayList();
        cntKill = 0;
        // map 복사
        map = new boolean[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                map[n][m] = originMap[n][m];
            }
        }

        for (int t = N; t >= 1; t--) { // turn
            candidateKill.clear();
            archer:for (int n = 0; n < 3; n++) {// 궁수 3명
                for (int d = 1; d <= D; d++) {// 거리
                    int reachX; // 턴
                    int reachY;
                    for (int j = d-1; j >=0; j--) {
                        reachX = t - (d - j); // 턴
                        reachY = archersPos[n] - j; // 왼쪽 먼저 탐샛
                        if (reachX >= 0 && reachX < t && reachY >= 0 && reachY < M) {
                            if (map[reachX][reachY]) {
                                candidateKill.add(new int[]{reachX,reachY});
                                continue archer;
                            }
                        }
                    }
                    for (int j = 1; j <d; j++) {
                        reachX = t - (d - j);
                        reachY = archersPos[n] + j; // 오른쪽 탐샛
                        if (reachX >= 0 && reachX < t && reachY >= 0 && reachY < M) {
                            if (map[reachX][reachY]) {
                                candidateKill.add(new int[]{reachX,reachY});
                                continue archer;
                            }
                        }
                    }
                }
            }
            for(int k=0;k<candidateKill.size();k++){
                if(map[candidateKill.get(k)[0]][candidateKill.get(k)[1]]) cntKill++;
                map[candidateKill.get(k)[0]][candidateKill.get(k)[1]]=false;
            }
            if (!isContinueTurn(t)) break;
        }
        max = Math.max(max, cntKill);
    }

    static boolean isContinueTurn(int T) {
        for (int i = 0; i < T; i++) {
            for (boolean b : map[i]) {
                if (b) return true;
            }
        }
        return false;
    }
}
