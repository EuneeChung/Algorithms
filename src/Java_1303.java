package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Java_1303 {
    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] map = new char[M][N];
        for (int i = 0; i < M; i++) {
            map[i] = br.readLine().toCharArray();
        }
        parents = new int[N*M];
        make();

        for (int i = 0; i <M ; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int tx = i+dx[d];
                    int ty = j+dy[d];
                    if(tx<0 || tx>=M || ty <0 || ty>=N) continue;
                    if(map[i][j]==map[tx][ty]) union(i*N+j, tx*N+ty);
                }
            }
        }
        int p=0;
        HashMap<Integer, List<Integer>> countMap = new HashMap<>();
        for (int i = 0; i <M ; i++) {
            for (int j = 0; j < N; j++) {
                p =find(i*N+j);
                if(!countMap.containsKey(p)) countMap.put(p, new ArrayList<>());
                countMap.get(p).add(i*N+j);

            }
        }
        int B =0;
        int W=0;
        Iterator<Integer> keys = countMap.keySet().iterator();
        while (keys.hasNext()){
            Integer key = keys.next();
            Long power = Math.round(Math.pow(countMap.get(key).size(),2));
            if(map[key/N][key%N]=='B') B+=power;
            else W+=power;
        }
        System.out.print(W+" "+B);

    }

    static void make() {
        // 자기 자신이 대표
        for (int i = 0; i < N * M; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if (a == parents[a]) return a; //  자신이 대표자
        return parents[a]= find(parents[a]); // 자신이 속한 집합의 대표자- 부모
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot==bRoot) return false; // 이미 같은 집합
        parents[bRoot]=aRoot;
        return true;
    }
}
