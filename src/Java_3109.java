package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_3109 {
    static char[][] map;
    static int[] dx = {-1, 0, 1}; // 왼쪽 대각선 위 , 직진, 왼쪽쪽 대각선 아래

    static int R,C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        int cnt =0;
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <R ; i++) {
            cnt+=dfs(i,0);
        }
        System.out.print(cnt);

    }
    public static int dfs( int i, int j){
        // i , j 위치
        if(j==C-1) return 1;// 오른쪽 끝에 도착했으므로 cnt 증가

        for (int d = 0; d < 3; d++) {
            int ti = i+dx[d];
            int tj = j+1;
            if(ti>=0 && ti<R && tj<C && map[ti][tj]=='.') {
                // 유효 범위이고 가스관을 설치할 수 있으면
                map[ti][tj]='x';
                // return dfs(ti,tj); // 이렇게 하면 다음 재귀에서 실패했을때 백트래킹을 못함.
                if(dfs(ti,tj) == 1) return 1;
            }
        }
        // 오른쪽으로 갈곳이 없다면, 그 다음행 가스관 설치 시작.
        return 0;
    }
}
