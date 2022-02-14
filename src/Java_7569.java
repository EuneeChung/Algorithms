import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_7569 {
    static int[][][] map;
    static int[] dm = {1, -1, 0, 0, 0, 0};
    static int[] dn = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int N, M, H;
    static Queue<Tomato> que = new LinkedList<>();
    static boolean[][][] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][M][N];
        isVisited = new boolean[H][M][N];
        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                for (int n = 0; n < N; n++) {
                    map[h][m][n] = Integer.parseInt(st.nextToken());
                    if(map[h][m][n]==1)que.add(new Tomato(m,n,h));
                }
            }
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        int days=-1;
        while (!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size ; i++) {
                Tomato tomato = que.poll();

                for (int d = 0; d < 6 ; d++) {
                    int tn = tomato.n+dn[d];
                    int tm = tomato.m+dm[d];
                    int th = tomato.h+dh[d];

                    if(isValidate(tm,tn,th)&&!isVisited[th][tm][tn]){
                        if(map[th][tm][tn]==0){
                            map[th][tm][tn]=1;
                            que.add(new Tomato(tm,tn,th));
                            isVisited[th][tm][tn]=true;
                        }
                    }
                }
            }
            days++;
        }


        return isAllCooked()? days : -1;
    }
    public static boolean isValidate(int m, int n,int h){
        return (m>=0&&m<M&& n>=0&&n<N&&h>=0&&h<H);
    }
    public static boolean isAllCooked(){
        for (int h = 0; h < H; h++) {
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if(map[h][m][n]==0) return false;
                }
            }
        }
        return true;
    }
    static class Tomato{
        int n,m,h;
        public Tomato(int m, int n, int h){
            this.n =n;
            this.m=m;
            this.h=h;
        }
    }
}
