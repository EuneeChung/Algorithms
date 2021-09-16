package swea;

import java.util.Scanner;

public class SWEA_3307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        int N,max;
        int[] arr;
        int[] LIS;

        for (int t = 1; t <=T ; t++) {
            N = sc.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            LIS = new int[N];
            max = 0;
            for (int i = 0; i < N; i++) {
                LIS[i]=1;
                for (int j = 0; j < i; j++) {
                    if(arr[j]<arr[i] && LIS[i]< LIS[j]+1){
                        LIS[i]= LIS[j]+1;
                    }
                }
                if(max < LIS[i]) max = LIS[i];
            }
          sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}
