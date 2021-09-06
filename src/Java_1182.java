package src;

import java.util.Scanner;

public class Java_1182 {
    static int[] list;
    static int S, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        S = sc.nextInt();
        list = new int[N];
        boolean[] isSelected = new boolean[N];


        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }
        subset(isSelected,0);
        System.out.print(count);

    }

    static void subset(boolean[] isSelected, int cnt) {
        if (cnt >= isSelected.length) {
            int sum = 0, n = 0;
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i]) {
                    sum += list[i];
                    n++;
                }
            }
            if (sum == S && n>0) count ++;
            return;
        }
        isSelected[cnt] = true;
        subset(isSelected, cnt + 1);
        isSelected[cnt] = false;
        subset(isSelected, cnt + 1);
    }

}
