package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Java_1753 {
    static int V;
    static final int MAX = Integer.MAX_VALUE;
    static int[] distance;
    static HashMap<Integer, ArrayList<int[]>> adjList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine()) - 1;

        adjList = new HashMap<Integer, ArrayList<int[]>>();
        distance = new int[V];


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            adjList.computeIfAbsent(from, k -> new ArrayList<int[]>());
            adjList.get(from).add(new int[]{to, Integer.parseInt(st.nextToken())});
        }


        Arrays.fill(distance, MAX);
        distance[start] = 0;

        dijkstra(start);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    static void dijkstra(int start) {

        boolean[] visited = new boolean[V];

        int min = 0, current = start;
        for (int a = 0; a < V; a++) {

            min = MAX;

            for (int j = 0; j < V; ++j) {
                if (!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true;

//            if (current == end) {
//                break;
//            }

            if (adjList.containsKey(current)) {
                for (int[] node2 : adjList.get(current)) {
                    if (!visited[node2[0]] && distance[node2[0]] > node2[1] + min) {
                        distance[node2[0]] = node2[1] + min;
                    }
                }
            }
        }

        for (int d : distance) {
            if (d != MAX) sb.append(d).append("\n");
            else sb.append("INF").append("\n");

        }
    }
}
