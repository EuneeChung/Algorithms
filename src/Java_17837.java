import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_17837 {
    static int N, K;
    static int[][] colorMap;
    static String[][] chessMap;
    static final int RED = 1, BLUE = 2;
    static int[] dir;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int tx,ty;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        colorMap = new int[N][N];
        chessMap = new String[N][N];
        dir = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                colorMap[i][j] = Integer.parseInt(st.nextToken());
            }

        }
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            chessMap[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = ((char)('a'+k))+"";
            dir[k] = Integer.parseInt(st.nextToken()) - 1;
        }
        int cnt = 0;
        while (true) {
            if (cnt > 1000) {
                cnt = -1;
                break;
            }
            cnt++;
            if (move()) break;
        }
        System.out.println(cnt);
    }

    static boolean move() {
        chess: for (int k = 0; k <K; k++) {
            int d = dir[k];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(chessMap[i][j]==null) chessMap[i][j]="";
                    if ( chessMap[i][j].length() != 0 && chessMap[i][j].contains(((char)('a'+k))+"")) {
                        tx = i + dx[d];
                        ty = j + dy[d];

                        int idx = chessMap[i][j].indexOf(((char)('a'+k))+"");
                        StringBuilder up = new StringBuilder(chessMap[i][j].substring(idx));
                        chessMap[i][j] = chessMap[i][j].substring(0, idx);

                        if (isWallOrBlue(tx,ty)) {
                            d = (d >= 2 ? 2 : 0) + (1 - d % 2);
                            dir[k] = d;
                            tx = i + dx[d];
                            ty = j + dy[d];
                            if(isWallOrBlue(tx,ty)){
                                chessMap[i][j] += up.toString();
                                continue chess;
                            }
                        }
                        if (colorMap[tx][ty] == RED) {
                            up.reverse();
                        }
                        if(chessMap[tx][ty]==null) chessMap[tx][ty]="";
                        chessMap[tx][ty] += up.toString();
                        if(chessMap[tx][ty].length()>=4) return true;
                        continue chess;
                    }
                }
            }
        }
        return false;
    }
    static boolean isWallOrBlue(int tx, int ty){
        return (tx<0||tx>=N||ty<0||ty>=N||colorMap[tx][ty] == BLUE);
    }
}