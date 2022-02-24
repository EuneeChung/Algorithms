import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Java_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();


        int T = Integer.parseInt(br.readLine());
        op:
        for (int t = 0; t < T; t++) {
            deque.clear();
            char[] operation = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            String array = br.readLine();
            String[] nums = array.substring(1, array.length() - 1).split(",");
            for (int n = 0; n < N; n++) {
                deque.add(Integer.parseInt(nums[n]));
            }
            boolean isAsc = true;
            for (char c : operation) {
                if (c == 'R') isAsc = !isAsc;
                if (c == 'D') {
                    if (deque.size() == 0) {
                        sb.append("error\n");
                        continue op;
                    }
                    else {
                        if(isAsc) deque.pollFirst();
                        else deque.pollLast();
                    }
                }
            }

            sb.append(convertToArrayFormat(deque,isAsc));
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static String convertToArrayFormat(Deque<Integer> deque, boolean isAsc) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            if (isAsc) sb.append(deque.pollFirst());
            else sb.append(deque.pollLast());
            sb.append(",");
        }
        if(sb.length()>2) sb.deleteCharAt(sb.length() - 1);
        sb.append("]").append("\n");
        return sb.toString();
    }
}
