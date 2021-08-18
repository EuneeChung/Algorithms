package src;

import java.util.Scanner;

public class Java_2578 {
    static boolean[][] check=new boolean[5][5];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] bingoMap=new int[26][2];

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                int num = sc.nextInt();
                bingoMap[num][0]=i; // 수의 x 위치
                bingoMap[num][1]=j; // 수의 y 위치
            }
        }

        for(int i=0;i<25;i++){
            int deleteNum = sc.nextInt();
            check[bingoMap[deleteNum][0]][bingoMap[deleteNum][1]]=true;

            if(i>=11) { // 최소 3줄 빙고할 수 있는 수 12
                if(checkBingo()>=3) {
                    System.out.print(i+1);
                    break;
                }
            }

        }
    }
    static int checkBingo(){
        int bingoCnt=0;
        outer:for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(!check[i][j]) continue outer;
            }
          bingoCnt++;
        }

        outer:for(int j=0;j<5;j++){
            for(int i=0;i<5;i++){
                if(!check[i][j]) continue outer;
            }
            bingoCnt++;
        }

        for(int i=0;i<5;i++){ //대각선 왼쪽
            if(!check[i][i]) break;

            if(i==4) bingoCnt++;
        }

        int j=0;
        for(int i=4;i>=0;i--){ //대각선 오른쪽
            if (!check[i][j]) break;
            j++;
            if(i==0) bingoCnt++;
        }
        return bingoCnt;
    }
}
