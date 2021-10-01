package swea;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4013 {
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[] visited = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int K;
        int[][] map = new int[4][8];
        int[][] rotateMap = new int[4][8];
        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int k = 1; k <= K; k++) {
                st = new StringTokenizer(br.readLine());
                if (k % 2 == 1)
                    bfs(map, rotateMap, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
                else bfs(rotateMap, map, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            }

            int finalScore = 0;
            if (K % 2 == 1) finalScore = sumScore(rotateMap);
            else finalScore = sumScore(map);

            if (t != 1) bw.newLine();
            bw.write("#" + t + " " + finalScore);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int[][] map, int[][] rotateMap, int index, int rotateType) {
        queue.clear();
        Arrays.fill(visited, false);

        queue.add(new int[]{index, rotateType}); // 시작점 입력
        // 맨 처음 해당 인덱스 번호 돌리기
        rotate(map[index], rotateMap[index], rotateType);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            index = now[0]; // 인덱스 값 현재 큐에 있는 값으로 갱신

            int nextRotateType;
            if (now[1] == 1) nextRotateType = -1;
            else nextRotateType = 1;

            // 앞
            if (index + 1 < 4 && (map[index][2] - map[index + 1][6] != 0 && !visited[index + 1])) {
                rotate(map[index + 1], rotateMap[index + 1], nextRotateType);
                queue.add(new int[]{index + 1, nextRotateType});
                visited[index + 1] = true;
            }

            // 뒤
            if (index - 1 >= 0 && (map[index - 1][2] - map[index][6] != 0) && !visited[index - 1]) {
                rotate(map[index - 1], rotateMap[index - 1], nextRotateType);
                queue.add(new int[]{index - 1, nextRotateType});
                visited[index - 1] = true;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (!visited[i]) {
                for (int j = 0; j < 8; j++) {
                    rotateMap[i][j] = map[i][j];
                }
            }
        }
    }

    static void rotate(int[] mapLine, int[] rotateMapLine, int rotateType) {
        int startIdx;
        if (rotateType == 1) {
            startIdx = 0;
            rotateMapLine[0] = mapLine[7];
        } else {
            startIdx = 7;
            rotateMapLine[7] = mapLine[0];
        }
        for (int i = startIdx; (i < 7 && rotateType == 1) || (i > 0 && rotateType == -1); i += rotateType) {
            rotateMapLine[i + rotateType] = mapLine[i];
        }

    }

    static int sumScore(int[][] countMap) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (countMap[i][0] == 1) sum += Math.pow(2, i);
        }
        return sum;
    }
}
