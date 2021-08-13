package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_15686 {
    static int N,M,C,temp;
    static int totalMin=Integer.MAX_VALUE, min;
    static int[] chickenOrders=new int[M];
    static int[] minLengths;
    static ArrayList<int[]> houses= new ArrayList<>();
    static ArrayList<int[]> chickens= new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        chickenOrders=new int[M];
        minLengths= new int[M];

        for(int i =0; i<N;i++){
            for(int j =0; j<N;j++){
                temp=sc.nextInt();
                if(temp==1) houses.add(new int[]{i,j});
                if(temp==2) chickens.add(new int[]{i,j});
            }
        }

        N= houses.size(); // 이후 집 수를 저장
        C=chickens.size();
        combChickenOrder(0,0);
        System.out.print(totalMin);
    }


    static void combChickenOrder(int cnt, int start){
        if(cnt==M) {
            // 치킨 거리 구하기
            getLength(chickenOrders);
            return;
        }
        for (int i=start;i<C;i++){
            chickenOrders[cnt]=i;
            combChickenOrder(cnt+1,i+1);
        }
    }
    static void getLength(int[] orders){
        int sum =0;
        int houseX;
        int houseY;

        for(int i=0; i<N;i++){
            min=Integer.MAX_VALUE;
            houseX=houses.get(i)[0];
            houseY=houses.get(i)[1];

            for(int j=0;j<M;j++){
                temp = Math.abs(chickens.get(orders[j])[0]-houseX)+Math.abs(chickens.get(orders[j])[1]-houseY);
                min=Math.min(min,temp);
            }
            sum+=min;
        }
        totalMin=Math.min(sum,totalMin);
    }
}
