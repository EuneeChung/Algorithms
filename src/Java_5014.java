import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_5014 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken()); // 가장 높은 층
        int S = Integer.parseInt(st.nextToken()); // 지금 있는 층
        int G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 층
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[1000001];
        Queue<Integer> que = new LinkedList<>();
        que.add(S);
        int cnt=0;
        boolean depart = false;
        visited[S]=true;
        que: while(!que.isEmpty()){
            int size= que.size();
            for (int i = 0; i <size ; i++) {
                int current = que.poll();
                if(current==G) {
                    depart=true;
                    break que;
                }

                if(current+U<=F&&!visited[current+U]) {
                    que.add(current+U);
                    visited[current+U]=true;
                }
                if(current-D>=1&&!visited[current-D]) {
                    que.add(current-D);
                    visited[current-D]=true;
                }
            }
            cnt++;
        }
        if(depart) System.out.println(cnt);
        else System.out.println("use the stairs");
    }
}
