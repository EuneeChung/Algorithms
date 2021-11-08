package src;

import java.io.*;

public class Java_2239 {
    static int[][] map = new int[9][9]; //스도쿠 원본
    static int[] dx = {1, -1, 0, 0}; // 세로
    static int[] dy = {0, 0, 1, -1}; // 가로
    static boolean isCompleted = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
           String s= br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }
        dfs(0, 0, map);
    }

    private static void dfs(int i, int j, int[][] tempMap) throws IOException {
//        System.out.println(i+"   "+j);
        if (j == 9 && i == 8) {
            // 스도쿠 완성 프린트
            printSudoku(tempMap);
            // 다른 친구들도
            isCompleted = true;
            return;
        }
        if (isCompleted) return;
        if (j == 9) {
            i=i+1;
            j = 0;
        }
        if (tempMap[i][j] != 0) {
            dfs(i , j+1, tempMap);
            return;
        }

        for (int s = 1; s <= 9; s++) {
            if (isAlreadyRow(i, s, tempMap)) continue; // 가로 검사
            if (isAlreadyColumn(j, s, tempMap)) continue; // 세로 검사
            if (isAlreadyBox(i,j,s,tempMap)) continue; // 3*3 검사

            tempMap[i][j] = s;
            dfs(i , j+1, tempMap);
            tempMap[i][j] = 0;
        }
    }

    private static void printSudoku(int[][] tempMap) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(String.valueOf(tempMap[i][j]));
            }
            if (i != 8) bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static boolean isAlreadyRow(int columnIndex, int s, int[][] tempMap) {

        for (int i = 0; i < 9; i++) {
            if (tempMap[columnIndex][i] == s) return true;
        }
        return false;
    }

    static boolean isAlreadyColumn(int rowIndex, int s, int[][] tempMap) {

        for (int i = 0; i < 9; i++) {
            if (tempMap[i][rowIndex] == s) return true;
        }
        return false;
    }

    static boolean isAlreadyBox(int columnIndex,int rowIndex, int s, int[][] tempMap) {
        boolean[][] checked = new boolean[3][3];
        int startN = columnIndex % 3 == 0 ? columnIndex : columnIndex % 3 == 1 ? columnIndex - 1 : columnIndex - 2;
        int startM = rowIndex % 3 == 0 ? rowIndex : rowIndex % 3 == 1 ? rowIndex - 1 : rowIndex - 2;

        for (int n = startN; n < startN + 3; n++) {
            for (int m = startM; m < startM + 3; m++) {
                for (int d = 0; d < 4; d++) {
                    int tn = n+dx[d];
                    int tm = m+dy[d];
                    if (tn < startN || tn >= startN + 3 || tm < startM || tm >= startM + 3 || checked[tn%3][tm%3]) continue;
                    checked[tn%3][tm%3]=true;
                    if (tempMap[tn][tm] == s) return true;

                }
            }
        }
        return false;
    }

}
