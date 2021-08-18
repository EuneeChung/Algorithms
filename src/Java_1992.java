package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_1992 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        map=new char[N][N];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=line.charAt(j);
            }
        }
        System.out.print(compress(0,0,N));
    }

    static String compress(int startX, int startY,int n){
        if(n==1) return map[startX][startY]+"";
        char first=map[startX][startY];

        outer:for(int i=startX;i<startX+n;i++){
            for(int j=startY;j<startY+n;j++){
                if(first!=map[i][j]) {
                    first=' ';
                    break outer;
                }
            }
        }

        if(first!=' ') return first+"";

        n=n/2;
        return "("+compress(startX,startY,n)+compress(startX,startY+n,n)+compress(startX+n,startY,n)+compress(startX+n,startY+n,n)+")";

    }
}
