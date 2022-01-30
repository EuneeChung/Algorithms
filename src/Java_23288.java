import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_23288 {
    static int N,M;
    static int[][] map;
    static int[] dice = {0,1,2,3,4,5,6};
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int type = 1; // 동쪽부터 이동
        int[][] patterns = {
                {5,1,3,4,6,2}, // 북
                {4,2,1,6,5,3}, // 동
                {2,6,3,4,1,5}, // 남
                {3,2,6,1,5,4}, // 서
        };

        int posX=0 , posY=0;
        int cntK=0;
        int score =0;
        while (true){
            if(cntK==K) break;
            int tmpX = posX+dx[type];
            int tmpY = posY+dy[type];
            if(!isValidate(tmpX,tmpY)){
                type=(type+2)%4;
                continue;
            }
            cntK++;
            posX=tmpX;
            posY=tmpY;
            int diceBottomNum = rollDice(type,patterns[type]);
            int mapNum = map[posX][posY];
            if(diceBottomNum> mapNum) type=(type+4+1)%4;
            else if(diceBottomNum< mapNum) type=(type+4-1)%4;
            score+=mapNum*bfs(posX,posY);
        }
        System.out.println(score);

    }
    static boolean isValidate(int x, int y){
        return (x>=0 && x<N && y>=0 && y<M);
    }
    static int rollDice(int type, int[] pattern){
        int[] tmpDice = new int[7];
        for (int i = 0; i <6; i++) {
            tmpDice[i+1]=dice[pattern[i]];
        }
        dice=tmpDice;
        return dice[6];
    }
    static int bfs(int x,int y){
        int cnt =1;
        int sameRoom=map[x][y];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});
        visited[x][y]=true;

        while (!que.isEmpty()){
            int[] current = que.poll();
            for (int d = 0; d < 4; d++) {
                int tmpX= current[0]+dx[d];
                int tmpY= current[1]+dy[d];
                if(isValidate(tmpX,tmpY) && !visited[tmpX][tmpY] ){
                    if(map[tmpX][tmpY]==sameRoom){
                    que.add(new int[]{tmpX,tmpY});
                    visited[tmpX][tmpY]=true;
                    cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
