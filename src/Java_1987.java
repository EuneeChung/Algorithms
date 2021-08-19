package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_1987 {
    static int R,C;
    static char[][] map;
    static int max=Integer.MIN_VALUE;
    static int[] deltaX={0,1,0,-1};
    static int[] deltaY={1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map= new char[R][C];

        for(int r=0;r<R;r++){
            map[r]=br.readLine().toCharArray();
        }

        move(0,0,map[0][0]+"");
        System.out.print(max);
    }
    static void move(int r, int c, String str){
        int enabledMoveCnt=0;

        for(int d=0;d<4;d++){
            int nextR=r+deltaX[d];
            int nextC=c+deltaY[d];
            if(nextR>=0 && nextR <R && nextC>=0 && nextC <C && !str.contains(map[nextR][nextC]+"")) {
                move(nextR,nextC,str+map[nextR][nextC]);
            }
            else enabledMoveCnt++;
        }

        if(enabledMoveCnt==4) {
            max=Math.max(max,str.length());
            return;
        }
    }
}
