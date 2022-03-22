import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_2512 {
    static int[] requests;
    static int totalBudget;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        requests = new int[N];
        for (int i = 0; i < N; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
        }
        totalBudget = Integer.parseInt(br.readLine());

        int upperLimit = 0, left = 1, right = totalBudget;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canhandle(mid)) {
                left = mid + 1;
                upperLimit = mid;
            } else right = mid - 1;

        }
        int maxBudget = 0;
        for (int r : requests)
            if(upperLimit>=r) maxBudget = Math.max(r, maxBudget);
            else maxBudget=Math.max(upperLimit,maxBudget);
        System.out.println(maxBudget);
    }

    public static boolean canhandle(int limit) {
        int sum = 0;
        for (int r : requests)
            sum += Math.min(r, limit);
        return totalBudget >= sum;
    }
}
