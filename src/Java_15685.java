package src;

import java.util.Arrays;
import java.util.Scanner;

public class Java_15685 {
    static int[] di = {0,-1,0,1}; // 동 북 서 남 // 반시계 방향
    static int[] dj = {1,0,-1,0};
    static boolean[][] map = new boolean[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int xj = sc.nextInt();
            int yi = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            int[] dragonDirection = findDragonDirection(0, g, new int[]{d});
            drawDragonCurve(yi, xj, dragonDirection);
        }
        // 크기 1짜리인 정사각형 count
        int cnt=0;
        for (int i = 1; i < 101; i++) {
            for (int j = 0; j < 100; j++) {
                if(countSquare(i,j)) cnt++;
            }
        }
        System.out.println(cnt);
    }

    static int[] findDragonDirection(int curGen, int goalGeneration, int[] dir) {

        if (curGen == goalGeneration) {
            return dir;
        }
        int[] nextDir = new int[dir.length * 2];
        int j = dir.length;
        nextDir = Arrays.copyOfRange(dir,0,dir.length*2);
        for (int i = dir.length - 1; i >= 0; i--) {
            int nd = dir[i]+1; // 시계 반대 방향으로 돌림
            if (nd == 4) nd = 0;

            nextDir[j] = nd;
            j++;
        }
        return findDragonDirection(curGen + 1, goalGeneration, nextDir);
    }
    static void drawDragonCurve(int i, int j, int[] dir){
        map[i][j]=true;
        for (int d : dir) {
            i += di[d];
            j += dj[d];
            map[i][j] = true;
        }
    }
    static boolean countSquare(int i, int j){
        if(!map[i][j]) return false;
        for (int d = 0; d < 3 ; d++) {
            i+=di[d];
            j+=dj[d];
            if(!map[i][j]) return false;
        }
        return true;
    }
}
