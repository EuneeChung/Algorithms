package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_14503 {
    static int N,M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();

        int[][] map = new int[N][M];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                map[i][j]=sc.nextInt();
            }
        }

        System.out.print(bfs(map,R,C,D));
    }
    static int bfs(int[][] map, int R, int C, int D){
        int cnt=1;
        final int CLEAN=2;
        int[] dx = {-1,0,1,0}; // 북 동 서 남
        int[] dy = {0,1,0,-1};
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{R,C,D});
        map[R][C]=CLEAN;
        while (!que.isEmpty()){
            int[] current = que.poll();
//            System.out.println(Arrays.toString(current));
            // 바라 보는 방향의 왼쪽부터 탐색
            for (int i = current[2]-1; i >=current[2]-4 ; i--) {
                int type= i<0?i+4:i;
                int tx=current[0]+dx[type];
                int ty=current[1]+dy[type];
                if(tx<0||tx>=N||ty<0||ty>=M||map[tx][ty]!=0){
                    if(i==current[2]-4) {
                        int backX=current[0]-dx[type];
                        int backY=current[1]-dy[type];
                        if(backX<0||backX>=N||backY<0||backY>=M||map[backX][backY]==1) return cnt;
                        else que.add(new int[]{backX,backY,type});
                    }
                    continue;
                }
                if(map[tx][ty]==0){
                    cnt++;
                    map[tx][ty]=CLEAN;
                    que.add(new int[]{tx,ty,type});
                    break;
                }

            }
        }
        return cnt;
    }
}
