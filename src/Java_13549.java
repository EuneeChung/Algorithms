import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_13549 {
    static Queue<Integer> que;
    static int length, K;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();
        length = 100001;
        dp = new int[length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        que = new LinkedList<>();
        int[] step = {1, -1};
        int time = 0;
        if(!add(N, time)) {
            find: while (!que.isEmpty()) {
                int size = que.size();
                time++;
                for (int i = 0; i < size; i++) {
                    int a = que.poll();
                    for (int j = 0; j < 2; j++) {
                        int aStep = a + step[j];
                        if (isValidate(aStep)) {
                            if (add(aStep, time)) break find;
                        }
                    }
                }
            }
        }
        System.out.println(time);
    }

    public static boolean add(int a, int time) {
        if (a >= length) return false;

        if (isValidate(a)) {
            que.add(a);
            dp[a] = time;
            if (a == K) return true;
        }
        return a != 0 ? add(2 * a, time) : a==K;
    }

    public static boolean isValidate(int a) {
        return a >= 0 && a < length && dp[a] == Integer.MAX_VALUE;
    }
}
