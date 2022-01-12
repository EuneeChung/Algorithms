package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_1780 {
    static int N;
    static int[][] map;
    static int[] cnt = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        for (int i = 0; i <N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        cutPaper(0,N-1,0,N-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <3 ; i++) {
            sb.append(cnt[i]).append("\n");
        }
        System.out.print(sb);
    }
    public static void cutPaper(int startX, int lastX, int startY, int lastY){
        boolean same=true;
        int num=map[startX][startY];
        outer: for (int i = startX; i <= lastX; i++) {
            for (int j = startY; j <= lastY; j++) {
                if(num!=map[i][j]) {
                    same=false;
                    break outer;
                }
            }
        }
        if(same) cnt[num+1]++;
        else{
            int length = (lastX-startX+1)/3;
            for (int i = 0; i <3 ; i++) {
                for (int j = 0; j <3 ; j++) {
                    cutPaper(startX+length*i,startX+length*(i+1)-1,startY+length*j,startY+length*(j+1)-1);
                }
            }
        }
    }
}
