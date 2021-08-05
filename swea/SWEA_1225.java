package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {
    public static void main(String[] args) {
        solution1Array();
//        solution2Queue();
    }

    private static void solution1Array(){
        Scanner sc = new Scanner(System.in);

        while(true){
            int t =sc.nextInt();

            int[] cryptos = new int[8];
            int top=0;
            int cycle=1;
            for(int i=0;i<8;i++){
                cryptos[i]=sc.nextInt();
            }

            while(true){
                if(top==8) top=0;
                if(cycle==6) cycle=1;

                cryptos[top]-=cycle;
                if(cryptos[top]<=0) {
                    cryptos[top]=0;
                    break;
                }
                top++;
                cycle++;
            }

            System.out.print("#"+t);
            for(int i=top+1;i<8;i++){
                System.out.print(" "+cryptos[i]);
            }
            for(int i=0;i<=top;i++){
                System.out.print(" "+cryptos[i]);
            }
            System.out.println();
            if(t==10) break;
        }
    }

    private static void solution2Queue(){
        Scanner sc = new Scanner(System.in);

        while(true){
            int t =sc.nextInt();
            Queue<Integer> queue = new LinkedList<Integer>();

            int cycle=1;
            for(int i=0;i<8;i++){
                queue.add(sc.nextInt());
            }

            while(true){

                if(cycle==6) cycle=1;

                int temp = queue.poll();
                temp-=cycle;

                if(temp <=0) {
                    queue.add(0);
                    break;
                }else queue.add(temp);

                cycle++;
            }

            System.out.print("#"+t);

            for(int i=0;i<8;i++){
                System.out.print(" "+queue.poll());
            }
            System.out.println();
            if(t==10) break;
        }

    }
}
