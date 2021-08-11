package src;

import java.util.Scanner;

public class Java_17406 {
    static int N,M,K;
    static int[] order;
    static boolean[] isSelected;

    static int rowMin = Integer.MAX_VALUE;
    static int[] deltaX={0,1,0,-1};
    static int[] deltaY={1,0,-1,0};
    static int[][] originalMap;
    static int[] rList,cList,sList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        isSelected=new boolean[K];
        order=new int[K];
        originalMap = new int[N][M];
        rList=new int[K];
        cList=new int[K];
        sList=new int[K];

        for(int n =0;n<N;n++){
            for(int m =0;m<M;m++){
                if(sc.hasNext()) originalMap[n][m]=sc.nextInt();
            }
        }

        for(int n =0;n<K;n++) {
            rList[n] = sc.nextInt();
            cList[n] = sc.nextInt();
            sList[n] = sc.nextInt();
        }

        permOrder(0);
        System.out.print(rowMin);
    }
    static void permOrder(int cnt){
        if(cnt==K){
            rotateByOrder(order);
            return;
        }
        else{
            for(int i=0;i<K;i++){
                if(isSelected[i]) continue;
                order[i]=cnt;
                isSelected[i]=true;
                permOrder(cnt+1);
                isSelected[i]=false;
            }
        }
    }

    static void rotateByOrder(int[] order){
        int[][] map = new int[N][M];
        for(int n =0;n<N;n++){
            for(int m =0;m<M;m++){
                map[n][m]=originalMap[n][m];
            }
        }
        int halfNM;
        int cnt;
        int ai,bj;
        int temp;
        int previous;
        int d;

        outer: for(int r =0;r<K;r++){

            halfNM=sList[order[r]];
            cnt=0;
            int aStart = Math.max(0, rList[order[r]] - sList[order[r]]-1);
            int aEnd =Math.min(rList[order[r]]+sList[order[r]],N);
            int bStart = Math.max(0,cList[order[r]]-sList[order[r]]-1);
            int bEnd=Math.min(cList[order[r]]+sList[order[r]],M);
            ai= aStart;
            bj=bStart;
            previous=map[ai][bj];
            d=0;

            while(true){
                if(halfNM==1 &&cnt==1) {
                    continue outer;
                }
                if(halfNM<cnt) {
                    continue outer;
                }

                int tempX=ai+deltaX[d];
                int tempY=bj+deltaY[d];

                if(aStart+cnt >tempX || tempX>=aEnd-cnt || bStart+cnt >tempY || tempY>=bEnd-cnt) {
                    if(d==3){
                        cnt++;
                        ai=aStart+cnt;
                        bj=bStart+cnt;
                        previous=map[ai][bj];
                        d=0;
                    }else d++;

                    continue;
                }

                temp=map[tempX][tempY];
                map[tempX][tempY]=previous;
                previous=temp;
                ai=tempX;
                bj=tempY;
            }
        }

        int tempLine;
        for(int n =0;n<N;n++){
            tempLine=0;
            for(int m =0;m<M;m++){
                tempLine+=map[n][m];
            }
            rowMin=Math.min(tempLine,rowMin);
        }
    }
}
