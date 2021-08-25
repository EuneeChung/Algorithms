package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_10026 {
    static char[][] map;
    static int cnt,rgCnt;
    static int[] deltaX = {-1,1,0,0}; //U D L R
    static int[] deltaY = {0,0,-1,1}; //U D L R
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        map =new char[N][N];
        boolean[][] isVisited=new boolean[N][N];
        boolean[][] isVisitedRG=new boolean[N][N];

        for (int i = 0; i <N ; i++) {
            map[i]=br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N ; j++) {
                if(!isVisited[i][j]) {
                    dfs(i,j,map[i][j],isVisited,false);
                    cnt++;
                }
               if(!isVisitedRG[i][j]){
                   dfs(i,j,map[i][j],isVisitedRG,true);
                   rgCnt++;
               }
            }
        }
        System.out.print(cnt+" "+rgCnt);

    }
    static void dfs(int x, int y, char color,boolean[][] visited,boolean redGreen){

        for (int d = 0; d <4 ; d++) {
            int tempX = x+deltaX[d];
            int tempY = y +deltaY[d];

            if(tempX<0 || tempX>=visited.length ||tempY<0 || tempY>=visited.length ) continue;
            if(!visited[tempX][tempY]&&color==map[tempX][tempY]){
                visited[tempX][tempY]=true;
                dfs(tempX,tempY,color,visited,redGreen);
            }

            //적록색약
            if(redGreen &&!visited[tempX][tempY] && color=='R'&&map[tempX][tempY]=='G'){
                visited[tempX][tempY]=true;
                dfs(tempX,tempY,color,visited,redGreen);
            }
            if(redGreen &&!visited[tempX][tempY] && color=='G'&&map[tempX][tempY]=='R'){
                visited[tempX][tempY]=true;
                dfs(tempX,tempY,color,visited,redGreen);
            }
        }
    }
}
