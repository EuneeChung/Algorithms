package swea;

import java.util.Scanner;

public class SWEA_5215 {
    static int N,L,maxFlavor;
    static int[][] ingredients;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=1;t<=T;t++){
            N=sc.nextInt();
            L=sc.nextInt();
            maxFlavor=0;
            ingredients=new int[2][N];

            for(int i=0; i<N;i++){
                ingredients[0][i]=sc.nextInt();
                ingredients[1][i]=sc.nextInt();
            }

            powerSet(0,0,0);
            System.out.println("#"+t+" "+maxFlavor);

        }
    }

    public static void powerSet(int sumFlavor,int sumKcal, int cnt){
        if(sumKcal>L) return;
        maxFlavor=Math.max(maxFlavor,sumFlavor);
        if(cnt==N) return;

        powerSet(sumFlavor,sumKcal,cnt+1);
        powerSet(sumFlavor+ingredients[0][cnt],sumKcal+ingredients[1][cnt],cnt+1);
    }

}
