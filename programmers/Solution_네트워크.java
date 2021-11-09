package programmers;

public class Solution_네트워크 {
    int[] parent;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        make(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for (int a = 0; a < n; a++) {
            if (a == find(a)) answer++;
        }
        return answer;
    }

    public void make(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        if (find(a) == find(b)) return;
        int bRoot = find(b);
        parent[bRoot] = find(a);
    }
}
