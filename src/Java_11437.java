import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Java_11437 {
    static boolean[] visited;
    static int[] parents,depths;
    static int N;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        N=Integer.parseInt(br.readLine());
        visited=new boolean[N+1];
        depths=new int[N+1];
        parents=new int[N+1];
        tree= new ArrayList[N+1];
        for (int i = 0; i <=N ; i++) {
            tree[i]=new ArrayList();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1,1,0);
        int M=Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a,b)).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int current, int depth,int parent){
        visited[current]=true;
        parents[current]=parent;
        depths[current]=depth;

        for(int next : tree[current])
            if(!visited[next]) dfs(next,depth+1,current);
    }
    static int LCA(int a, int b){
        int aDepth = depths[a];
        int bDepth = depths[b];

        while(aDepth>bDepth){
            a=parents[a];
            aDepth--;
        }
        while(bDepth>aDepth){
            b=parents[b];
            bDepth--;
        }
        while (a!=b){
            a=parents[a];
            b=parents[b];
        }
        return a;
    }
}
