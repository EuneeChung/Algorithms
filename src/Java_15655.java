import java.util.Arrays;
import java.util.Scanner;

public class Java_15655 {
    static int[] num, order;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

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
        perm(0);
        System.out.print(sb);
    }

    static void perm(int cnt) {
        if (cnt == M) {
            for (int a : order) {
                sb.append(a).append(" ");
            }
            sb.deleteCharAt(sb.lastIndexOf(" "));
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(cnt==0|| order[cnt-1]<num[i]){
                order[cnt]=num[i];
                perm(cnt+1);
            }

        }
    }
}
