package src;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Java_17143 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();
        int[] dx = {-1, 1, 0, 0}; //상 하 우 좌
        int[] dy = {0, 0, 1, -1};
        // 시간에 따라 사람 이동
        // 그 현재 시간에 들어온 상어의 인덱스를 들고 있는 dp
        // dp 칸에 들어온 상어 배열의 인덱스

        int[][] dp = new int[R][C]; // 상어들의 인덱스를 들고 있는 맵
        int totalSize = 0;
        int RR = 2 * (R - 1);
        int CC = 2 * (C - 1);

        for (int i = 0; i < R; i++) {
            Arrays.fill(dp[i], -1);
        }
        Shark[] sharks = new Shark[M];
        for (int i = 0; i < M; i++) {
            int tr = sc.nextInt() - 1; // 문제에서는 인덱스 1 부터 시작
            int tc = sc.nextInt() - 1; // 문제에서는 인덱스 1 부터 시작
            int ts = sc.nextInt();
            int td = sc.nextInt() - 1; // 문제에서는 인덱스 1 부터 시작

            if (td <= 1) ts %= RR;
            else ts %= CC;
            sharks[i] = new Shark(tr, tc, ts, td, sc.nextInt());
            if (tc == 0) dp[tr][0] = i;
        }

        // 사람이 시간에 따라 이동.
        for (int t = 0; t < C; t++) {

            // 상어 잡기
            for (int r = 0; r < R; r++) {
                if (dp[r][t] != -1) {
                    if (!sharks[dp[r][t]].died) {
                        totalSize += sharks[dp[r][t]].z;
//                        System.out.println("shark " + dp[r][t] + "  " + t);
                        sharks[dp[r][t]].died = true;
                        dp[r][t] = -1;
                        break;
                    }
                }
            }

            // 그 전 이동 기록 초기화
            for (int i = 0; i < R; i++) {
                Arrays.fill(dp[i], -1);
            }

            // 상어 이동
            for (int m = 0; m < M; m++) {
                Shark mthShark = sharks[m];
                if (mthShark.died) continue;

                int moveR = mthShark.r;
                int moveC = mthShark.c;
//                if (m == dp[moveR][moveC]) dp[moveR][moveC] = -1;
                int tempR, tempC;

                for (int speed = 0; speed < mthShark.s; speed++) {

                    tempR = moveR + dx[mthShark.d];
                    tempC = moveC + dy[mthShark.d];
                    if (tempR < 0 || tempR >= R || tempC < 0 || tempC >= C)
                        mthShark.d = changeDirection(mthShark.d);

                    moveR += dx[mthShark.d];
                    moveC += dy[mthShark.d];
                }
                mthShark.r = moveR;
                mthShark.c = moveC;

                // dp 에 저장하기 위해 조건문
                if (dp[mthShark.r][mthShark.c] == -1) dp[mthShark.r][mthShark.c] = m;
                else {
                    Shark existShark = sharks[dp[mthShark.r][mthShark.c]];
                    if (!existShark.died && existShark.z > mthShark.z) {
                        // 그 자리에 있던 상어가 더 크면
                        mthShark.died = true;
                    } else {
                        existShark.died = true;
                        dp[mthShark.r][mthShark.c] = m;
                    }
                }
            }
        }
        System.out.print(totalSize);
    }

    static int changeDirection(int d) {
        if (d == 0) return 1;
        if (d == 1) return 0;
        if (d == 2) return 3;
        if (d == 3) return 2;
        return -1;
    }

    static class Shark {
        int r, c, s, d, z;
        boolean died;

        public Shark(int r, int c, int s, int d, int z) {
            super();
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.died = false;
        }
    }
}
