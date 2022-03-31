import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Java_2206 {
    static char[][] map;
    static int N,M;
    static int[] dx ={1,0,0,-1};
    static int[] dy ={0,-1,1,0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i <N; i++) {
            map[i]=br.readLine().toCharArray();
        }
        int cnt=1;
        boolean flag=false;
        Queue<Pos> que = new LinkedList<>();
        que.add(new Pos(0,0,false));

        boolean[][][] visited = new boolean[N][M][2];

        outer: while (!que.isEmpty()){
            int size =que.size();
            for (int i = 0; i < size; i++) {
                Pos current = que.poll();
//                for(Pos p :before.posList){
//                    System.out.println(p.x+" "+ p.y);
//                }
//                System.out.println();

                if(current.x==N-1 && current.y==M-1) {
                    flag=true;
                    break outer;
                }
                for (int d = 0; d <4 ; d++) {
                    int tx = current.x+dx[d];
                    int ty = current.y+dy[d];

                    if(!isValidate(tx,ty)) continue;
                    if(map[tx][ty]=='1'&& !current.broke&& !visited[tx][ty][1]) {
                        que.add(new Pos(tx,ty,true));
                        visited[tx][ty][1]=true;
                    }
                    if(map[tx][ty]=='0'){
                        if(!current.broke&& !visited[tx][ty][0]){
                            que.add(new Pos(tx,ty,false));
                            visited[tx][ty][0]=true;
                        }
                        if(current.broke&& !visited[tx][ty][1]){
                            que.add(new Pos(tx,ty,true));
                            visited[tx][ty][1]=true;
                        }
                    }

//                    if(visited[tx][ty]){
//                        Trace go =new Trace(current);
//                        go.posList.add(new Pos(tx,ty));
//
//                        if(map[tx][ty]=='1' && !go.broke){
//                            go.broke=true;
//                            que.add(go);
//                        }
//                        if(map[tx][ty]=='0')
//                            que.add(go);
//
//                    }
                }
            }
            cnt++;
        }
        if(!flag) cnt=-1;
        System.out.println(cnt);
    }
    static boolean isValidate(int x, int y){
        return x>=0&&x<N&&y>=0&&y<M;
    }

    static class Pos{
        int x,y;
        boolean broke;
        public Pos(int x, int y , boolean broke){
            this.x=x;
            this.y=y;
            this.broke=broke;
        }
    }
}
