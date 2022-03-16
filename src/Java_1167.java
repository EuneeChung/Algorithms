import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_1167 {
    static int maxDiameter = 0, N, end;
    static ArrayList<Node>[] adjMatrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()) + 1;
        adjMatrix = new ArrayList[N];
        StringTokenizer st;
        for (int v = 1; v < N; v++) {
            st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            adjMatrix[current] = new ArrayList<>();
            while (st.hasMoreTokens()) {
                int nodeNum = Integer.parseInt(st.nextToken());
                if (nodeNum == -1) break;
                adjMatrix[current].add(new Node(nodeNum, Integer.parseInt(st.nextToken())));
            }
        }

        boolean[] visited = new boolean[N];
        dfs(1, 0, visited);
        Arrays.fill(visited, false);
        maxDiameter = Integer.MIN_VALUE;
        dfs(end, 0, visited);

        System.out.println(maxDiameter);
    }

    static void dfs(int current, int diameter, boolean[] visited) {
        visited[current] = true;
        if (maxDiameter < diameter) {
            maxDiameter = diameter;
            end = current;
        }
        if (adjMatrix[current].size() == 0) return;

        for (int i = 0; i < adjMatrix[current].size(); i++) {
            if (!visited[adjMatrix[current].get(i).num]) {
                dfs(adjMatrix[current].get(i).num, diameter + adjMatrix[current].get(i).distance, visited);
            }
        }
    }

    static class Node {
        int num, distance;

        public Node(int n, int d) {
            this.num = n;
            this.distance = d;
        }
    }
}