import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i <N ; i++) {
            adjList[i]= new ArrayList<>();
        }

        int[] degrees = new int[N];
        for (int i = 0; i <M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            adjList[a].add(b);
            degrees[b]++;
        }
        System.out.print(topologySort(adjList,degrees));

    }
    public static String topologySort(ArrayList<Integer>[] adjList,int[] degrees){
        int N = adjList.length;
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <N ; i++) {
            if(degrees[i]==0) que.add(i);
        }

        for (int i = 0; i <N ; i++) {
            if(que.isEmpty()) return null;

            int x = que.poll();
            sb.append(x+1).append(" ");
            for (int j = 0; j < adjList[x].size(); j++) {
                int y = adjList[x].get(j);
                if(--degrees[y]==0) que.add(y);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
