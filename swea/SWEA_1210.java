package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 10; t++) {
            br.readLine();
            int[] currentPosition = {99, -1};
            boolean[][] map = new boolean[100][100];

            //입력 받기
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    switch (st.nextToken()) {
                        case "0":
                            map[i][j] = false;
                            break;
                        case "1":
                            map[i][j] = true;
                            break;
                        case "2": {
                            map[i][j] = true;
                            currentPosition[1] = j;
                            break;
                        }
                        default:
                    }
                }
            }

            int[][] delta = {{-1, 0, 0}, {0, -1, 1}};// 0 up 1 left 2 right

            //길 찾기
            while (true) {
                for (int di = 2; di >=0; di--) {
                    int xi = currentPosition[0] + delta[0][di];
                    int xj = currentPosition[1] + delta[1][di];

                    if (xi < 100 && xi >= 0&&xj < 100 && xj >= 0 && map[xi][xj]) {
                        map[xi][xj]=false;
                        currentPosition[0] = xi;
                        currentPosition[1] = xj;
                        break;
                    }

                }
                if(currentPosition[0]==0) break;
            }
            System.out.println("#" + (t + 1) + " " + currentPosition[1]);
        }
    }
}
