package src;

import java.util.Scanner;

public class Java_1463 {
    static int N,min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        make1(N,0);
        System.out.print(min);
    }
    static void make1(int cnt,int count){
        if(cnt==1){
            min=Math.min(count, min);
            return;
        }
        if(min<count) return;
        if(cnt%3==0)  make1(cnt/3,count+1);
        if(cnt%2==0)  make1(cnt/2,count+1);
        make1(cnt-1,count+1);
    }
}
