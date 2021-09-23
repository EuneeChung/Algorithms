package src;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;


public class Java_2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for (int i = 0; i <N ; i++) {
            map[i]=br.readLine().toCharArray();
        }
        bfs(map);
        br.close();
    }
    static void bfs(char[][] map) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> counts = new ArrayList<>();
        int n = map.length;
        boolean[][] checked = new boolean[n][n];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int houseCnt =0;
        int complexCnt =0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(checked[i][j]) continue;

                if(houseCnt!=0){
                    counts.add(houseCnt);
                    houseCnt=0;
                }

                queue.clear();
                houseCnt=0;
                checked[i][j] = true;
                if(map[i][j]=='1') {
                    houseCnt++;
                    queue.add(i*n+j);
                    complexCnt++;
                }
                while (! queue.isEmpty()){
                    int current = queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int tx = current/n+dx[d];
                        int ty = current%n+dy[d];

                        if(tx<0 || tx>=n || ty<0 || ty>=n || checked[tx][ty]) continue;
                        if(map[tx][ty]=='1'){
                            checked[tx][ty]=true;
                            queue.add(tx*n+ty);
                            houseCnt++;
                        }
                    }
                }
            }
        }
        if(houseCnt!=0){
            counts.add(houseCnt);
            houseCnt=0;
        }
        bw.write(complexCnt+"\n");

        counts.sort(Comparator.naturalOrder());
        for (int i = 0; i < counts.size(); i++) {
            if(i != counts.size()-1) bw.write(counts.get(i)+"\n");
            else bw.append(String.valueOf(counts.get(i)));
        }
        bw.flush();
        bw.close();
    }
}
