import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_12738 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] increases = new int[N];
        int lastIdx=0;
        increases[0]=arr[0];
        for (int a : arr) {
            if (a > increases[lastIdx]) {
                increases[++lastIdx]=a;
            }
            else {
                int left = 0, right =lastIdx,idx=0;
                while (left<=right){
                    int mid = (left+right)/2;
                    if(a>increases[mid])
                        left=mid+1;
                    else {
                        right=mid-1;
                        idx=mid;
                    }
                }
                increases[idx]=a;
            }
        }
        System.out.println(lastIdx+1);
    }
}
