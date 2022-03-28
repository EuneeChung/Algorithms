import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Java_11725 {
    static boolean[] visited;
    static int[] parents;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        visited = new boolean[N+1];
        parents = new int[N+1];

        dfs(1,0);

        for (int i = 2; i <=N ; i++)
            sb.append(parents[i]).append("\n");

        System.out.print(sb);

    }
    static void dfs(int current, int parent){
        visited[current]=true;
        parents[current]=parent;

        for(int node : tree[current])
            if(!visited[node]) dfs(node,current);
    }
}
