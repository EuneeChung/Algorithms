package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Java_17140 {
    static int maxR = 2, maxC = 2, time = 0;
    static int r, c, k;
    static int[][] map = new int[100][100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (map[r][c] != k) {
            if (time > 100) break;
            if (maxR >= maxC) operateR();
            else operateC();
            time++;
        }
        if (time > 100) time = -1;
        System.out.println(time);
    }

    public static void operateR() {
        HashMap<Integer, Integer> pairMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i <= maxR; i++) {
            pairMap.clear();
            for (int j = 0; j <= maxC; j++) {
                int current = map[i][j];
                map[i][j] = 0;
                int cnt = 0;
                if (current != 0) {
                    if (pairMap.containsKey(current)) cnt = pairMap.get(current);
                    pairMap.put(current, cnt + 1);
                }
            }

            for (Integer key : pairMap.keySet()) {
                Pair p = new Pair(key, pairMap.get(key));
                pq.add(p);
            }
            int idx = -1;
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                map[i][++idx] = p.num;
                map[i][++idx] = p.cnt;
                if (idx >= 98) break;
            }
            maxC = Math.max(maxC, idx);
        }
    }

    public static void operateC() {
        HashMap<Integer, Integer> pairMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int j = 0; j <= maxC; j++) {
            pairMap.clear();
            for (int i = 0; i <= maxR; i++) {
                int current = map[i][j];
                map[i][j] = 0;
                if (current != 0) {
                    int cnt = 0;
                    if (pairMap.containsKey(current)) cnt = pairMap.get(current);
                    pairMap.put(current, cnt + 1);
                }
            }

            for (Integer key : pairMap.keySet()) {
                Pair p = new Pair(key, pairMap.get(key));
                pq.add(p);
            }
            int idx = -1;
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                map[++idx][j] = p.num;
                map[++idx][j] = p.cnt;
                if (idx >= 98) break;
            }
            maxR = Math.max(maxR,idx);
        }
    }

    static class Pair implements Comparable<Pair> {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.cnt = cnt;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.cnt==o.cnt) return this.num-o.num;
            else return this.cnt - o.cnt;
        }
    }
}
