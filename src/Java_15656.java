import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_15656 {
    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] nums;
    static int[] orders;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums=new int[N];
        orders=new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            nums[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        perm(0);
        System.out.print(sb);
    }
    static void perm(int idx){
        if(idx==M){
            for(int a : orders){
                sb.append(a).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            orders[idx]=nums[i];
            perm(idx+1);
        }
    }
}
