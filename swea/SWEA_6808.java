package swea;

import java.util.Scanner;

public class SWEA_6808 {

    static int[] GY = new int[9];
    static int[] IY=new int[9];
    static boolean[] isSelectedIY = new boolean[9];
    static int[] order = new int[9];
    static int winGY,winIY,sumGY,sumIY,tempG,tempI;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();

        for(int t=1;t<=T;t++){
            winGY=0;
            winIY=0;
            boolean[] isGYNum = new boolean[19];
            sb.append("#").append(t).append(" ");
            for(int g =0; g<9;g++){
                int gyNum=sc.nextInt();
                GY[g]=gyNum;
                isGYNum[gyNum]=true;
            }

            int idxIY=0;
            for(int g =1; g<=18;g++){
                if(!isGYNum[g]) {
                    IY[idxIY]=g;
                    idxIY++;
                }
            }
            permOrder(0);
            sb.append(winGY).append(" ").append(winIY);
            if(t!=T)sb.append("\n");
        }
        System.out.print(sb);
    }

    static void permOrder(int cnt){
        if(cnt==9){
            startGame(order);
            return;
        }
        else {
            for (int i = 0; i < 9; i++) {
                if (isSelectedIY[i]) continue;
                order[i] = cnt;
                isSelectedIY[i] = true;
                permOrder(cnt + 1);
                isSelectedIY[i] = false;
            }
        }
    }
    static void startGame(int[] order){
        sumGY=0;
        sumIY=0;

        for(int i=0;i<9;i++){
            tempG=GY[i];
            tempI=IY[order[i]];

            if(tempG>tempI) sumGY +=(tempG+tempI);
            if(tempG<tempI) sumIY +=(tempG+tempI);
        }
        if(sumGY>sumIY) winGY++;
        if(sumGY<sumIY) winIY++;
    }
}
