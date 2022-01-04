package src;

import java.io.*;
import java.util.StringTokenizer;

public class Java_15651 {
    static int n,m;
    static int[] order;
    static boolean[] selected;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        selected = new boolean[n];
        order=new int[m];
        perm(0);
        bw.flush();
        bw.close();
        br.close();
    }
    static void perm(int cnt) throws IOException{
        if(cnt==m){
            for(int n : order) bw.write(n+" ");
            bw.append("\n");
            return;
        }
        for (int i = 0; i <n ; i++) {
            order[cnt]=i+1;
            perm(cnt+1);
        }
    }
}
