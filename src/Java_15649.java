package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_15649 {
    static int n,m;
    static int[] order;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        selected = new boolean[n];
        order=new int[m];
        perm(0);
    }
    static void perm(int cnt){
        if(cnt==m){
            StringBuilder sb = new StringBuilder();
            for(int n : order) sb.append(n).append(" ");
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
            return;
        }
        for (int i = 0; i <n ; i++) {
            if(selected[i]) continue;
            selected[i]=true;
            order[cnt]=i+1;
            perm(cnt+1);
            selected[i]=false;
        }
    }
}
