import java.util.Arrays;
import java.util.Scanner;

public class Java_15654 {
    static int[] num, order;
    static int N, M;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        num = new int[N];
        order = new int[M];
        isSelected = new boolean[N];
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
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;
            isSelected[i]=true;
            order[cnt]=num[i];
            perm(cnt+1);
            isSelected[i]=false;
        }
    }
}
