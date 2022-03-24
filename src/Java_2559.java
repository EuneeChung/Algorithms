import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2559 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <N ; i++) {
            arr[i]+=arr[i-1]+Integer.parseInt(st.nextToken());
        }

        int max= Integer.MIN_VALUE;
        for (int i = 0; i <N-M ; i++) {
            max= Math.max(max,arr[i+M]-arr[i]);
        }
        System.out.println(max);
    }
}
