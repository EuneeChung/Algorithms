import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2805 {
    static int M;
    static int[] trees;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        long left=0, right=0,midH=0;
        for (int i = 0; i <N; i++) {
            trees[i]=Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]);
        }

        while(left+1<right){
            midH = (left+right)/2;
            if(check(midH)) left =midH;
            else right=midH;
        }
        System.out.println(left);

    }
    // 결정문제
    // height 를 기준으로 잘랐을 경우 M 길이 이상의 나무를 얻을 수 있는지?
    // height 길이가 짧을 수록 더 많은 길이의 나무를 얻을 수 있음
    // 범위 left TTTTTTT FFFFFFFF right
    public static boolean check(long height){
        long length = 0;
        for (int t : trees) {
            if(t>height) length+= t-height;
        }
        return length>=M;
    }

    /* Solution 1
    *
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
    */
}