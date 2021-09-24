package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_9205 {
    static ArrayList<int[]> cu;
    static int  fx, fy;
    static boolean isHappy = false;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            isHappy=false;
            int N = sc.nextInt();
            cu = new ArrayList<>();
            visited = new boolean[N+1];

            for (int i = 0; i < N+1 ; i++) {
                cu.add(new int[]{sc.nextInt(), sc.nextInt()});
            }
            fx = sc.nextInt();
            fy = sc.nextInt();

            dfs(0);
            if(isHappy) sb.append("happy\n");
            else sb.append("sad\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }

    private static void dfs(int start) {
        if(isHappy) return;
        visited[start]=true;
        if( getDistance(cu.get(start)[0],fx,cu.get(start)[1],fy)<=1000) {
            isHappy = true;
            return;
        }
        for (int i = 0; i <cu.size() ; i++) {
            if(i==start) continue;
            if(visited[i]) continue;
            if(getDistance(cu.get(start)[0],cu.get(i)[0],cu.get(start)[1],cu.get(i)[1])<=1000) dfs(i);
        }
    }
    static int getDistance(int x1, int x2, int y1, int y2){
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}
