import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_1654 {
    static int[] lanArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        lanArr= new int[K];
        int leftLength=1;
        int rightLength=Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            lanArr[i]=Integer.parseInt(br.readLine());
            rightLength= Math.max(rightLength, lanArr[i]);
        }
        int midLength =0,rightCnt=0;
        while(leftLength<=rightLength){
            midLength = (leftLength+rightLength)/2;
            int midCnt = getLanCnt(midLength);
            rightCnt = getLanCnt(rightLength);

            if(rightCnt>=N) break;
            if(midCnt>=N) leftLength = midLength+1;
            else rightLength =midLength-1;
        }
        System.out.println(rightLength);
    }
    public static int getLanCnt(int length){
        int cnt =0;
        for(int lan : lanArr){
            cnt += lan/length;
        }
        return cnt;
    }
}
