package swea;

import java.util.Scanner;

public class SWEA_2805 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        int sum =0;

        for(int t=1;t<=T;t++){
            sum=0;
            int N=sc.nextInt();
            int[][] map = new int[N][N];

            sc.nextLine();
            for (int ni=0;ni<N;ni++){
                String line =sc.nextLine();
                for (int nj=0;nj<N;nj++){
                    map[ni][nj]=line.charAt(nj)-'0';
                }
            }

            int half = N/2;
            for(int i=0;i<N;i++){
                int range=0;
                if(half>i) range=half-i;
                else  range=i-half;

                for(int j=range;j<N-range;j++){
                    sum+=map[i][j];
                }
            }
            System.out.println("#"+t+" "+sum);
        }
    }
}
