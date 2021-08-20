package swea;

import java.util.Scanner;

public class SWEA_1247 {
    static int[][] positions,graph; //좌표, 그래프
    static boolean[] isSelected; // 순열 생성시 선택여부
    static int[] orders;
    static int N,min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T= sc.nextInt();

        for(int t=1;t<=T;t++){
            N=sc.nextInt()+2;

            positions = new int[N][2];
            graph=new int[N][N];
            isSelected = new boolean[N];
            orders=new int[N];
            min=Integer.MAX_VALUE;

            for(int n=0;n<N;n++){
                positions[n][0]=sc.nextInt();
                positions[n][1]=sc.nextInt();
            }

            // 그래프 생성
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i!=j) graph[i][j]=Math.abs( positions[i][0]- positions[j][0])+Math.abs( positions[i][1]- positions[j][1]);
                }
            }
            orders[0]=0; // 첫번쨰 순서 회사
            orders[N-1]=1; //마지막 순서 집
            // 순열 생성 후 순서대로 거리 계산
            perm(1);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);

    }
    static void perm(int cnt){
        if(cnt==N-1) {
            min = Math.min(min,getDistance());
            return;
        }
        for(int i=2;i<N;i++){
            if(isSelected[i]) continue;

            orders[cnt]=i;
            isSelected[i]=true;
            perm(cnt+1);
            isSelected[i]=false;
        }
    }
    static int getDistance(){
        int sum=0;

        for(int i=0; i<N-1;i++){
            sum+=graph[orders[i]][orders[i+1]];
        }
        return sum;
    }
}
