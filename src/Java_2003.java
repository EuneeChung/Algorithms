import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2003 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        int cnt=0;
        for (int i = 0; i < N ; i++) {
            A[i]=Integer.parseInt(st.nextToken());
        }
        outer: for (int i = 0; i <N ; i++) {
            int sum=0;
            for (int j = i; j <N ; j++) {
                sum+=A[j];
                if(sum==M) cnt++;
                if(sum>=M) continue outer;
            }
        }
        System.out.println(cnt);
    }
}
