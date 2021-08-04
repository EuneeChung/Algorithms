package swea;

import java.util.Scanner;

public class SWEA_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] delta = {{0,1,0,-1},{1,0,-1,0}};
        int currentDir = 0;

        int T=sc.nextInt();
        for (int t=1;t<=T;t++){
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            int x=0;
            int y=0;
            int count=1;
            map[x][y]=count;
            count++;

            while(count<=n*n){
                int xi=x+delta[0][currentDir];
                int yi=y+delta[1][currentDir];

                    if(xi < n && xi >= 0&& yi < n && yi >= 0 && (map[xi][yi])==0){
                        x=xi;
                        y=yi;
                        map[x][y]=count;
                        count++;
                    }
                    else{
                        currentDir++;
                        if(currentDir==4) currentDir=0;
                    }
            }

            System.out.println("#"+t);
            for(int a=0; a<n;a++){
                for(int b=0;b<n;b++){
                    if(b!=0) System.out.print(" ");
                    System.out.print(map[a][b]);
                }
                System.out.println();
            }
        }
    }
}
