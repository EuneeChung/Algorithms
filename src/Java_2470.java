import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] values = new int[N];
        int alkali = 0, acid = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(values);

        int mix = Integer.MAX_VALUE;
        int startIdx = 0;
        int endIdx = N - 1;

        while (startIdx < endIdx) {
            int diff = values[startIdx] + values[endIdx];
            if (mix > Math.abs(diff)) {
                mix = Math.abs(diff);
                alkali = values[startIdx];
                acid = values[endIdx];
            }
            if (mix == 0) break;

            if (diff > 0) endIdx--;
            else if (diff < 0) startIdx++;
        }

        System.out.println(alkali + " " + acid);
    }
}
