package src;

import java.util.Scanner;

public class Java_14889 {
    static boolean[] isTeamA;
    static int N=0;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        isTeamA=new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N ; j++) {
                map[i][j]= sc.nextInt();
            }
        }

        comb(0,0);
        System.out.print(min);
    }
    static void comb(int cnt, int start){
        if(cnt==N/2){
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <N ; j++) {
                    if(isTeamA[i]&&isTeamA[i]==isTeamA[j]) sumA+=map[i][j];
                    if(!isTeamA[i]&&isTeamA[i]==isTeamA[j]) sumB+=map[i][j];
                }
            }
            int dif = Math.abs(sumA-sumB);
            min=Math.min(dif,min);
            return;
        }
        if(start==N) return;
        isTeamA[start]=true;
        comb(cnt+1,start+1);
        isTeamA[start]=false;
        comb(cnt,start+1);
    }
}
