package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_14891 {
    static boolean[] rolled = new boolean[4];
    static char[][] wheels = new char[4][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            wheels[i]=br.readLine().toCharArray();
        }

        int n =Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx=Integer.parseInt(st.nextToken())-1;
            int type=Integer.parseInt(st.nextToken());
            Arrays.fill(rolled,false);
            roll(idx,type);
        }
        int score=0;
        for (int i = 0; i < 4; i++) {
            if(wheels[i][0]=='1') score+=Math.pow(2,i);
        }
        System.out.println(score);
    }
    public static void roll(int idx, int type){
        rolled[idx]=true;
        int oppositeType= 1;
        if(type==1) oppositeType=-1;
        if(idx>0&&!rolled[idx-1]){
            if(wheels[idx][6]!=wheels[idx-1][2]) roll(idx-1,oppositeType);
        }
        if(idx<3&&!rolled[idx+1]){
            if(wheels[idx][2]!=wheels[idx+1][6]) roll(idx+1,oppositeType);
        }

        if(type==1) {
            char tmp=wheels[idx][7];
            for (int i = 7; i >0 ; i--) {
                wheels[idx][i]=wheels[idx][i-1];
            }
            wheels[idx][0]=tmp;
        }else{
            char tmp=wheels[idx][0];
            for (int i = 1; i <=7 ; i++) {
                wheels[idx][i-1]=wheels[idx][i];
            }
            wheels[idx][7]=tmp;
        }
    }
}
