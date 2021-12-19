package src;

import java.util.Scanner;

public class Java_13325 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() + 1;
        int treeChild = (int)Math.pow(2, N);
        int[] trees = new int[treeChild];
        int[] dpTrees = new int[treeChild];
        int originalSum=0;
        for (int i = 2; i < treeChild; i++) {
            trees[i] = sc.nextInt();
            originalSum+=trees[i];
        }
        for (int i = 2; i < treeChild; i++) {
            dpTrees[i] = dpTrees[i / 2] + trees[i];
        }
        int maxSum =0;
        for (int i = treeChild/2; i < treeChild; i++) {
            maxSum=Math.max(dpTrees[i],maxSum);
        }
        for (int i = treeChild/2; i < treeChild; i++) {
            dpTrees[i]=maxSum-dpTrees[i];
        }
        int diff = 0;
        int aDif=0;
        int bDif=0;
        int min;
        for (int i = N; i > 1; i--) {
            treeChild=(int)Math.pow(2,i);
            for (int j = treeChild/2; j < treeChild; j+=2) {
                aDif=dpTrees[j];
                bDif=dpTrees[j+1];
                min=Math.min(aDif,bDif);
                dpTrees[j/2]=min;
                diff+=((aDif-min)+(bDif-min));
            }
        }
        System.out.println(diff+originalSum);
    }
}
