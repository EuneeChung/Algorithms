package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Java_12927 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        String state = "Y" + br.readLine();

        int N = state.length();
        boolean[] current = new boolean[N];
        for (int i = 1; i < N; i++) {
            current[i] = state.charAt(i) == 'Y';
        }

        boolean[] allOff = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            if (current[i] != allOff[i]) {
                turnOnOff(i, current);
                cnt++;
                if (isSame(current, allOff)) break;
            }
        }
        if (!isSame(current, allOff)) cnt = -1;
        System.out.print(cnt);
    }

    static void turnOnOff(int a, boolean[] led) {
        for (int i = 1; i < led.length; i++) {
            if (i % a == 0) led[i] = !led[i];
        }
    }

    static boolean isSame(boolean[] original, boolean[] newled) {
        for (int i = 1; i < original.length; i++) {
            if (original[i] != newled[i]) return false;
        }
        return true;
    }
}
