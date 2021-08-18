package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Java_2605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> order =new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            order.add(order.size()-sc.nextInt(),i);
        }

        for(int i=0;i<n;i++){
            sb.append(order.get(i)).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}
