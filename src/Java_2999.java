package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cryptos = br.readLine();

        StringBuilder sb = new StringBuilder();
        int N = cryptos.length();
        int r = 1;
        int c = N;

        while (r < c) {
            if (N % r == 0) c = N / r;
            r++;
        }

        r = N / c;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(cryptos.charAt(r * j + i));
            }
        }
        System.out.print(sb);
    }
}
