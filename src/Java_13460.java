package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_13460 {
    static int[] hole = new int[2];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int min = Integer.MAX_VALUE;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] red = new int[2];
        int[] blue = new int[2];

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                    map[i][j]='.';
                }
                if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                    map[i][j]='.';
                }
                if (map[i][j] == 'O') {
                    hole[0] = i;
                    hole[1] = j;
                }
            }
        }
        dfs(1, red, blue);
        if(min > 10) min=-1;
        System.out.print(min);
    }

    static void dfs(int cnt, int[] red, int[] blue) {
        if (cnt > 10) return;
        if (min < cnt) return;
        int[] moveRed = new int[]{red[0], red[1]};
        int[] moveBlue = new int[]{blue[0], blue[1]};

        for (int i = 0; i < 4; i++) {

            if ((i == 0 && red[1] < blue[1]) || (i == 1 && red[1] > blue[1]) || (i == 2 && red[0] < blue[0]) || (i == 3 && red[0] > blue[0])) {
                moveBlue = move(blue, i);
                if(isHole(moveBlue)) continue;
                map[moveBlue[0]][moveBlue[1]]='B';
                moveRed = move(red, i);
                map[moveBlue[0]][moveBlue[1]]='.';//원상복귀
            } else {
                moveRed = move(red, i);
                map[moveRed[0]][moveRed[1]]='R';
                if(isHole(moveRed)) map[moveRed[0]][moveRed[1]]='O';
                moveBlue = move(blue, i);
                if(isHole(moveRed)){
                    if(isHole(moveBlue))continue;
                }else{
                    map[moveRed[0]][moveRed[1]]='.'; // 원상복귀
                }
            }

            if (isHole(moveRed)) {
                min = Math.min(min, cnt);
                continue;
            }
            if (moveBlue[0] == hole[0] && moveBlue[1] == hole[1]) continue;
            dfs(cnt+1,moveRed,moveBlue);
        }
    }
    static boolean isHole(int[] pos){
        return pos[0] == hole[0] && pos[1] == hole[1];
    }
    static int[] move(int[] pos, int type) {
        int[] movePos = new int[]{pos[0], pos[1]};
        while (true) {
            movePos[0] += dx[type];
            movePos[1] += dy[type];
            if (map[movePos[0]][movePos[1]] == 'O')  return movePos;
            if (map[movePos[0]][movePos[1]] != '.') break;
        }
        movePos[0] -= dx[type];
        movePos[1] -= dy[type];
        return movePos;
    }
}
