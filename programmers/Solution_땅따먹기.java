package programmers;

public class Solution_땅따먹기 {
    int solution(int[][] land) {
        int N = land.length;
        int[][] dp=new int[N][4];
        int rowMax=-1;
        for(int i=0;i<N;i++){
            for(int j=0;j<4;j++){
                if(i==0) dp[i][j]=land[i][j];
                else{
                    rowMax=-1;
                    for(int c=0;c<4;c++){
                        if(j!=c) rowMax = Math.max(rowMax,dp[i-1][c]);
                    }
                    dp[i][j]=land[i][j]+rowMax;
                }
            }
        }
        int max=-1;
        for(int d : dp[N-1]){
            max=Math.max(d,max);
        }
        return max;
    }
}