package src;

import java.util.Scanner;

public class Java_16935 {
    static int[][] map;
    static int N,M,temp,previous;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb =new StringBuilder();

        N=sc.nextInt();
        M=sc.nextInt();
        int R=sc.nextInt();
        map=new int[N][M];
        int[] rList = new int[R];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<R;i++){
            rList[i]= sc.nextInt();
        }

        for(int i=0;i<R;i++){
            switch (rList[i]){
                case 1: operate1();
                        break;
                case 2: operate2();
                    break;

                case 3: operate3();
                    break;

                case 4: operate4();
                    break;

                case 5: operate56(true);
                    break;

                case 6: operate56(false);
                    break;
            }
        }

        for(int n =0;n< map.length;n++){
            for(int m =0;m<map[0].length;m++){
                sb.append(map[n][m]);
                if(m!=map[0].length-1) sb.append(" ");
            }
            if(n!=map.length-1) sb.append("\n");
        }
        System.out.print(sb);
    }
    static void operate1(){
        N= map.length;
        M=map[0].length;
        for(int j=0;j<M;j++){
            for(int i=0;i<N/2;i++){
                temp=map[i][j];
                map[i][j]=map[N-1-i][j];
                map[N-1-i][j]=temp;
            }
        }
    }
    static void operate2(){
        N= map.length;
        M=map[0].length;
        for(int i=0;i<N;i++){
            for(int j=0;j<M/2;j++){
                temp=map[i][j];
                map[i][j]=map[i][M-1-j];
                map[i][M-1-j]=temp;
            }
        }
    }
    static void operate3(){
        N=map.length;
        M=map[0].length;
        int[][] rotateMap = new int[M][N];

        for(int j=0;j<M;j++){
            for(int i=N-1;i>=0;i--){
                rotateMap[j][N-1-i]=map[i][j];
            }
        }
        map=rotateMap;
    }
    static void operate4(){
        N=map.length;
        M=map[0].length;
        int[][] rotateMap = new int[M][N];
        for(int j=M-1;j>=0;j--){
            for(int i =0;i<N;i++){
                rotateMap[M-1-j][i]=map[i][j];
            }
        }
        map=rotateMap;
    }
    static void operate56(boolean isFive){
        N=map.length;
        M=map[0].length;
        int tempX,tempY;
        int[] deltaX;
        int[] deltaY;

        if(isFive){
            deltaX= new int[]{0, N / 2, 0};
            deltaY= new int[]{M / 2, 0, -M / 2};
        }else{
            deltaX= new int[]{N / 2, 0,-N/2};
            deltaY= new int[]{0, M / 2,0};
        }

        for(int i=0;i<N/2;i++){
            for(int j=0;j<M/2;j++){
                tempX=i;
                tempY=j;
                previous=map[tempX][tempY];
                for(int d=0;d<3;d++){
                    tempX+=deltaX[d];
                    tempY+=deltaY[d];
                    temp=map[tempX][tempY];
                    map[tempX][tempY]=previous;
                    previous=temp;
                }
               map[i][j]=previous;
            }
        }

    }

}
