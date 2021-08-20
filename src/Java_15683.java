package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_15683 {

    static int min=Integer.MAX_VALUE,N,M;
    static ArrayList<int[]> cctvs= new ArrayList<>(); // 0 x좌료 1 y좌표 2 type
    static int[] deltaX = {-1,0,1,0}; // 상 우 하 좌
    static int[] deltaY = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N= sc.nextInt();
        M= sc.nextInt();
        int[][] map = new int[N][M];

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                map[i][j]=sc.nextInt();
                if(map[i][j]>0 &&map[i][j]<6) cctvs.add(new int[] {i,j,map[i][j]});
            }
        }

        findMaxMonitor(0, map);
        System.out.print(min);


    }
    static void findMaxMonitor(int cnt, int[][] checkMap) {
        if(cnt==cctvs.size()) {
            //사각지대 체크
            min = Math.min(min, findBlindSpot(checkMap));
            return;
        }
        int cctvX=cctvs.get(cnt)[0];
        int cctvY=cctvs.get(cnt)[1];
        int cctvType = cctvs.get(cnt)[2];
        int tempX=cctvX;
        int tempY=cctvY;

        if(cctvType==1) {
            for(int d=0;d<4;d++) {
                int[][] tempMap =deepCopy(checkMap);

                tempX=cctvX;
                tempY=cctvY;
                while(true) {
                    tempX+=deltaX[d];
                    tempY+=deltaY[d];

                    if(tempX<0 || tempX>=N || tempY<0 ||tempY>=M || tempMap[tempX][tempY]==6) break;
                    if(tempMap[tempX][tempY]==0)tempMap[tempX][tempY]=10; // CCTV 보이는 곳 10으로 체크
                }
                findMaxMonitor(cnt+1,tempMap); //
            }
        }

        if(cctvType==2) {
            for(int a=0;a<2;a++) {
                int[][] tempMap =deepCopy(checkMap);
                int d=a;

                tempX=cctvX;
                tempY=cctvY;
                while(true) {
                    tempX+=deltaX[d];
                    tempY+=deltaY[d];

                    if(tempX<0 || tempX>=N || tempY<0 ||tempY>=M || tempMap[tempX][tempY]==6) {
                        if(d>1) break;
                        d+=2;
                        tempX=cctvX;
                        tempY=cctvY;
                        continue;
                    }
                    if(tempMap[tempX][tempY]==0)tempMap[tempX][tempY]=10; // CCTV 보이는 곳 10으로 체크
                }

                findMaxMonitor(cnt+1,tempMap);
            }
        }
        if(cctvType==3) {
            for(int a=0;a<4;a++) {
                int[][] tempMap =deepCopy(checkMap);
                int d=a;

                tempX=cctvX;
                tempY=cctvY;
                while(true) {
                    tempX+=deltaX[d];
                    tempY+=deltaY[d];

                    if(tempX<0 || tempX>=N || tempY<0 ||tempY>=M || tempMap[tempX][tempY]==6) {
                        if(d!=a) break;
                        d++;
                        if(d==4) d=0;
                        tempX=cctvX;
                        tempY=cctvY;
                        continue;
                    }
                    if(tempMap[tempX][tempY]==0)tempMap[tempX][tempY]=10; // CCTV 보이는 곳 10으로 체크
                }

                findMaxMonitor(cnt+1,tempMap);
            }
        }
        if(cctvType==4) {
            for(int a=0;a<4;a++) {
                int[][] tempMap =deepCopy(checkMap);

                outer: for(int d=0;d<4;d++) {
                    tempX=cctvX;
                    tempY=cctvY;
                    while(true) {
                        if(d==a) continue outer;

                        tempX+=deltaX[d];
                        tempY+=deltaY[d];

                        if(tempX<0 || tempX>=N || tempY<0 ||tempY>=M || tempMap[tempX][tempY]==6) {
                            if(d==3) break;
                            continue outer;
                        }
                        if(tempMap[tempX][tempY]==0) tempMap[tempX][tempY]=10; // CCTV 보이는 곳 10으로 체크

                    }
                }
                findMaxMonitor(cnt+1,tempMap);
            }

        }

        if(cctvType==5) {
            outer: for(int d=0;d<4;d++) {
                tempX=cctvX;
                tempY=cctvY;
                while(true) {
                    tempX+=deltaX[d];
                    tempY+=deltaY[d];

                    if(tempX<0 || tempX>=N || tempY<0 ||tempY>=M || checkMap[tempX][tempY]==6) {
                        if(d==3) break;
                        continue outer;
                    }
                    if(checkMap[tempX][tempY]==0) checkMap[tempX][tempY]=10; // CCTV 보이는 곳 10으로 체크

                }
            }
            findMaxMonitor(cnt+1,checkMap);
        }


    }
    static int[][] deepCopy(int[][] original){
        if(original==null) return null;
        int[][] result =new int[N][M];
        for(int i=0;i<N;i++) {
            System.arraycopy(original[i], 0, result[i], 0, M);
        }
        return result;
    }

    static int findBlindSpot(int[][] room) {
        int cnt=0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(room[i][j]==0) cnt++;
            }
        }
        return cnt;
    }
}