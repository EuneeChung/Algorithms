package swea;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_4012 {
    static int N,min,sA,sB;
    static boolean[] isSelectedA;
    static ArrayList<Integer> AList=new ArrayList<>();
    static ArrayList<Integer> BList=new ArrayList<>();
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T=sc.nextInt();

        for(int t=1;t<=T;t++){
            min=Integer.MAX_VALUE;

            N=sc.nextInt();
            map = new int[N][N];
            isSelectedA= new boolean[N];
            AList.clear();
            BList.clear();

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j]=sc.nextInt();
                }
            }


            comb(0,0);

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
    static void comb(int cnt, int target){
        if(cnt==N/2){
            AList.clear();
            BList.clear();

            for(int i=0;i<N;i++){
                if(isSelectedA[i]) AList.add(i);
                else BList.add(i);
            }

            min = Math.min(min,getDifSynergy());
            return;
        }
        if(target==N) return;

        isSelectedA[target]=true;
        comb(cnt+1,target+1);
        isSelectedA[target]=false;
        comb(cnt,target+1);
    }
    static int getDifSynergy(){
        sA=0;
        sB=0;
        for(int i=0;i<N/2;i++){
            for(int j=0;j<N/2;j++){
                sA+=map[AList.get(i)][AList.get(j)];
            }
        }

        for(int i=0;i<N/2;i++){
            for(int j=0;j<N/2;j++){
                sB+=map[BList.get(i)][BList.get(j)];
            }
        }
        return Math.abs(sA-sB);
    }
}
