package swea;

import java.util.Scanner;

public class SWEA_1873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int currentDir;
        int[][] delta = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
        char[] icons = {'^', 'v', '<', '>'};
        int x = -1;
        int y = -1;

        for (int t = 1; t <= T; t++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            char[][] map = new char[H][W];
            currentDir = 0;
            sc.nextLine();
            for (int h = 0; h < H; h++) {
                String line = sc.nextLine();
                for (int w = 0; w < W; w++) {
                    map[h][w] = line.charAt(w);
                    if (map[h][w] == '^' || map[h][w] == 'v' || map[h][w] == '<' || map[h][w] == '>') {
                        for (int i = 0; i < icons.length; i++) {
                            if (map[h][w] == icons[i]) currentDir = i;
                        }
                        x = h;
                        y = w;
                        map[h][w] = '.';
                    }
                }
            }
            int actionNum = sc.nextInt();
            sc.nextLine();
            String actions = sc.nextLine();

            for (int a = 0; a < actionNum; a++) {

                char action = actions.charAt(a);


                if (action == 'U') currentDir = 0;
                if (action == 'D') currentDir = 1;
                if (action == 'L') currentDir = 2;
                if (action == 'R') currentDir = 3;

                int tempX = x + delta[0][currentDir];
                int tempY = y + delta[1][currentDir];

                if (action != 'S' &&tempX < H && tempX >= 0 && tempY < W && tempY >= 0 && map[tempX][tempY] == '.') {
                    x = tempX;
                    y = tempY;
                }

                if (action == 'S') {
                    int bombX = tempX;
                    int bombY = tempY;

                    while (true) {
                        if (bombX >= H || bombX < 0 || bombY >= W || bombY < 0) break;

                        if(map[bombX][bombY]=='*'){
                            map[bombX][bombY] = '.';
                            break;
                        }
                        else if(map[bombX][bombY]=='#') break;

                        bombX = bombX + delta[0][currentDir];
                        bombY = bombY + delta[1][currentDir];
                    }

                    continue;
                }
            }

            map[x][y] = icons[currentDir];

            System.out.print("#" + (t) + " ");
            for (int h = 0; h < H; h++) {
                for (int w = 0; w < W; w++) {
                    System.out.print(map[h][w]);
                }
                System.out.println();
            }

        }
    }
}

