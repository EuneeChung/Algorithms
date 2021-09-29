package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5643 {
    static final int LONG = 100;
    static final int SHORT = 200;
    static final int ME = 300;
    static int N;
    static Queue<int[]> shortQueue = new LinkedList<>();
    static Queue<int[]> longQueue = new LinkedList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        int[][] map;
        int M;

        for (int t = 1; t <= T ; t++) {
            N =sc.nextInt();
            M =sc.nextInt();
            map = new int[N][N];
            for (int m = 0; m <M ; m++) {
                int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;
                map[a][b]=SHORT; // a 기준 b 보다 작다
                map[b][a]=LONG; // a 기준 b 보다 작다
            }
            sb.append("#").append(t).append(" ").append(bfs(map)).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
    static int bfs(int[][] map){
        int cnt=0;

        for (int i = 0; i < N; i++) { // i 번째 학생
            for (int j = 0; j <N ; j++) {
                if(i==j) map[i][j]=ME;
                if(map[i][j]==SHORT) shortQueue.add(new int[]{i,j});
                if(map[i][j]==LONG) longQueue.add(new int[]{i,j});

                while (!shortQueue.isEmpty()){
                    int[] shorter = shortQueue.poll();
                    int a = shorter[1];
                    for (int b = 0; b < N; b++) {
                        if(map[a][b]==SHORT&&map[i][b]==0){
                            map[i][b]=SHORT;
                            map[b][i]=LONG;
                            shortQueue.add(new int[]{i,b});
                        }
                    }
                }
                while (!longQueue.isEmpty()){
                    int[] longer = longQueue.poll();
                    int a = longer[1];
                    for (int b = 0; b < N; b++) {
                        if(map[a][b]==LONG&&map[i][b]==0){
                            map[i][b]=LONG;
                            map[b][i]=SHORT;
                            longQueue.add(new int[]{i,b});
                        }
                    }
                }
            }
        }

        outer: for (int i = 0; i < N; i++) { // i 번째 학생
            for (int j = 0; j <N ; j++) {
                if(map[i][j]==0) continue outer;
            }
            cnt++;
        }

        return cnt;
    }
}
