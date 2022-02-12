package src;

import java.util.Scanner;

public class Java_12100 {
    static int N,max;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        max=0;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        dfs(0);
        System.out.println(max);
    }
    public static void dfs(int cnt){
        if(cnt==5){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max=Math.max(max,map[i][j]);
                }
            }
            return;
        }
        int[][] originMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, originMap[i], 0, N);
        }
        for (int i = 0; i < 4; i++) { // 네 방향
            if(i==0) rollDown();
            if(i==1) rollUp();
            if(i==2) rollRight();
            if(i==3) rollLeft();
            dfs(cnt+1);
            for (int a = 0; a < N; a++) {
                System.arraycopy(originMap[a], 0, map[a], 0, N);
            }
        }

    }
    public static void rollDown(){
        for (int j = 0; j <N ; j++) {
            int addBlockIdx=-1;
            move:for (int i = N-2; i >= 0; i--) {
                int blockNum=map[i][j];
                if(blockNum==0) continue;
                map[i][j]=0;
                for (int a = i+1; a < N; a++) {
                    if(map[a][j]!=0){
                        if(blockNum==map[a][j]&&addBlockIdx!=a) {
                            addBlockIdx=a;
                            map[a][j]*=2;
                        }
                        else map[a-1][j]=blockNum;
                        continue move;
                    }
                }
                // 그 다음으로 이동할떄 숫자 채워져있는게 하나도 없을떄 이부분 실행
                map[N-1][j]=blockNum;
            }
        }
    }
    public static void rollUp(){
        for (int j = 0; j <N ; j++) {
            int addBlockIdx =-1;
            move:for (int i = 1; i < N; i++) {
                int blockNum=map[i][j];
                if(blockNum==0) continue;
                map[i][j]=0;
                for (int a = i-1; a >= 0; a--) {
                    if(map[a][j]!=0){
                        if(blockNum==map[a][j]&& addBlockIdx !=a) {
                            addBlockIdx =a;
                            map[a][j]*=2;
                        }
                        else map[a+1][j]=blockNum;
                        continue move;
                    }
                }
                // 그 다음으로 이동할떄 숫자 채워져있는게 하나도 없을떄 이부분 실행
                map[0][j]=blockNum;
            }
        }
    }
    public static void rollRight(){
        for (int i = 0; i <N ; i++) {
            int addBlockIdx=-1;
            move:for (int j = N-2; j >=0 ; j--) {
                int blockNum=map[i][j];
                if(blockNum==0) continue;
                map[i][j]=0;
                for (int b = j+1; b <N ; b++) {
                    if(map[i][b]!=0){
                        if(blockNum==map[i][b]&&addBlockIdx!=b){
                            addBlockIdx=b;
                            map[i][b]*=2;
                        }
                        else map[i][b-1]=blockNum;

                        continue move;
                    }
                }
                // 그 다음으로 이동할떄 숫자 채워져있는게 하나도 없을떄 이부분 실행
                map[i][N-1]=blockNum;
            }
        }
    }
    public static void rollLeft(){
        for (int i = 0; i <N ; i++) {
            int addBlockIdx=-1;
            move:for (int j = 1; j <N ; j++) {
                int blockNum=map[i][j];
                if(blockNum==0) continue;
                map[i][j]=0;
                for (int b = j-1; b >= 0; b--) {
                    if(map[i][b]!=0){
                        if(blockNum==map[i][b]&&addBlockIdx!=b) {
                            addBlockIdx=b;
                            map[i][b]*=2;
                        }
                        else map[i][b+1]=blockNum;

                        continue move;
                    }
                }
                // 그 다음으로 이동할떄 숫자 채워져있는게 하나도 없을떄 이부분 실행
                map[i][0]=blockNum;
            }
        }
    }
}
