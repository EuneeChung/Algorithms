package src;

import java.util.Scanner;

public class Java_1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int cnt = 0;

        while (N > 0) {
            int half = (int) Math.pow(2, --N);

            if (r < half && c >= half) { // 2구역
                cnt += half * half;
                c -= half;
            }
            if (r >= half && c < half) { // 3구역
                cnt += half * half * 2;
                r -= half;
            }
            if (r >= half && c >= half) { // 4구역
                cnt += half * half * 3;
                r -= half;
                c -= half;
            }
        }
        System.out.print(cnt);
    }
}
