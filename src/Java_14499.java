package src;

import java.util.Arrays;
import java.util.Scanner;

public class Java_14499 {
    static int[] dice = new int[7];
    static int[][] roll = {
            {3,1,4,6,3},
            {4,1,3,6,4},
            {2,1,5,6,2},
            {5,1,2,6,5},
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[] dx={0,0,-1,1}; // 동서북남
        int[] dy={1,-1,0,0}; // 동서북남

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];

        int mapX= sc.nextInt();
        int mapY = sc.nextInt();
        int K = sc.nextInt();
        int[] dirK = new  int[K];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        for (int k = 0; k < K; k++) {
            dirK[k]=sc.nextInt()-1;
        } // 입력 끝

        for (int k = 0; k < K; k++) {
            int direction = dirK[k];
            mapX+=dx[direction];
            mapY+=dy[direction];
            if(mapX>=N || mapX<0 ||mapY>=M || mapY<0) {
                mapX-=dx[direction];
                mapY-=dy[direction];
                continue;
            }

            rollDice(direction);

            sb.append(dice[1]).append("\n");
            if(map[mapX][mapY]==0){ // 지도의 칸이 0이면 주사위 바닥면에 있는 수가 칸에 복사
                map[mapX][mapY]=dice[6];
            }
            else{
                dice[6]=map[mapX][mapY];
                map[mapX][mapY]=0;
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
    static void rollDice(int type){
        int[] tmp = Arrays.copyOf(dice,dice.length);
        for (int i = 0; i <4 ; i++) {
            dice[roll[type][i]]=tmp[roll[type][i+1]];
        }
    }
}
