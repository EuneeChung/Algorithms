package src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Java_1260 {
    static boolean[][] adjMatrix;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt() - 1;

        adjMatrix = new boolean[N][N];


        for (int i = 0; i < M; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            adjMatrix[from][to] = adjMatrix[to][from] = true;
        }

        boolean[] visited = new boolean[N];
        dfs(V, visited, sb);

        sb.append("\n");
        bfs(V, sb);
        System.out.print(sb);
    }

    static void dfs(int current, boolean[] visited, StringBuilder sb) {
        visited[current] = true;
        sb.append(current + 1).append(" ");

        for (int i = 0; i < N; i++) {
            if (!visited[i] && adjMatrix[current][i]) {
                dfs(i, visited, sb);
            }
        }
    }

    static void bfs(int start, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(current + 1).append(" ");

            for (int i = 0; i < N; i++) {
                if (!visited[i] && adjMatrix[current][i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}

