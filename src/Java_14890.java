package src;

import java.util.Scanner;

public class Java_14890 {
    static int N,L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L=sc.nextInt();
        int[][] map = new int[N][N];
        int[][] map2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j]= sc.nextInt();
                map2[j][i]=map[i][j];
            }
         } // 입력
        int road=0;

        for (int i = 0; i <N ; i++) {
            if(isPossibleRoad(map[i]))road++;
            if(isPossibleRoad(map2[i]))road++;
        }
        System.out.print(road);

    }
    static boolean isPossibleRoad(int[] map){
        int previousH=map[0],cnt=1,j=1;

        while (j<N){
            if(previousH==map[j]){
                cnt++;
                j++;
            }
            else if(previousH>map[j]){ // 내리막길
                if(previousH-map[j]!=1)return false;
                previousH=map[j];
                int currentH=map[j];
                for (int i = j; i <L+j ; i++) {
                    if(i>=N ||currentH!=map[i]) return false;
                }
                cnt=0;
                j+=L;
            }
            else if(previousH<map[j]){ // 오르막길
                if(map[j]-previousH!=1)return false;
                if(L<=cnt){
                    previousH=map[j];
                    cnt=1;
                    j++;
                }
                else return false;
            }
            if(j==N) break;
        }
        return true;
    }
}
