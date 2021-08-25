package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SWEA_7465 {
    static int[] peoples;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int count=0;

        for(int t=1;t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());

            peoples = new int[N];

            for (int i = 0; i < N; i++) { // 대표자는 본인으로 초기화
                peoples[i]=i;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
            }
            for (int i = 0; i < N; i++) { // 대표자들을 찾기
                find(i);

            }

            count=0;
            for (int p = 0; p < N; p++) {
                if(find(p) == p) count++;
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
    static int find(int a){
        if(a==peoples[a]) return a;
        return peoples[a]=find(peoples[a]);
    }
    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        peoples[bRoot] = aRoot;
        return true;
    }
}
