package swea;

import java.util.Scanner;

public class SWEA_2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int N= sc.nextInt();
            int M= sc.nextInt();
            int[][] map = new int[N][N];

            for(int ni=0;ni<N;ni++){
                for(int nj=0;nj<N;nj++){
                    map[ni][nj]=sc.nextInt();
                }
            }

            int max=0;

            for(int h=0;h<=N-M;h++){
                for(int w=0;w<=N-M;w++){
                    int sum=0;

                    for(int hi=h;hi<h+M;hi++){
                        for(int hj=w;hj<w+M;hj++){
                            sum+=map[hi][hj];
                        }
                    }
                    max=Math.max(max,sum);
                }
            }
            System.out.println("#"+t+" "+max);
        }
    }
}
