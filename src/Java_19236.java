package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_19236 {
    static int[][] map = new int[4][4];
    static Fish[] fishList = new Fish[17];
    static int max = Integer.MIN_VALUE;
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <4; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j]=num;
                fishList[num]=new Fish(i,j,Integer.parseInt(st.nextToken())-1);
            }
        }

        int num = map[0][0];
        map[0][0]=0;
        int dir = fishList[num].dir;
        fishList[num]=null;
        dfsShark(num,new Fish(0,0,dir));
        System.out.println(max);
    }
    static void dfsShark(int sum ,Fish shark){
//       print();
        int[][] originMap = new int[4][4];
        for (int i = 0; i <4; i++) {
            System.arraycopy(map[i],0,originMap[i],0,4);
        }
        Fish[] tmpFish = new Fish[17];
        for(int i = 1 ; i < 17 ; i++) {
            if(fishList[i] == null) continue;
            tmpFish[i] = new Fish(fishList[i].x, fishList[i].y, fishList[i].dir);
        }
        max=Math.max(max,sum);
        // 물고기 이동
        moveFish(shark);
        // 상어 이동
        int tx=shark.x,ty=shark.y;
        while(true){
            tx += dx[shark.dir];
            ty += dy[shark.dir];

            if(tx<0 ||tx>=4 ||ty<0 ||ty>=4) break;
            if(map[tx][ty]==0) continue;

            int num = map[tx][ty];
            map[tx][ty]=0;
            Fish died = fishList[num];
            fishList[num] = null;
//            System.out.println(num);
//            System.out.println(died.dir);
            dfsShark(sum+num,new Fish(tx,ty,died.dir));

            map[tx][ty]=num;
            fishList[num]=died;
        }
        for(int i = 1 ; i < 17 ; i++) {
            if(tmpFish[i] == null) continue;
            fishList[i] = new Fish(tmpFish[i].x, tmpFish[i].y, tmpFish[i].dir);
        }
        for (int i = 0; i <4; i++) {
            System.arraycopy(originMap[i],0,map[i],0,4);
        }
    }
    static void moveFish(Fish shark){

        for (int i = 1; i < 17; i++) {
//           print();
            Fish fish = fishList[i];
            if(fish==null) continue;

            int x= fish.x, y= fish.y;
            int dir= fish.dir;
            for (int d = 0; d < 8; d++) {
                int tx= fish.x+dx[dir];
                int ty= fish.y+dy[dir];

                if(tx<0 ||tx>=4 ||ty<0 ||ty>=4 || (tx==shark.x&&ty==shark.y)){
                    dir++;
                    if(dir==8) dir=0;
                    continue;
                }
//                System.out.println("상대편 " + map[tx][ty] + " ");
//                System.out.println(tx + " " + ty);
//                System.out.println("나 " + map[fish.x][fish.y]);
//                System.out.println("나 " + i);
//                System.out.println(fish.x + " " + fish.y);

                if(map[tx][ty]==0){
                    fish.x=tx;
                    fish.y=ty;
                    fish.dir=dir;
                    map[tx][ty]=i;
                    map[x][y]=0;
                }
                else{
                    int swipe = map[tx][ty];
                    if(fishList[swipe]==null){
                        System.out.println(swipe);
                        System.out.println(Arrays.toString(fishList));
                        for (int j = 0; j < 4; j++) {
                            System.out.println(Arrays.toString(map[j]));
                        }
                    }
                    map[tx][ty]=i;
                    map[x][y]=swipe;
                    fish.x=tx;
                    fish.y=ty;
                    fish.dir=dir;
                    fishList[i]=fish;
                    fishList[swipe].x=x;
                    fishList[swipe].y=y;
                }
                break;
            }
        }
    }
    static class Fish {
        int x, y, dir;

        public Fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

    }

//    static void print() {
//       System.out.println(Arrays.toString(fishList));
//       for(int i = 0 ; i < 4 ; i++) {
//          for(int j = 0 ; j < 4 ; j++) {
//             System.out.print(map[i][j] + " ");
//          }
//          System.out.println();
//       }
//       System.out.println("----------------------------------------------------------------");
//    }
}