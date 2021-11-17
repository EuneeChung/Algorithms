package src;

import java.util.Scanner;

public class Java_6603 {
    static StringBuilder sb = new StringBuilder();
    static int K;
    static int[] nums;
    static int[] lotto=new int[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFirst = false;
        while(true){
            K = sc.nextInt();
            if(K==0) break;

            nums=new int[K];
            for (int i = 0; i <K ; i++) {
                nums[i]=sc.nextInt();
            }
            if(isFirst) sb.append("\n");
            else isFirst = true;
            comb(0,0);
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
    }
    public static void comb(int start, int cnt){
        if(cnt==6){
            print();
            return;
        }
        if(start==K) return;

        for (int i = start; i < K; i++) {
            lotto[cnt]=nums[i];
            comb(i+1,cnt+1);
        }
    }
    public static void print(){
        for (int i = 0; i < 6 ;i++) {
            sb.append(lotto[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1).append("\n");
    }
}
