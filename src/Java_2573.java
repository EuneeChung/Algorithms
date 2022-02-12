package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_2573 {
    static int N,M;
    static int[][] map;
    static Queue<Pos> que;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map = new int[N][M];

        que = new LinkedList<>();
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                que.add(new Pos(i,j));
            }
        }
        int time=0;
        boolean divided =false;
        while (!que.isEmpty()){
            time++;
            melt();
            if(countArea()>=2) {
                divided=true;
                break;
            }
        }
        if(!divided) time=0;
        System.out.println(time);
    }
    static boolean isNotValidate(int x, int y){
        return !(x>=0&&x<N&&y>=0&&y<M);
    }
    static void melt(){
        int[][] originMap = new int[N][M];
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                originMap[i][j]=map[i][j];
            }
        }
        int size = que.size();
        for (int i = 0; i < size ; i++) {
            Pos current = que.poll();
            int seaArea=0;
            int height=originMap[current.x][current.y];
            for (int d = 0; d < 4; d++) {
                int tx = current.x+dx[d];
                int ty = current.y+dy[d];
                if(isNotValidate(tx,ty)) continue;
                if(originMap[tx][ty]==0) seaArea++;
            }
            height-=seaArea;
            if (height>0) {
                que.add(current);
                map[current.x][current.y]=height;
            }
            else map[current.x][current.y]=0;
        }
    }
    static int countArea(){
        int area=0;
        boolean[][] visited = new boolean[N][M];
        Queue<Pos> areaQue = new LinkedList<>();
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    areaQue.add(new Pos(i,j));
                    area++;
                    while (!areaQue.isEmpty()) {
                        Pos current = areaQue.poll();
                        for (int d = 0; d < 4; d++) {
                            int tx = current.x+dx[d];
                            int ty = current.y+dy[d];
                            if(isNotValidate(tx,ty)||visited[tx][ty]) continue;
                            if(map[tx][ty]!=0) {
                                areaQue.add(new Pos(tx,ty));
                                visited[tx][ty]=true;
                            }
                        }
                    }
                }
            }
        }
        return area;
    }

    static class Pos{
        int x,y;
        public Pos(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
