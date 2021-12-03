package src;

import java.util.Scanner;

public class Java_17070 {
    static int way=0,N;
    static int[][] map;
    static int[][] dx ={{0},{1},{0,1,1}};
    static int[][] dy ={{1},{0},{1,0,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N ; j++) {
                map[i][j]=sc.nextInt();
            }
        }

        dfs(0,1,0);
        System.out.print(way);
    }
    static void dfs(int r, int c,int type){
        // type 0 가로 1 세로 2 대각선
        if(r==N-1 && c==N-1){
            way=way+1;
            return;
        }
        movePipe:for (int i = 0; i <3 ; i++) {
            int tx=r;
            int ty=c;
            if(type!=2 && i!=type&&i!=2) continue;
            for (int j = 0; j < dx[i].length ; j++) {
                tx=r+dx[i][j];
                ty=c+dy[i][j];
                if(tx<0 || tx>=N ||ty<0 || ty>=N ||map[tx][ty]==1) continue movePipe;
            }
            dfs(tx,ty,i);
        }
    }
}
