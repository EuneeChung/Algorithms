import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Java_15665 {
    static int[] num, order;
    static int N, M;
    static Set<String> set = new LinkedHashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        num = new int[N];
        order = new int[M];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);
        perm(0,"");
        for (String s: set) {
            System.out.println(s);
        }
    }
    static void perm(int idx,String s){
        if(idx==M){
            set.add(s.substring(0,s.length()-1));
            return;
        }
        for (int i = 0; i <N ; i++) {
            perm(idx+1,s+num[i]+" ");
        }
    }
}
