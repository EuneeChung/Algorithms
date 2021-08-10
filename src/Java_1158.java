package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N=sc.nextInt();
        int k=sc.nextInt();
        int startIdx=0;
        List<Integer> list = new ArrayList<Integer>(N);
        for(int i=0;i<N;i++){
            list.add(i+1);
        }

        sb.append("<");
        for(int i=0;i<N;i++){
            startIdx+=k-1;
            if(startIdx>=list.size()) startIdx=startIdx%list.size();
            sb.append(list.get(startIdx));
            list.remove(startIdx);
            if(list.size()!=0) sb.append(",").append(" ");
           }
        sb.append(">");

        System.out.println(sb);
    }
}
