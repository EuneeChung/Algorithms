package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SWEA_11315 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        int[][] delta = {
                {-1, -1, -1, 0, 0, 1, 1, 1},  // i
                {-1, 0, 1, -1, 1, -1, 0, 1}  // j
        };

        for (int t = 0; t < TC; t++) {

            int sizeN = Integer.parseInt(br.readLine());
            char[][] map = new char[sizeN][sizeN];

            //승패 초기값 셋팅
            boolean isWin = false;
            //sizeN 만큼의 오목 맵 그리기
            for (int a = 0; a < sizeN; a++) {
                String line = br.readLine();
                for (int b = 0; b < sizeN; b++) {
                    map[a][b] = line.charAt(b);
                }
            }
            //탐색하기
            for (int i = 0; i < sizeN; i++) {
                for (int j = 0; j < sizeN; j++) {
                    if (map[i][j] == 'o') {
                        for (int d = 0; d < 8; d++) {
                            for (int count = 1; count < 5; count++) {
                                int ni = i + delta[0][d] * count; // di
                                int nj = j + delta[1][d] * count; //dj

                                //맵  밖으로 나갔는지 확인
                                if (ni < 0 || ni >= sizeN || nj < 0 || nj >= sizeN) break;
                                else if (map[ni][nj] != 'o') break;

                                if (count == 4) isWin = true;
                            }
                        }
                    }
                }
            }

            if (isWin) System.out.println("#" + (t + 1) + " YES");
            else System.out.println("#" + (t + 1) + " NO");
        }
    }
}
