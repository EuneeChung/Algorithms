package src;

import java.util.Scanner;

public class Java_2527 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int[] XP= new int[4];
        int[] YP= new int[4];
        for(int t =0;t<4;t++){
            for(int i=0;i<8;i++){
                if(i<4) XP[i]=sc.nextInt();
                else YP[i%4]=sc.nextInt();
            }
            sb.append(checkCommon(XP,YP)).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }

    static char checkCommon(int[] xp, int[] yp){

        if(xp[0]>yp[2] || xp[2]<yp[0] || xp[1]>yp[3] || xp[3]<yp[1]){
            return 'd';
        }
        if(xp[0]==yp[2] && xp[3]==yp[1]){
            return 'c';
        }
        if(xp[0]==yp[2] && xp[1]==yp[3]){
            return 'c';
        }
        if(xp[2]==yp[0] && xp[3]==yp[1]){
            return 'c';
        }
        if(xp[2]==yp[0] && xp[1]==yp[3]){
            return 'c';
        }
        if(xp[0]==yp[2] || xp[2]==yp[0] || xp[1]==yp[3] || xp[3]==yp[1]){
            return 'b';
        }
        return 'a';
    }
}
