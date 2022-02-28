import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_1920 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] mArray = new int[M];
        for (int i = 0; i <M ; i++) {
            mArray[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <M ; i++) {
            sb.append(binarySearch(mArray[i],nums)).append("\n");
        }
        System.out.print(sb);

    }
    public static int binarySearch(int key, int[] arr){
        int mid =0;
        int left =0;
        int right = arr.length-1;
        while(left <= right){
            mid = (left+right)/2;

            if(key==arr[mid]) return 1;
            if(key < arr[mid]) right=mid-1;
            else left = mid+1;
        }
        return 0;
    }
}
