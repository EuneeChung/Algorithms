package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Jungol_1828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        Refrigerator[] refrigerators = new Refrigerator[N];
        for(int n=0; n<N;n++){
            refrigerators[n]= new Refrigerator(sc.nextInt(), sc.nextInt());
        }

        // 높은 온도 순으로 오름차순 정렬
        Arrays.sort(refrigerators);

        //첫번째로 현재온도 설정
        int cnt=1;
        int currentHigh=refrigerators[0].highTem;

        for(int i=1;i<N;i++){
            if(refrigerators[i].lowTem>currentHigh){
                cnt++;
                currentHigh=refrigerators[i].highTem;
            }
        }

        System.out.print(cnt);

    }

    static class Refrigerator implements Comparable<Refrigerator>{
        int lowTem,highTem;
        public Refrigerator(int low, int high){
            this.lowTem=low;
            this.highTem=high;
        }

        @Override
        public int compareTo(Refrigerator o) {
            int dif=this.highTem - o.highTem;
            if(dif!=0) return dif;
            return this.lowTem-o.lowTem;
        }
    }
}
