package src;

import java.util.Scanner;

public class Java_2564 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt();
        int[] distances = new int[C+1];
        int minDistance=0;

        for (int i = 0; i <=C ; i++) {
            int direction = sc.nextInt();
            int x = sc.nextInt();
            if(direction==1) distances[i]=x;
            if(direction==2) distances[i]=2*N+M-x;
            if(direction==3) distances[i]=2*(M+N)-x;
            if(direction==4) distances[i]=N+x;
        }

        for (int i = 0; i < C; i++) {
            int between = Math.abs(distances[i]-distances[C]);
            minDistance+=Math.min(between,2*(M+N)-between);
        }
        System.out.print(minDistance);
    }
}
