import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Java_7662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> map = new HashMap<>();

        int T = Integer.parseInt(br.readLine());
        int N;
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            minPQ.clear();
            maxPQ.clear();
            map.clear();
            N = Integer.parseInt(br.readLine());

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                String operation = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (operation.equals("I")) {
                    maxPQ.add(num);
                    minPQ.add(num);
                    int cnt = map.getOrDefault(num, 0);
                    map.put(num, cnt + 1);
                }
                if (operation.equals("D") && map.size() != 0) {
                    if (num == -1) delete(minPQ, map);
                    else delete(maxPQ, map);
                }
            }

            if (map.size() == 0) sb.append("EMPTY");
            else {
                int maxOrMin = delete(maxPQ, map);
                sb.append(maxOrMin).append(" ");
                if (map.size() > 0) maxOrMin = delete(minPQ, map);
                sb.append(maxOrMin);
            }
            if (t != T - 1) sb.append("\n");
        }
        System.out.print(sb);
    }

    static int delete(PriorityQueue<Integer> que, HashMap<Integer, Integer> map) {
        int endNum = 0;
        while (true) {
            endNum = que.poll();
            int cnt = map.getOrDefault(endNum, 0);
            if (cnt == 0) continue;

            if (cnt == 1) map.remove(endNum);
            else map.put(endNum, cnt - 1);
            break;
        }
        return endNum;
    }
}
