import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_12851 {
    static int N,K,time;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int[] visited = new int[100001];
        Queue<Integer> que = new LinkedList<>();
        Arrays.fill(visited,Integer.MAX_VALUE);
        que.add(N);
        visited[N]=0;
        while (!que.contains(K)){
            int size = que.size();
            for (int i = 0; i <size ; i++) {
                int current = que.poll();
                int tmp=0;
                for (int j = 0; j < 3; j++) {
                    if(j ==0) tmp =current-1;
                    else if(j==1) tmp=current+1;
                    else tmp  = current*2;
                    if(tmp>=0&& tmp<100001 && visited[tmp]>=time ){
                        que.add(tmp);
                        visited[tmp]=time;
                    }
                }
            }
            time++;
        }

        int cnt=0;
        for(Integer q : que){
            if(q==K) cnt++;
        }
        System.out.println(time);
        System.out.println(cnt);
    }
}
