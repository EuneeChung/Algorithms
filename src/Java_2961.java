package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_2961 {
    static int N,min=Integer.MAX_VALUE;
    static ArrayList<Integer> sours=new ArrayList<>();
    static ArrayList<Integer> bitters=new ArrayList<>();
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        isSelected = new boolean[N];
        for(int i=0; i<N;i++){
            sours.add(sc.nextInt());
            bitters.add(sc.nextInt());
        }

        subSet(0);
        System.out.print(min);
    }
    static void subSet(int cnt){
        if(cnt==N) {
            for(boolean b : isSelected){
                if(b) {
                    cook();
                    break;
                }
            }
          return;
        }

        isSelected[cnt]=true;
        subSet(cnt+1);
        isSelected[cnt]=false;
        subSet(cnt+1);
    }
    static void cook(){
        int tempSour=1,tempBitter=0;
        for(int i=0; i<N;i++){
            if(isSelected[i]){
                tempSour *= sours.get(i);
                tempBitter += bitters.get(i);
            }
        }
        min = Math.min(min,Math.abs(tempBitter-tempSour));
    }
}
