package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2304{
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N_COLUMN = Integer.parseInt(br.readLine());
        int MAX_NUM=1001;
        int area=0;
        int maxHeight = 0;

       int[][] map=new int[MAX_NUM][3];

        // 창고 기둥 입력받기
        for (int i=0; i<N_COLUMN;i++){
            StringTokenizer s = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(s.nextToken());
            int h = Integer.parseInt(s.nextToken());
            map[index][0]=h;

        }
        br.close();
        // 왼쪽 max
        for(int i=0; i<MAX_NUM;i++){
            if(map[i][0]>=maxHeight) { maxHeight=map[i][0]; }
            map[i][1]=maxHeight;
        }
        maxHeight=0;
        // 오른쪽 max
        for(int i=MAX_NUM-1; i>=0;i--){
            if(map[i][0]>=maxHeight) maxHeight=map[i][0];
            map[i][2]=maxHeight;
        }
        // 최소값
        for(int i=0; i<MAX_NUM;i++){
            if(map[i][1]>=map[i][2]) area+=map[i][2];
            else area+=map[i][1];
        }

        System.out.println(area);
    }
}
