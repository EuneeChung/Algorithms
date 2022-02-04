import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Java_15664 {
    static int N,M;
    static int[] nums;
    static int[] orders;
    static boolean[] isSelected;
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        nums=new int[N];
        isSelected=new boolean[N];
        orders=new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        perm(0,"");
       for(String s : set){
           System.out.println(s);
       }
    }
    static void perm(int idx, String str){
        if(idx==M){
            set.add(str.substring(0,str.length()-1));
            return;
        }
        for (int i = 0; i <N ; i++) {
            if(isSelected[i]) continue;
            if((idx==0 ||orders[idx-1]<=nums[i] )&& !isSelected[i] ){
                isSelected[i]=true;
                orders[idx]=nums[i];
                perm(idx+1,str+nums[i]+" ");
                isSelected[i]=false;
            }
        }
    }
}
