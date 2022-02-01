import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_17779 {
    static int minDiff = Integer.MAX_VALUE;
    static int N,sum;
    static int[][] map ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        StringTokenizer st;
        for (int i = 1; i <=N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum+=map[i][j];
            }
        }

        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <=N ; j++) {
                for (int d1 = 1; j-d1 >=1 ; d1++) {
                    for (int d2 = 1; d2+j <=N ; d2++) {
                        if(i+d1+d2<=N) minDiff = Math.min(countPopulation(i,j,d1,d2),minDiff);
                    }
                }
            }
        }
        System.out.println(minDiff);

    }
    public static int countPopulation(int x, int y, int d1, int d2){
//        System.out.print("x: "+x+"y: "+y+"d1 "+d1+"d2 "+d2+" ");
//        int[][] printMap = new int[N+1][N+1];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int[] populations = new int[5];
        boolean isBorder=false;
        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <=N ; j++) {
                if(i<x+d1 && j<=y) {
                   isBorder=false;
                    for (int k = 0; k <=d1 ; k++) {
                        if(i>=x+k && j>=y-k) isBorder=true;
                    }
                    if(!isBorder){
                        populations[0]+=map[i][j];
//                        printMap[i][j]=1;
                    }
                }
                if(i<=x+d2 && y<j) {
                    isBorder=false;
                    for (int k = 0; k <=d2 ; k++) {
                        if(i>=x+k && j<=y+k)  isBorder=true;
                    }
                    if(!isBorder){
                        populations[1]+=map[i][j];
//                        printMap[i][j]=2;
                    }
                }
                if(x+d1<=i && j<y-d1+d2) {
                    isBorder=false;
                    for (int k = 0; k <=d2 ; k++) {
                        if(i<=x+d1+k && j>=y-d1+k) isBorder=true;
                    }
                    if(!isBorder) {
                        populations[2]+=map[i][j];
//                        printMap[i][j]=3;
                    }
                }
                if(x+d2<i && y-d1+d2<=j) {
                    isBorder=false;
                    for (int k = 0; k <=d1 ; k++) {
                        if(i<=x+d2+k && j<=y+d2-k) isBorder=true;
                    }
                    if(!isBorder) {
                        populations[3]+=map[i][j];
//                        printMap[i][j]=4;
                    }
                }
            }
        }
        populations[4]= sum;
        for (int i = 0; i <4 ; i++) {
            populations[4]-=populations[i];
        }
        for (int a : populations){
            min = Math.min(min,a);
            max = Math.max(max,a);
        }
//        System.out.println(max-min);
//        System.out.println(Arrays.toString(populations));
//        for (int i = 1; i <=N ; i++) {
//            System.out.println(Arrays.toString(printMap[i]));
//        }
        return max-min;
    }
}
