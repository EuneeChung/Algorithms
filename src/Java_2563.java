package src;

import java.util.Scanner;

public class Java_2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int area = 0;

        boolean[][] paper = new boolean[100][100];
        for (int t = 0; t < N; t++) {
            int a= sc.nextInt();
            int b= sc.nextInt();
            for(int i=a;i<a+10;i++){
                for(int j=b;j<b+10;j++){
                    paper[i][j]=true;
                }
            }
        }


        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(paper[i][j]) area++;
            }
        }

        System.out.println(area);
    }
}
