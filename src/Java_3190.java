package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Java_3190 {
    static int N, dif;
    static int[][] map;
    static final int APPLE = 200,DUMMY = 1;
    static int[][] deltaL = {{0, -1, 0, 1}, {1, 0, -1, 0}};
    static int[][] deltaD = {{0, 1, 0, -1}, {1, 0, -1, 0}};
    static char[] changeDc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        int appleX = 0;
        int appleY = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            appleX = Integer.parseInt(st.nextToken()) - 1;
            appleY = Integer.parseInt(st.nextToken()) - 1;
            map[appleX][appleY] = APPLE;
        }
        int L = Integer.parseInt(br.readLine());
        int[] changeDx = new int[L];
        changeDc = new char[L];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            changeDx[i] = Integer.parseInt(st.nextToken());
            changeDc[i] = st.nextToken().charAt(0);
        }//입력 끝

        int time = 0;
        int cntL = 0;
        int cntD = 0;
        int changeIdx = 0;
        int[] deltaHead=new int[]{0,1};

        int posX = 0;
        int posY = 0;
        map[posX][posY] = DUMMY;
        deque.add(new int[]{0,0});
        int length=1;
        while (true) {
            time++;
            //머리부터 이동
            posX += deltaHead[0];
            posY += deltaHead[1];

            //벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
            if (posX < 0 || posX >= N || posY < 0 || posY >= N || map[posX][posY] == DUMMY) break;

            //만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
            if (map[posX][posY] != APPLE) {
                int[] tail = deque.pollLast();
                map[tail[0]][tail[1]]=0;
            }

            deque.addFirst(new int[]{posX,posY}); // 머리이동
            map[posX][posY] = DUMMY;

            //X초가 끝난 뒤에 방향 전환
            if(changeIdx>=changeDx.length) continue;
            if (time == changeDx[changeIdx]) {
                if (changeDc[changeIdx] == 'L') cntL++;
                if (changeDc[changeIdx] == 'D') cntD++;

                dif = cntL - cntD; // 현재 방향
                deltaHead=getDirection(dif);
                changeIdx++;
            }

        }
        System.out.print(time);
    }

    static int[] getDirection(int dif){
        int absDif = Math.abs(dif)%4;
        int[] result = new int[2];
        if (dif >= 0) {
            result[0] = deltaL[0][absDif];
            result[1] = deltaL[1][absDif];
        } else {
            result[0] = deltaD[0][absDif];
            result[1] = deltaD[1][absDif];
        }
        return result;
    }
}
