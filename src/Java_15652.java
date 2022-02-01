import java.util.Scanner;

public class Java_15652 {
    static int[] order;
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        order = new int[M];

        perm(0);
        System.out.print(sb);

    }
    static void perm(int cnt){
        if(cnt==M){
            for (int a:order) {
                sb.append(a).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
            return;
        }
        for (int i = 1; i <=N ; i++) {
            if(cnt==0 || order[cnt-1]<=i){
                order[cnt]=i;
                perm(cnt+1);
            }
        }
    }
}
