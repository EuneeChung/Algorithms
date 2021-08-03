package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dump =0;
        int[] height = new int[100];

        for(int i=0;i<10;i++ ){
            int[] max={0,0};  //첫번쨰 칸 인덱스 // 두번째 칸 value
            int[] min={100,100};
            dump=Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<100;j++){
                height[j]=Integer.parseInt(st.nextToken());
            }

            // dump 수 돌기
            for(int d=0;d<dump+1;d++){
                // 최소 최대 찾기
                if(d!=0){
                    max[1]--;
                    min[1]++;
                    height[max[0]]--;
                    height[min[0]]++;
                }
                for(int a=0;a<100;a++){
                    if(max[1]<height[a]){
                        max[0]=a;
                        max[1]=height[a];
                    }
                    if(min[1]>height[a]){
                        min[0]=a;
                        min[1]=height[a];
                    }
                }
            }
            System.out.println("#"+(i+1)+" "+(max[1]-min[1]));
        }

    }
}
