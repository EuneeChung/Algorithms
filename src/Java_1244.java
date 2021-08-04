package src;

import java.util.Scanner;

public class Java_1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int switchN=sc.nextInt();
        boolean[] switches = new boolean[switchN+1];

        for(int n=1;n<=switchN;n++){
            switches[n]= (sc.nextInt() != 0);
        }

        int personN =sc.nextInt();

        for(int p=0;p<personN;p++){
            if(sc.nextInt()==1){//man
                int mIndex = sc.nextInt();

                for(int x=1;x<=switchN/mIndex;x++){

                    switches[mIndex*x]=!switches[mIndex*x];
                }

            }else{ // woman
                int wIndex = sc.nextInt();
                int range=0;

                if(wIndex-1<switchN-wIndex) range=wIndex-1;
                else range=switchN-wIndex;

                switches[wIndex]=!switches[wIndex];

                for(int i=1;i<=range;i++){
                    if(switches[wIndex-i]==switches[wIndex+i]){
                        switches[wIndex-i]=!switches[wIndex-i];
                        switches[wIndex+i]=!switches[wIndex+i];
                    }else break;
                }

            }
        }


        for(int s=1;s<=switchN;s++){
            if(switches[s]) System.out.print(1);
            else System.out.print(0);

            if(s%20==0) System.out.println();
            else if(s!=switchN) System.out.print(" ");
        }

    }
}
