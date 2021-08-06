package swea;

import java.util.Scanner;

public class SWEA_1861 {
    static int N, roomNumber, roomCount, xi, yi, tempX, tempY;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[][] delta = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            int[][] map = new int[N][N];
            roomNumber = 1;
            roomCount = 1;
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < N; m++) {
                    map[n][m] = sc.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int roomC = 1;
                    xi = i;
                    yi = j;


                    while (true) {

                        for (int d = 0; d < 4; d++) {
                            tempX = xi + delta[0][d];
                            tempY = yi + delta[1][d];
                            if (tempX >= N || tempX < 0 || tempY >= N || tempY < 0) continue;
                            if ((map[xi][yi] + 1) == map[tempX][tempY]) {
                                xi = tempX;
                                yi = tempY;
                                roomC++;
                                break;
                            }
                        }

                        if (tempX != xi || tempY != yi) break;
                    }

                    if (roomC > roomCount) {
                        roomNumber = map[i][j];
                        roomCount = roomC;
                    } else if (roomC == roomCount) roomNumber = Math.min(map[i][j], roomNumber);

                }
            }
            System.out.println("#" + t + " " + roomNumber + " " + roomCount);
        }
    }
}
