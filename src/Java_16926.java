package src;

import java.util.Scanner;

public class Java_16926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[] deltaX={1,0,-1,0};
        int[] deltaY={0,1,0,-1};

        int N = sc.nextInt();
        int M = sc.nextInt();
        int R = sc.nextInt();
        int[][] map = new int[N][M];

        for(int n =0;n<N;n++){
            for(int m =0;m<M;m++){
                if(sc.hasNext()) map[n][m]=sc.nextInt();
            }
        }

        int halfNM = Math.min(N/2,M/2);
        int cnt;
        int ai,bj;
        int temp;
        int previous;
        int d;

        outer: for(int r =0;r<R;r++){
            cnt=0;
            ai=0;
            bj=0;
            previous=map[0][0];
            d=0;
            while(true){
                if(halfNM==1 &&cnt==1) {
                    continue outer;
                }
                if(halfNM<cnt) {
                    continue outer;
                }

                int tempX=ai+deltaX[d];
                int tempY=bj+deltaY[d];

                if(cnt>tempX || tempX>=N-cnt ||cnt>tempY || tempY>=M-cnt ) {
                    if(d==3){
                        cnt++;
                        ai=cnt;
                        bj=cnt;
                        previous=map[ai][bj];
                        d=0;
                    }else d++;

                    continue;
                }

                temp=map[tempX][tempY];
                map[tempX][tempY]=previous;
                previous=temp;
                ai=tempX;
                bj=tempY;

            }
        }



        for(int n =0;n<N;n++){
            for(int m =0;m<M;m++){
                sb.append(map[n][m]);
                if(!(n==N-1&& m==M-1)) sb.append(" ");
            }
            if(n!=N-1) sb.append("\n");
        }
        System.out.print(sb);

    }
}
