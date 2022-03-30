import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Java_11438 {
    static ArrayList<Integer>[] tree;
    static int[] depths;
    static int[][] parents;
    static int N,maxLevel;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        N = Integer.parseInt(br.readLine());
        maxLevel=(int)Math.floor(Math.log(N)/Math.log(2));
        tree = new ArrayList[N+1];
        depths = new int[N+1];
        parents = new int[N+1][maxLevel+1];
        for (int i = 1; i <=N ; i++) {
            tree[i]= new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        findDpParent(1,0);
        int M=Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a,b)).append("\n");
        }
        System.out.print(sb);


    }
    static void findDpParent(int current, int parent){
        depths[current]=depths[parent]+1;
        parents[current][0]=parent;
        for (int i = 1; i <=maxLevel ; i++) {
            parents[current][i] = parents[parents[current][i-1]][i-1];
        }

        for(int node : tree[current])
            if(node!=parent) findDpParent(node,current);
    }
    static int LCA(int a, int b){
        if(depths[a]> depths[b]){
            // 항상 b의 깊이가 a보다 깊다
            int tmp=a;
            a=b;
            b=tmp;
        }
        int diff = depths[b]-depths[a];
        int i=0;
        while (diff>0){
            if(diff%2==1) b=parents[b][i];
            diff/=2;
            i++;
        }
        if(a!=b){
            for(int j=maxLevel;j>=0;j--){
                if(depths[a]!=0&& parents[a][j]!=parents[b][j]){
                    a=parents[a][j];
                    b=parents[b][j];
                }
            }
            a=parents[a][0];
        }
        return a;
    }
}
