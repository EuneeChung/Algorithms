import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_10815 {
    static int[] haveCards;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        haveCards = new int[N];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            haveCards[i]=Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] doHave = new int[M];
        st =new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            doHave[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(haveCards);
        for(int h: doHave){
            sb.append(binarySearch(h)).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
    static int binarySearch(int a){
        int left =0, right = haveCards.length-1,mid=0,card=0;
        while(left+1<right){
            mid = (left+right)/2;
            if(haveCards[mid]<=a) {
                left=mid+1;
                card=haveCards[mid];
            }
            else right=mid-1;
        }
//        System.out.println(a+" "+ left+" "+right);
        return (a==card)?1:0;
    }
}
