import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Java_15663 {

    static int N,M;
    static int[] nums;
    static boolean[] isSelected;
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums=new int[N];
        isSelected=new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            nums[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        perm(0,"");
        for(String i : set){
            System.out.println(i);
        }
    }
    static void perm(int idx,String order){
        if(idx==M){
           set.add(order.substring(0,order.length()-1));
            return;
        }
        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;
            isSelected[i]=true;
            perm(idx+1,order+nums[i]+" ");
            isSelected[i]=false;
        }
    }
}