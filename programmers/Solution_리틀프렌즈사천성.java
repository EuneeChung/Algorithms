package programmers;

import java.util.*;

public class Solution_리틀프렌즈사천성 {
    public static void main(String[] args) {
        System.out.println(solution(5, 5, new String[]{"FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE"}));
        System.out.println(solution(1, 2, new String[]{"AA"}));
        System.out.println(solution(3, 3, new String[]{"A.B", "B.A", "C.C"}));
        System.out.println(solution(1, 7, new String[]{"ABC.CBA"}));
        System.out.println(solution(6, 1, new String[]{"A", "B", "E", "E", "B", "A"}));
        System.out.println(solution(4, 4, new String[]{"A..C", "..CB", "B...", "...A"}));
        System.out.println(solution(3, 3, new String[]{"CCB", "A.B", "AEE"}));
    }

    static char[][] originMap;
    static char[][] map;
    static char[] spells;
    static char[] order;
    static boolean[] used;
    static int R, M, N;
    static boolean isFirst;
    static String answer;
    static HashMap<String, int[]> posMap;

    public static String solution(int m, int n, String[] board) {
        answer = "IMPOSSIBLE";
        String spell = "";
        M = m;
        N = n;
        isFirst = false;
        map = new char[M][N];
        originMap = new char[M][N];
        posMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                originMap[i][j] = board[i].charAt(j);
                if (originMap[i][j] != '.' && originMap[i][j] != '*') {
                    if (!spell.contains(originMap[i][j] + "")) {
                        spell += originMap[i][j];
                        posMap.put(originMap[i][j] + "", new int[]{i, j, 0, 0});
                    } else {
                        posMap.get(originMap[i][j] + "")[2] = i;
                        posMap.get(originMap[i][j] + "")[3] = j;
                    }
                }

                map[i][j] = originMap[i][j];
            }
        }
        spells = spell.toCharArray();
        Arrays.sort(spells);
        R = spells.length;
        order = new char[R];
        used = new boolean[R];
        perm(0);

        return answer;
    }

    public static void perm(int idx) {
        if (isFirst) return;
        if (idx == R) {
            StringBuilder sb = new StringBuilder();
            for (char c : order) {
                sb.append(c);
            }
            answer = sb.toString();
//            isFirst = true;
            return;
        }

        for (int i = 0; i < R; i++) {
            if (used[i]) continue;
            if (!findPair(spells[i])) continue;
            order[idx] = spells[i];
            used[i] = true;
            perm(idx + 1);
            // 순열이 오름차순으로 진행하기 때문에, 갈 수 있는 카드가 있다면, 그 자리는 픽스
            // 첫 번째 테스트 케이스에서 처음으로 제거 가능한 타일은 A와 C이다.
            // 오름차순으로 정렬 후 진행하기 때문에 제거 가능한 타일을 만나면 그 즉시 제거
            // 다시 되돌아와서 (주석부분) 함수를 계속 보내니까 시간초과 발생
            // 필요한 로직인지 다시 한번 깊게 생각해보고 짜자
//            used[i] = false;
//            reDraw(spells[i]);
            // 카드를 고르면 다시 그 자리는 픽스했기 때문에, 주석 코드는 필요없음..
        }
    }
//
//    public static void reDraw(char tileType) {
//        int[] pos = posMap.get(tileType + "");
//        map[pos[0]][pos[1]] = tileType;
//        map[pos[2]][pos[3]] = tileType;
//    }

    public static boolean findPair(char tileType) {

        int[] pos = posMap.get(tileType + "");
        int i = pos[0];
        int j = pos[1];
        int targerI = pos[2];
        int targerJ = pos[3];

        Queue<int[]> que = new LinkedList<>();

        int difx = targerI - i;
        if (difx > 0) difx = 1;
        if (difx < 0) difx = -1;
        int dify = targerJ - j;
        if (dify > 0) dify = 1;
        if (dify < 0) dify = -1;

        for (int k = 0; k < 2; k++) {
            que.clear();
            que.add(new int[]{i, j});
            while (!que.isEmpty()) {
                int[] current = que.poll();
                if (targerI == current[0] && targerJ == current[1]) {
                    map[i][j] = '.';
                    map[current[0]][current[1]] = '.';
                    return true;
                }
                int ti = current[0];
                int tj = current[1];
                if(k==0){
                    if (targerI == current[0]) { // 행이같을때,열움직이기
                        tj += dify;
                    } else { // 여기가 처음 ! 행 움직이기
                        ti += difx;
                    }
                }
                else{
                    if (targerJ == current[1]) { // 열부터 움직였고, 열이 같을떄 행 움직이기
                        ti += difx;
                    } else { // 여기가 처음 ! 열 움직이기
                        tj += dify;
                    }
                }
                if (map[ti][tj] != '.' && map[ti][tj] != tileType)break;
                que.add(new int[]{ti, tj});
            }
        }
        return false;
    }
}
