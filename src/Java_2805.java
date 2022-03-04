import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2805 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        long left=0, right=0,midH=0;
        long answer=0;
        for (int i = 0; i <N; i++) {
            trees[i]=Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        while(left<=right){
            midH = (left+right)/2;
            long midCutTree = cutTree(midH,trees);
            if(midCutTree>=M) {
                left=midH+1;
                answer=midH;
            }
            else right=midH-1;
        }
        System.out.println(answer);

    }
    public static long cutTree(long height,int[] trees){
        long length = 0;
        for (int t : trees) {
            if(t>height) length+= t-height;
        }
        return length;
    }
}