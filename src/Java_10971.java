package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Java_10971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] adjMatrix = new int[N][N];
        boolean[] add = new boolean[N];
        StringTokenizer st = null;
        int[] minEdge = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }
        //prim

        int least = Integer.MAX_VALUE;
        for (int n = 0; n < N; n++) {
            Arrays.fill(add, false);
            Arrays.fill(minEdge, Integer.MAX_VALUE);
            int result = 0;
            minEdge[n] = 0;

            for (int i = 0; i < N; i++) {
                int min = Integer.MAX_VALUE;
                int minVertex = -1;
                for (int j = 0; j < N; j++) {

                    if (!add[j] && min > minEdge[j]) {
                        // 신장 트리에 포함되지 않은 정점
                        min = minEdge[j];
                        minVertex = j;
                    }
                }
                add[minVertex] = true; // 신장트리에 포함시킴ㅁ
                result += min; // 간선비용 누적
                // 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
                for (int j = 0; j < N; j++) {
                    if (i == N - 2 && !add[j] && adjMatrix[minVertex][j] != 0 && adjMatrix[j][n] != 0) {// 마지막 n번쨔의 가중치는 돌아오는 간선의 합까지 포함
                        minEdge[j] = adjMatrix[minVertex][j] + adjMatrix[j][n];
                        continue;
                    }
                    if (!add[j] && adjMatrix[minVertex][j] != 0) {// adjMatrix[minVertex][j] != 0 연결되지 않았으면 0임
                        minEdge[j] = adjMatrix[minVertex][j];
                    }
                }
            }
            least = Math.min(result, least);
        }
        System.out.print(least);
    }
}
