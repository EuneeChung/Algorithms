import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2467 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr= new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int left=0,right=N-1;
        int min = Integer.MAX_VALUE;
        int[] solutions= new int[2];

        while (left<right){
            int sum = arr[left]+arr[right];
            if(min>Math.abs(sum)) {
                solutions[0]=arr[left];
                solutions[1]=arr[right];
                min=Math.abs(sum);
            }
            if(sum>0) right--;
            if(sum<0) left++;
            if(sum==0) break;

        }
        System.out.println(solutions[0]+" "+solutions[1]);
    }
}
