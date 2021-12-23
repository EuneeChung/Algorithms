package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_14888 {
    static int N,max,min;
    static int[] An;
    static int[] operators; //0 + 1 -  2 * 3 /
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        An = new int[N];
        for (int i = 0; i < N; i++) {
            An[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i]=Integer.parseInt(st.nextToken());
        }
        max=Integer.MIN_VALUE;
        min=Integer.MAX_VALUE;
        perm(An[0],1,operators);
        System.out.println(max);
        System.out.println(min);
    }
    public static void perm(int result, int idx, int[] operators){
        if(idx==N){
            min=Math.min(min,result);
            max=Math.max(max,result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if(operators[i]==0) continue;
            operators[i]--;
            int nextResult=0;
            if(i==0) nextResult=result+An[idx];
            if(i==1) nextResult=result-An[idx];
            if(i==2) nextResult=result*An[idx];
            if(i==3) {
               if(result<0) nextResult=-(Math.abs(result)/An[idx]);
               else{
                   nextResult=result/An[idx];
               }
            }
            perm(nextResult,idx+1,operators);
            operators[i]++;
        }
    }
}
