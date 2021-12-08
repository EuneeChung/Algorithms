package src;

import java.util.Scanner;

public class Java_13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] applicants =new int[N];
        for (int i = 0; i < N; i++) {
           applicants[i]=sc.nextInt();
        }
        int B = sc.nextInt();
        int C = sc.nextInt();
        long sum = N;

        for (int i = 0; i < N; i++) {
            if(applicants[i]>B) applicants[i] -=B;
            else applicants[i]=0;
        }
        for (int i = 0; i < N; i++) {
            sum+=applicants[i]/C;
            if(applicants[i]%C!=0) sum++;
        }
        System.out.print(sum);
    }
}
