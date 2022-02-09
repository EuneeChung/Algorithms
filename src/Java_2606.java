import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_2606 {
    public static void main(String[] args) throws Exception{
        boolean[] isInfected;
        ArrayList<Integer>[] network;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        isInfected=new boolean[N];
        network = new ArrayList[N];
        for (int i = 0; i <N ; i++) {
            network[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            network[a].add(b);
            network[b].add(a);
        }
        int cnt =0;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        isInfected[0]=true;
        while (!que.isEmpty()){
            int computer = que.poll();
            for (Integer connect : network[computer]) {
                if (!isInfected[connect]) {
                    que.add(connect);
                    isInfected[connect] = true;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
