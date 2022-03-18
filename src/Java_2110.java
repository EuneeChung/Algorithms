import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_2110 {
    static int[] houses;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);
        int left = 0, right = houses[N - 1];
        int mid=0,max=0;
        while(left<=right){
            mid = (left+right)/2;
            if(getAvailableCnt(mid)>=cnt){
                left=mid+1;
                max=mid;
            }
            else right=mid-1;
        }
        System.out.println(max);
    }

    public static int getAvailableCnt(int maxDistance) {
        int posIdx=0;
        int cnt=1;
        boolean canInstall=true;
        while(canInstall){
            int tmp=posIdx;
            for (int i = posIdx+1; i <N; i++) {
                if(houses[i]-houses[posIdx]>=maxDistance){
                    posIdx=i;
                    cnt++;
                    break;
                }
            }
            if(tmp==posIdx) canInstall=false;
        }
        return cnt;
    }
}
