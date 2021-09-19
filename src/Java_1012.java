package src;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java_1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int M,N,K;
        boolean[][] map,checked;
        int m,n,count;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        Queue<int[]> queue = new LinkedList<>();
        for (int t = 0; t <T ; t++) {
            count=0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];
            checked = new boolean[N][M];
            for (int i = 0; i <K; i++) {
                st = new StringTokenizer(br.readLine());
                m = Integer.parseInt(st.nextToken());
                n = Integer.parseInt(st.nextToken());
                map[n][m]=true;
            }

            for (int i = 0; i <N ; i++) {
                for (int j = 0; j <M ; j++) {
                    if(checked[i][j]) continue;

                    checked[i][j]=true;
                    queue.clear();
                    if(map[i][j]) queue.offer(new int[]{i,j});
                    boolean exist =false;

                    while (!queue.isEmpty()){
                        int[] current = queue.poll();
                        if (!exist) {
                            count++;
                            exist=true;
                        }
                        for (int d = 0; d < 4; d++) {
                            int tx = current[0]+dx[d];
                            int ty = current[1]+dy[d];

                            if(tx<0 || tx>=N || ty<0 || ty>=M || checked[tx][ty]) continue;
                            if(map[tx][ty]){
                                queue.add(new int[]{tx,ty});
                                checked[tx][ty]=true;
                            }
                        }
                    }

                }
            }
            bw.write(String.valueOf(count));
            if(t!=T-1)bw.append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
