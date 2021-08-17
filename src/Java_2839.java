package src;

import java.util.Scanner;

public class Java_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sugar = sc.nextInt();
        int num = 0;

        while(sugar>0){
            if(sugar%5==0)  {
                num+=sugar/5;
                sugar=0;
                break;
            }

            sugar-=3;
            num++;
        }
        if(sugar<0) num =-1;
        System.out.print(num);
    }
}
