import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_3273 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());

        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < N - 1; i++) {
            if (a[i] > X) break;
            for (int j = i + 1; j < N; j++) {
                if (a[i] + a[j] == X) {
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
