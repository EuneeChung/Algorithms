package swea;

import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1251 {
    static double E;
    static int N;
    static int[][] islands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            if (t != 1) bw.append("\n");

            N = Integer.parseInt(br.readLine());
            islands = new int[N][2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    islands[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            E = Double.parseDouble(br.readLine());
            bw.write("#" + t + " " + Math.round(prim()*E));
        }


        bw.flush();

        bw.close();
        br.close();
    }

    static double prim() {
        double result = 0;
        double[][] adjMatrix = new double[N][N];
        double[] minEdge = new double[N];
        boolean[] visited = new boolean[N];

        //간선 생성
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                double a = Math.abs(islands[i][0] - islands[j][0]);
                double b= Math.abs(islands[i][1] - islands[j][1]);
//                double l= Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
                adjMatrix[i][j] = (Math.pow(a,2)+Math.pow(b,2));
            }
            minEdge[i] = Double.MAX_VALUE;
        }



        minEdge[0] = 0; // 임의의 시작점 0의 간선비용을 0으로 셋팅

        for (int i = 0; i < N; i++) {
            double min = Double.MAX_VALUE;
            int minVertex = -1;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minVertex = j;
                }
            }
            visited[minVertex] = true;//신장 트리에 포함시킴
            result += min;// 간선비용 누적
//            System.out.println(min);
            // 2 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
            for (int j = 0; j < N; j++) {
                if (!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]){
                    minEdge[j] = adjMatrix[minVertex][j];
                }
            }
        }

        return result;
    }
}
