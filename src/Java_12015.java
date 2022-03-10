import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] lis = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        lis[0] = a[0];
        int idx = 0;
        for (int i = 1; i < N; i++) {
            if (lis[idx] < a[i])
                lis[++idx] = a[i];
            else {
                int left = 0, right = idx, mid = 0, answer = 0;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (lis[mid] < a[i])
                        left = mid + 1;
                    else {
                        answer = mid;
                        right = mid - 1;
                    }
                }
                lis[answer] = a[i];
            }
        }

        System.out.println(idx + 1);
    }
}
