import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_1043 {
    static int[] parent;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+2];
        make();
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        while(st.hasMoreTokens()) union(0,Integer.parseInt(st.nextToken()));

        int[][] parties = new int[M][];

        for (int i = 0; i <M ; i++) {
            st =new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            parties[i] = new int[cnt];
            boolean canLie = true;
            for (int j = 0; j < cnt; j++) {
                parties[i][j]=Integer.parseInt(st.nextToken());
                if(find(parties[i][j])==0) canLie=false;
                if(j!=0) union(parties[i][j-1], parties[i][j]);
            }
            if(!canLie) {
                union(0,parties[i][0]);
            }
        }

        int lieParty=M;
        for (int i = 0; i <M ; i++) {
            for(int p : parties[i]){
                if(find(p)==0) {
                    lieParty--;
                    break;
                }
            }
        }
        System.out.println(lieParty);
    }
    public static void make(){ // 0 진실을 아는 사람
        for (int i = 0; i < N+2 ; i++) {
            parent[i]=i;
        }
    }
    public static int find(int a){
        if(a==parent[a]) return a;
        return parent[a]=find(parent[a]);
    }
    public static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        if(bRoot>aRoot) parent[bRoot] = aRoot;
        else parent[aRoot]=bRoot;
        return true;
    }
}
